package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_BIG
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAppbar(modifier: Modifier = Modifier) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Black
        ),
        title = {
            Text(
                "For Shade",
                color = White,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_BIG,
                fontFamily = NetflixSansFontFamily
            )
        },
        actions = {
            Icon(
                Icons.Default.Search,
                tint = White,
                contentDescription = "Search",
                modifier = Modifier.size(MARGIN_XLARGE)
            )
            // TODO: - 
        }
    )
}

@Preview
@Composable
private fun HomeScreenAppbarPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreenAppbar()
    }
}