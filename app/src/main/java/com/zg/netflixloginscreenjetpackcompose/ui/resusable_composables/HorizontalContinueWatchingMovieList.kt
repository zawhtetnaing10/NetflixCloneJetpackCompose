package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.ui.list_items.ContinueWatchingListItem
import com.zg.netflixloginscreenjetpackcompose.ui.list_items.MovieListItem
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun HorizontalContinueWatchingMovieList(movieList: List<Movie>, onTapMovie: () -> Unit, modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
        modifier = modifier
    ) {
        items(movieList) {
            ContinueWatchingListItem(
                movie = it,
                onTapMovie = onTapMovie
            )
        }
    }
}

@Preview
@Composable
private fun HorizontalMovieListPreview() {
    NetflixCloneJetpackComposeTheme {
        HorizontalContinueWatchingMovieList(movieList = listOf(), onTapMovie = {})
    }
}