package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_CATEGORIES_TOP_MARGIN
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XXLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Scaffold(topBar = { HomeScreenAppbar() }, modifier = modifier) { paddingValues ->
        Surface(
            color = Black,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            Box {
                // Gradient
                HomeScreenGradient()

                // Categories
                HomeScreenCategories(
                    modifier.padding(
                        top = HOME_SCREEN_CATEGORIES_TOP_MARGIN,
                        start = MARGIN_MEDIUM_2,
                        end = MARGIN_MEDIUM_2
                    )
                )

                // Actual Content
                LazyColumn {
                    // TODO: - Add Content
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreen()
    }
}