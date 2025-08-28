package com.pyaesonehan.phayarsar.presentation.core.preview

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.pyaesonehan.phayarsar.presentation.theme.PhayarSarTheme

@Composable
fun PreviewWithTheme(
    withSurface: Boolean = true,
    content: @Composable () -> Unit
) {
    PhayarSarTheme {
        if (withSurface) {
            Surface {
                content()
            }
        } else {
            content()
        }
    }
}