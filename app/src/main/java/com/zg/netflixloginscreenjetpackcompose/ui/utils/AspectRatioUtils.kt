package com.zg.netflixloginscreenjetpackcompose.ui.utils

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Calculate height for video player to keep the 16:9 aspect ratio.
// width/height = 16/9 so height/width becomes 9/16 which equals to 0.5625
fun calculateHeightLandscapeVid(localConfiguration: Configuration): Dp {
    val availableScreenWidth = localConfiguration.screenWidthDp.dp
    val aspectRatioReversed = 0.5625f // 9/16

    val calculatedHeight = availableScreenWidth * aspectRatioReversed
    return calculatedHeight
}