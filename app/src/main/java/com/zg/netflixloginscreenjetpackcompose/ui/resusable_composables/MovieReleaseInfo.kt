package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.LINE_HEIGHT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.LINE_HEIGHT_SMALL_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MovieDetailsIcon
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL_3X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieReleaseInfo(modifier: Modifier = Modifier) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_SMALL),
        verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        modifier = modifier
    ) {
        Text(
            "2024", color = White,
            fontFamily = NetflixSansFontFamily,
            fontSize = TEXT_REGULAR
        )
        Surface(color = NetflixGrey) {
            Text(
                "16+", color = White,
                fontFamily = NetflixSansFontFamily,
                fontSize = TEXT_SMALL_2X,
                modifier = Modifier.padding(horizontal = MARGIN_SMALL)
            )
        }
        Text(
            "1h 59m", color = White,
            fontFamily = NetflixSansFontFamily,
            fontSize = TEXT_REGULAR
        )
        Icon(
            painterResource(
                R.drawable.dolby_vision
            ),
            contentDescription = null,
            tint = MovieDetailsIcon,
            modifier = Modifier.size(width = 48.dp, height = 24.dp)
        )
        Surface(
            color = Color.Transparent,
            border = BorderStroke(1.dp, color = MovieDetailsIcon),
            shape = RoundedCornerShape(MARGIN_SMALL)
        ) {
            Text(
                "HD", color = MovieDetailsIcon,
                fontFamily = NetflixSansFontFamily,
                fontSize = TEXT_SMALL,
                modifier = Modifier.padding(horizontal = MARGIN_SMALL)
            )
        }
        // Spatial Audio
        Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(MARGIN_SMALL)) {
            Icon(
                painterResource(R.drawable.spatial_audio),
                contentDescription = null,
                tint = MovieDetailsIcon,
                modifier = Modifier.size(MARGIN_LARGE)
            )
            Column {
                Text(
                    "Spatial",
                    fontSize = TEXT_SMALL_2X,
                    color = MovieDetailsIcon,
                    fontWeight = FontWeight.Bold,
                    fontFamily = NetflixSansFontFamily,
                    lineHeight = LINE_HEIGHT_SMALL_2X
                )
                Text(
                    "Audio",
                    fontSize = TEXT_SMALL_3X,
                    color = MovieDetailsIcon,
                    fontWeight = FontWeight.Normal,
                    fontFamily = NetflixSansFontFamily,
                    lineHeight = LINE_HEIGHT_SMALL_2X
                )
            }
        }
        // AD
        Icon(
            painterResource(R.drawable.ad),
            contentDescription = null,
            tint = MovieDetailsIcon,
            modifier = Modifier.size(MARGIN_LARGE)
        )
        // Message
        Icon(
            painterResource(R.drawable.message),
            contentDescription = null,
            tint = MovieDetailsIcon,
            modifier = Modifier.size(MARGIN_LARGE)
        )
    }
}

@Preview
@Composable
private fun MovieReleaseInfoPreview() {
    NetflixCloneJetpackComposeTheme {
        MovieReleaseInfo()
    }
}