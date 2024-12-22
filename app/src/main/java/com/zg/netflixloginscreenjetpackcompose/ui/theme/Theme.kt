package com.zg.netflixloginscreenjetpackcompose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val NetflixColorScheme = lightColorScheme(
    primary = NetflixRed,
    secondary = Black,
    tertiary = NetflixGrey
)

@Composable
fun NetflixCloneJetpackComposeTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = NetflixColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}