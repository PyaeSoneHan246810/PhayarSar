package com.pyaesonehan.phayarsar.presentation.groups

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.pyaesonehan.phayarsar.domain.model.Group
import com.pyaesonehan.phayarsar.presentation.core.components.ErrorView
import com.pyaesonehan.phayarsar.presentation.core.components.LoadingView
import com.pyaesonehan.phayarsar.presentation.core.preview.PreviewData
import com.pyaesonehan.phayarsar.presentation.core.preview.PreviewWithTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupsScreenView(
    modifier: Modifier = Modifier,
    groupsUiState: GroupsViewModel.Companion.GroupsUiState,
    onRetry: () -> Unit = {},
    onItemClick: (groupId: Int, detailId: Int) -> Unit = {_, _ ->}
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name)
                    )
                },
                scrollBehavior = topAppBarScrollBehavior
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when(groupsUiState) {
                is GroupsViewModel.Companion.GroupsUiState.Loading -> {
                    LoadingView()
                }
                is GroupsViewModel.Companion.GroupsUiState.Failure -> {
                    ErrorView(
                        onRetry = onRetry
                    )
                }
                is GroupsViewModel.Companion.GroupsUiState.Success -> {
                    GroupsView(
                        groups = groupsUiState.groups,
                        onItemClick = onItemClick
                    )
                }
            }
        }
    }
}

@Composable
private fun GroupsView(
    modifier: Modifier = Modifier,
    groups: List<Group>,
    onItemClick: (groupId: Int, detailId: Int) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = groups,
            key = {
                it.groupId
            }
        ) { group ->
            GroupView(
                group = group,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun GroupView(
    modifier: Modifier = Modifier,
    group: Group,
    onItemClick: (groupId: Int, detailId: Int) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.surfaceContainer else MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = group.title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                group.data.forEach { item ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                onClick = {
                                    onItemClick(group.groupId, item.id)
                                }
                            ),
                        text = item.title,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        lineHeight = 2.em,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun GroupsScreenViewLoadingPreview() {
    PreviewWithTheme(false) {
        GroupsScreenView(
            groupsUiState = GroupsViewModel.Companion.GroupsUiState.Loading
        )
    }
}

@PreviewLightDark
@Composable
private fun GroupsScreenViewFailurePreview() {
    PreviewWithTheme(false) {
        GroupsScreenView(
            groupsUiState = GroupsViewModel.Companion.GroupsUiState.Failure
        )
    }
}

@PreviewLightDark
@Composable
private fun GroupsScreenViewSuccessPreview() {
    PreviewWithTheme(false) {
        GroupsScreenView(
            groupsUiState = GroupsViewModel.Companion.GroupsUiState.Success(
                groups = PreviewData.groups
            )
        )
    }
}