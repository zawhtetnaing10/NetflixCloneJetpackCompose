package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.list_items.MovieListItem
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

@Composable
fun HorizontalMovieList(modifier: Modifier = Modifier, listItem: @Composable () -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
        modifier = modifier
    ) {
        items((1..20).toList()) {
            listItem()
        }
    }
}

@Preview
@Composable
private fun HorizontalMovieListPreview() {
    NetflixCloneJetpackComposeTheme {
        HorizontalMovieList {
            MovieListItem()
        }
    }
}