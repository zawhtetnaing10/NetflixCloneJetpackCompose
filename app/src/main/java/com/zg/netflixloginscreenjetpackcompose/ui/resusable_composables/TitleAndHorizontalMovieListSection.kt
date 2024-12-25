package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun TitleAndHorizontalMovieListSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            "Today's top picks for you",
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_REGULAR_2X,
            fontFamily = NetflixSansFontFamily
        )
        // Horizontal Movie List
        HorizontalMovieList()
    }
}

@Composable
fun HorizontalMovieList(modifier: Modifier = Modifier) {
    LazyRow {
        items((1..20).toList()){
            // TODO: - Add MovieListItem
        }
    }
}

@Preview
@Composable
private fun TitleAndHorizontalMovieListSectionPreview() {
    NetflixCloneJetpackComposeTheme {
        TitleAndHorizontalMovieListSection()
    }
}