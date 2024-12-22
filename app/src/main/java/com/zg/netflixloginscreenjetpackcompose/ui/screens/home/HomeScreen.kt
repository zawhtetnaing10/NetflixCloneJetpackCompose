package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { paddingValues ->
        Surface(color = Black, modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(paddingValues)) {
                Text("Home Screen")
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreen()
    }
}