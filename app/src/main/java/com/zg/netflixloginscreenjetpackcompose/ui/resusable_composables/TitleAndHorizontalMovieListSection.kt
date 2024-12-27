package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.list_items.MovieListItem
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun TitleAndHorizontalMovieListSection(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM), modifier = modifier) {
        Text(
            "Today's top picks for you",
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_REGULAR_2X,
            fontFamily = NetflixSansFontFamily,
            modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
        )
        // Horizontal Movie List
        HorizontalMovieList()
    }
}

@Composable
fun HorizontalMovieList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
        modifier = modifier
    ) {
        items((1..20).toList()) {
            MovieListItem()
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