package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun FeaturedMovie(modifier: Modifier = Modifier) {

    // TODO: - Extract this into a function
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val margins = 24.dp * 2

    // Calculate available width and height
    val availableWidth = screenWidthDp - margins
    val aspectRatio = 1.5f
    val calculatedHeight = availableWidth * aspectRatio

    Card(
        elevation = CardDefaults.cardElevation(MARGIN_SMALL),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = MARGIN_LARGE, end = MARGIN_LARGE)
            .height(calculatedHeight)
    ) {
        Image(
            painterResource(R.drawable.lal_palma_poster),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun FeaturedMoviePreview() {
    NetflixCloneJetpackComposeTheme {
        FeaturedMovie()
    }
}