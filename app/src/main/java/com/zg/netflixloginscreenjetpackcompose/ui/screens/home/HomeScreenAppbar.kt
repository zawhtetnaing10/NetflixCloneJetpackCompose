package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_CARD_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAppbar(isCloseToTop: Boolean, modifier: Modifier = Modifier) {

    val appBarColor by animateColorAsState(
        targetValue = if (isCloseToTop) Color.Transparent else Color.Black,
        label = "appbarColor"
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
                fontSize = TEXT_LARGE,
                fontFamily = NetflixSansFontFamily
            )
        },
        actions = {
            Row(horizontalArrangement = Arrangement.spacedBy(MARGIN_CARD_MEDIUM_2)) {
                Icon(
                    painterResource(R.drawable.broadcast),
                    tint = White,
                    contentDescription = "Connect to TV",
                    modifier = Modifier.size(MARGIN_LARGE_2X)
                )
                Icon(
                    painterResource(R.drawable.download),
                    tint = White,
                    contentDescription = "Download",
                    modifier = Modifier.size(MARGIN_LARGE_2X)
                )
                Icon(
                    Icons.Default.Search,
                    tint = White,
                    contentDescription = "Search",
                    modifier = Modifier.size(MARGIN_LARGE_2X)
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