package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HomeScreenGradientColor
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun HomeScreenGradient(isCloseToTop: Boolean, modifier: Modifier = Modifier) {

    val localDensity = LocalDensity.current
    val configuration = LocalConfiguration.current
    val screenHeightDP = with(configuration) { screenHeightDp }

    val gradientTopColor by animateColorAsState(
        targetValue = if(isCloseToTop) HomeScreenGradientColor else Black,
        label = "HomeScreenGradient"
    )

    // Total Gradient Height in DP
    val totalGradientHeightDp = screenHeightDP.dp

    // Gradient End Offset
    val gradientEndOffset = with(localDensity) { totalGradientHeightDp.toPx() * 0.98 }

    // Gradient
    Box(
        modifier = modifier
            .height(totalGradientHeightDp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(gradientTopColor, Black),
                    start = Offset(0f, 0f),
                    end = Offset(0f, gradientEndOffset.toFloat())
                )
            )
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun HomeScreenGradientPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreenGradient(isCloseToTop = true)
    }
}