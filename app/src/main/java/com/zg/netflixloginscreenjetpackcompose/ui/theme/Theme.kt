package com.zg.netflixloginscreenjetpackcompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val NetflixColorScheme = lightColorScheme(
    primary = NetflixRed,
    secondary = Black,
    tertiary = NetflixGrey
)

@Composable
fun NetflixLoginScreenJetpackComposeTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = NetflixColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}