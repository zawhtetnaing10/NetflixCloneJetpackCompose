package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
            val mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
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
        modifier = modifier,
        factory = {
            PlayerView(context).apply { player = exoPlayer }
        }
    )
}

@Preview
@Composable
private fun VideoPlayerPreview() {
    NetflixCloneJetpackComposeTheme {
        VideoPlayer()
    }
}