package com.zg.netflixloginscreenjetpackcompose.ui.list_items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_MOVIE_IMAGE_WIDTH
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_SUB_TEXT_WIDTH
import com.zg.netflixloginscreenjetpackcompose.ui.theme.LINE_HEIGHT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MOVIE_IMAGE_HEIGHT
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixRedPrimary
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL_3X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun MovieListItem(movie: Movie?, onTapMovie: (Int) -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier.clickable { onTapMovie(movie!!.id!!) }) {
        // Image
        Surface(
            shape = RoundedCornerShape(MARGIN_MEDIUM)
        ) {
            AsyncImage(
                movie?.getFullPosterPath() ?: "", contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = HOME_SCREEN_MOVIE_IMAGE_WIDTH, height = MOVIE_IMAGE_HEIGHT)
            )
        }

        // Recently released
        if(movie?.isRecentlyReleased() == true)
            Surface(
                shape = RoundedCornerShape(topStart = MARGIN_SMALL_2X, topEnd = MARGIN_SMALL_2X),
                color = NetflixRedPrimary,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(HOME_SCREEN_SUB_TEXT_WIDTH)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        stringResource(R.string.recently_added), color = White,
                        fontWeight = FontWeight.Bold,
                        fontSize = TEXT_SMALL_3X,
                        lineHeight = LINE_HEIGHT_SMALL
                    )
                }
            }
    }
}

@Preview
@Composable
private fun MovieListItemPreview() {
    NetflixCloneJetpackComposeTheme {
        MovieListItem(movie = null, onTapMovie = {})
    }
}