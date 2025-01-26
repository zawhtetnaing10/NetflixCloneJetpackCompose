package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.BottomNavigationBackground
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_CARD_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_3X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAppbar(isCloseToTop: Boolean, modifier: Modifier = Modifier) {

    val appBarColor by animateColorAsState(
        targetValue = if (isCloseToTop) Color.Transparent else BottomNavigationBackground,
        label = "appbarColor"
    )

    val titleTextSize = if (isCloseToTop) TEXT_LARGE else TEXT_REGULAR_3X

    val iconSize by animateDpAsState(
        targetValue = if(isCloseToTop) MARGIN_LARGE_2X else MARGIN_LARGE,
        label = "appBarIconSize"
    )

    val horizontalPadding by animateDpAsState(
        targetValue = if(isCloseToTop) 0.dp else MARGIN_MEDIUM_3,
        label = "appBarHorizontalPadding"
    )

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = appBarColor
        ),
        title = {
            Text(
                "For Shade",
                color = White,
                fontWeight = FontWeight.SemiBold,
                fontSize = titleTextSize,
                fontFamily = NetflixSansFontFamily,
                modifier = Modifier.padding(start = horizontalPadding)
            )
        },
        actions = {
            Row(horizontalArrangement = Arrangement.spacedBy(MARGIN_CARD_MEDIUM_2), modifier = Modifier.padding(end = horizontalPadding)) {
                Icon(
                    painterResource(R.drawable.broadcast),
                    tint = White,
                    contentDescription = "Connect to TV",
                    modifier = Modifier.size(iconSize)
                )
                Icon(
                    painterResource(R.drawable.download),
                    tint = White,
                    contentDescription = "Download",
                    modifier = Modifier.size(iconSize)
                )
                Icon(
                    Icons.Default.Search,
                    tint = White,
                    contentDescription = "Search",
                    modifier = Modifier.size(iconSize)
                )
            }

        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun HomeScreenAppbarPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreenAppbar(isCloseToTop = true)
    }
}