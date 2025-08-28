package com.pyaesonehan.phayarsar.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.pyaesonehan.phayarsar.R
import com.pyaesonehan.phayarsar.domain.model.Detail
import com.pyaesonehan.phayarsar.presentation.core.components.ErrorView
import com.pyaesonehan.phayarsar.presentation.core.components.LoadingView
import com.pyaesonehan.phayarsar.presentation.core.preview.PreviewData
import com.pyaesonehan.phayarsar.presentation.core.preview.PreviewWithTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenView(
    modifier: Modifier = Modifier,
    detailUiState: DetailViewModel.Companion.DetailUiState,
    onRetry: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                scrollBehavior = topAppBarScrollBehavior
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when(detailUiState) {
                is DetailViewModel.Companion.DetailUiState.Loading -> {
                    LoadingView()
                }
                is DetailViewModel.Companion.DetailUiState.Failure -> {
                    ErrorView(
                        onRetry = onRetry
                    )
                }
                is DetailViewModel.Companion.DetailUiState.Success -> {
                    DetailView(
                        detail = detailUiState.detail
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailView(
    modifier: Modifier = Modifier,
    detail: Detail
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(
                state = rememberScrollState()
            ),
    ) {
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = detail.title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = detail.content,
            lineHeight = 2.em
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun DetailScreenViewLoadingPreview() {
    PreviewWithTheme(false) {
        DetailScreenView(
            detailUiState = DetailViewModel.Companion.DetailUiState.Loading
        )
    }
}

@PreviewLightDark
@Composable
private fun DetailScreenViewFailurePreview() {
    PreviewWithTheme(false) {
        DetailScreenView(
            detailUiState = DetailViewModel.Companion.DetailUiState.Failure
        )
    }
}

@PreviewLightDark
@Composable
private fun DetailScreenViewSuccessPreview() {
    PreviewWithTheme(false) {
        DetailScreenView(
            detailUiState = DetailViewModel.Companion.DetailUiState.Success(
                detail = PreviewData.detail
            )
        )
    }
}