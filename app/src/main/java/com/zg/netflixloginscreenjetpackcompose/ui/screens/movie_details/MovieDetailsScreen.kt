package com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.VideoPlayer
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun MovieDetailsScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        MovieDetailsContent(modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()))
    }
}

@Composable
fun MovieDetailsContent(modifier: Modifier = Modifier) {
    Surface(color = Black, modifier = modifier.fillMaxSize()) {
        Column {
            VideoPlayer(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    NetflixCloneJetpackComposeTheme {
        MovieDetailsScreen()
    }
}