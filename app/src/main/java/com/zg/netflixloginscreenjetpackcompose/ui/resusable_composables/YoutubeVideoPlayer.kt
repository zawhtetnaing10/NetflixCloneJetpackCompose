package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.utils.calculateHeightLandscapeVid

@Composable
fun YoutubeVideoPlayer(videoKey: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier.height(calculateHeightLandscapeVid(LocalConfiguration.current)),
        factory = {
            val view = YouTubePlayerView(it)
            view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(videoId = videoKey, startSeconds = 0f)
                }
            })
            return@AndroidView view
        }
    )
}

@Preview
@Composable
private fun YoutubeVideoPlayerPreview() {
    NetflixCloneJetpackComposeTheme {
        YoutubeVideoPlayer(videoKey = "z3PB6WAsaJo")
    }
}