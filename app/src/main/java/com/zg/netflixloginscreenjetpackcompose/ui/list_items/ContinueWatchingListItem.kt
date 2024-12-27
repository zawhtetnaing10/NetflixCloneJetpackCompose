package com.zg.netflixloginscreenjetpackcompose.ui.list_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.CONTINUE_WATCHING_PLAY_BUTTON_SIZE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.CONTINUE_WATCHING_PLAY_ICON_SIZE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.ContinueWatchingBackground
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_MOVIE_IMAGE_HEIGHT
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_MOVIE_IMAGE_WIDTH
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixRedPrimary
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun ContinueWatchingListItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier.width(HOME_SCREEN_MOVIE_IMAGE_WIDTH)) {
        // Image and Play Button
        ContinueWatchingImage()
        // Progress
        Progress()
        // Buttons
        ContinueWatchingButtons()
    }
}

@Composable
fun ContinueWatchingImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Image
        Surface(
            shape = RoundedCornerShape(topStart = MARGIN_MEDIUM, topEnd = MARGIN_MEDIUM),
        ) {
            Image(
                painterResource(R.drawable.bleach), contentDescription = null,
                modifier = Modifier.size(width = HOME_SCREEN_MOVIE_IMAGE_WIDTH, height = HOME_SCREEN_MOVIE_IMAGE_HEIGHT)
            )
        }

        // Transparent Overlay
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape = RoundedCornerShape(topStart = MARGIN_MEDIUM, topEnd = MARGIN_MEDIUM))
                .background(color = Black.copy(alpha = 0.3f))
        )

        // Play Icon
        Surface(
            shape = CircleShape,
            color = Black.copy(alpha = 0.7f),
            border = BorderStroke(width = 1.dp, color = White),
            modifier = Modifier
                .size(CONTINUE_WATCHING_PLAY_BUTTON_SIZE)
                .align(Alignment.Center)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(CONTINUE_WATCHING_PLAY_ICON_SIZE)
                )
            }
        }

        // Latest Episode
        Text(
            "S1:E1",
            color = White,
            fontSize = TEXT_SMALL,
            fontFamily = NetflixSansFontFamily,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Progress() {
    LinearProgressIndicator(
        color = NetflixRedPrimary,
        trackColor = NetflixGrey,
        progress = {
            0.8f
        },
        strokeCap = StrokeCap.Square,
        modifier = Modifier.width(HOME_SCREEN_MOVIE_IMAGE_WIDTH),
        gapSize = 0.dp,
        drawStopIndicator = {
            // Must return nothing or a default stop indicator is added
        }
    )
}

@Composable
fun ContinueWatchingButtons(modifier: Modifier = Modifier) {
    Surface(
        color = ContinueWatchingBackground,
        shape = RoundedCornerShape(bottomStart = MARGIN_MEDIUM, bottomEnd = MARGIN_MEDIUM),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(horizontal = MARGIN_MEDIUM, vertical = MARGIN_SMALL)) {
            Icon(
                Icons.Outlined.Info,
                tint = White,
                contentDescription = null,
                modifier = Modifier.size(MARGIN_LARGE_2X)
            )
            Spacer(Modifier.weight(1.0f))
            Icon(
                Icons.Outlined.MoreVert,
                tint = White,
                contentDescription = null,
                modifier = Modifier.size(MARGIN_LARGE_2X)
                    .clickable {
                        // TODO: - Send this event back to Parent and OpenBottomSheet
                    }
            )
        }
    }
}

@Preview
@Composable
private fun ContinueWatchingListItemPreview() {
    NetflixCloneJetpackComposeTheme {
        ContinueWatchingListItem()
    }
}