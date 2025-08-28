package com.pyaesonehan.phayarsar.presentation.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pyaesonehan.phayarsar.R
import com.pyaesonehan.phayarsar.presentation.core.preview.PreviewWithTheme

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    onRetry: () -> Unit = {}
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.error_message)
            )
            Button(
                onClick = onRetry
            ) {
                Text(
                    text = stringResource(R.string.retry)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ErrorViewPreview() {
    PreviewWithTheme {
        ErrorView()
    }
}