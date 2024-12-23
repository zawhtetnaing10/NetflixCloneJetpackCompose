package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.FeaturedMovieGradient
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun FeaturedMovie(modifier: Modifier = Modifier) {

    // Height of the card
    val calculatedHeight = getFeaturedMovieHeight(LocalConfiguration.current)
    // y gradient offset
    val gradientOffset = with(LocalDensity.current) { calculatedHeight.toPx() }

    Card(
        elevation = CardDefaults.cardElevation(MARGIN_SMALL),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = MARGIN_LARGE, end = MARGIN_LARGE)
            .height(getFeaturedMovieHeight(LocalConfiguration.current))
    ) {
        Box {
            // Image
            Image(
                painterResource(R.drawable.lal_palma_poster),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            // Gradient
            FeaturedMovieGradient(gradientOffset = gradientOffset)
        }
    }
}

@Composable
fun FeaturedMovieGradient(gradientOffset: Float, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Transparent, FeaturedMovieGradient),
                    start = Offset(0f, 0f),
                    end = Offset(0f, gradientOffset)
                )
            )
    )
}

/**
 * Calculates the height for featured movie
 * Since the image has dimensions of 900 x 1350, the aspect ratio is 1.5f
 * available width is equal to screen width - margins (24.dp * 2 = 48.dp)
 * height is obtained by multiplying available width with aspect ratio
 */
private fun getFeaturedMovieHeight(localConfiguration: Configuration): Dp {
    val screenWidthDp = localConfiguration.screenWidthDp.dp
    val margins = MARGIN_LARGE * 2

    val availableWidth = screenWidthDp - margins
    val aspectRatio = 1.5f
    val calculatedHeight = availableWidth * aspectRatio
    return calculatedHeight
}

@Preview
@Composable
private fun FeaturedMoviePreview() {
    NetflixCloneJetpackComposeTheme {
        FeaturedMovie()
    }
}