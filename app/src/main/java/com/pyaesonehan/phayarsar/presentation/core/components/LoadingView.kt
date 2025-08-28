package com.pyaesonehan.phayarsar.presentation.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pyaesonehan.phayarsar.presentation.core.preview.PreviewWithTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoadingView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularWavyProgressIndicator()
    }
}

@Preview
@Composable
private fun LoadingViewPreview() {
    PreviewWithTheme {
        LoadingView()
    }
}