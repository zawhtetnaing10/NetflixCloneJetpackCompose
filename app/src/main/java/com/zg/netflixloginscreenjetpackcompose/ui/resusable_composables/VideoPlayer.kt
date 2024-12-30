package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun VideoPlayer(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val exoPlayer: ExoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4") //TODO: - replace with real url
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = false
        }
    }

    // Since exoPlayer is set as the key for DisposableEffect,
    // the onDispose will be called for current exoPlayer when exoPlayer changes
    // and DisposableEffect is called again with the new instance of exoPlayer
    DisposableEffect(exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        modifier = modifier.height(calculateHeightForAspectRatio(LocalConfiguration.current)),
        factory = {
            PlayerView(it).apply { player = exoPlayer }
        }
    )
}

// Calculate height for video player to keep the 16:9 aspect ratio.
// width/height = 16/9 so height/width becomes 9/16 which equals to 0.5625
private fun calculateHeightForAspectRatio(localConfiguration: Configuration): Dp {
    val availableScreenWidth = localConfiguration.screenWidthDp.dp
    val aspectRatioReversed = 0.5625f // 9/16

    val calculatedHeight = availableScreenWidth * aspectRatioReversed
    return calculatedHeight
}

@Preview
@Composable
private fun VideoPlayerPreview() {
    NetflixCloneJetpackComposeTheme {
        VideoPlayer()
    }
}