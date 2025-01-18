package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.data.models.Genre
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixRoundedButton
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.FeaturedMovieGradient
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White
import com.zg.netflixloginscreenjetpackcompose.ui.utils.IconSource
import com.zg.netflixloginscreenjetpackcompose.utils.FEATURED_MOVIE_IMAGE_BASE_URL

@Composable
fun FeaturedMovie(movie: Movie?, onTapMovie: (Int) -> Unit, modifier: Modifier = Modifier) {

    // Height of the card
    val calculatedHeight = getFeaturedMovieHeight(LocalConfiguration.current)
    // y gradient offset
    val gradientOffset = with(LocalDensity.current) { calculatedHeight.toPx() }

    Card(
        elevation = CardDefaults.cardElevation(MARGIN_SMALL),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = MARGIN_LARGE, end = MARGIN_LARGE)
            .height(getFeaturedMovieHeight(LocalConfiguration.current))
            .clickable {
                onTapMovie(movie!!.id!!)
            }
    ) {
        Box {
            // Image
            AsyncImage(
                "$FEATURED_MOVIE_IMAGE_BASE_URL${movie?.backdropPath}",
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            // Gradient
            FeaturedMovieGradient(gradientOffset = gradientOffset)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = MARGIN_MEDIUM_2)
            ) {
                // Genres
                FeaturedMovieGenres(genres = movie?.genres ?: listOf())

                Spacer(Modifier.height(MARGIN_MEDIUM))

                // Play And My List Buttons
                FeaturedMovieButtons()
            }
        }
    }
}

@Composable
fun FeaturedMovieButtons(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        modifier = modifier.padding(horizontal = MARGIN_MEDIUM_2)
    ) {
        // Play Button
        NetflixRoundedButton(
            label = stringResource(R.string.play),
            icon = IconSource.VectorSource(Icons.Default.PlayArrow),
            backgroundColor = White,
            contentColor = Black,
            onButtonClicked = {},
            modifier = modifier.weight(1f)
        )

        // My List Button
        NetflixRoundedButton(
            label = stringResource(R.string.my_list),
            icon = IconSource.VectorSource(Icons.Default.Add),
            backgroundColor = NetflixGrey,
            contentColor = White,
            onButtonClicked = {},
            modifier = modifier.weight(1f)
        )
    }
}

@Composable
fun FeaturedMovieGenres(genres: List<Genre>?, modifier: Modifier = Modifier) {

    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        genres?.forEachIndexed { index, genre ->
            // Genre Name
            Text(
                genre.name,
                color = White,
                fontSize = TEXT_REGULAR,
                fontFamily = NetflixSansFontFamily
            )
            // Dot separator
            if (index < genres.count() - 1)
                Box(
                    modifier = Modifier
                        .padding(horizontal = MARGIN_MEDIUM)
                        .size(MARGIN_SMALL)
                        .clip(CircleShape)
                        .background(White)
                )

        }
    }
}

@Composable
fun FeaturedMovieGradient(gradientOffset: Float, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Transparent, FeaturedMovieGradient),
                    start = Offset(0f, 0f),
                    end = Offset(0f, gradientOffset)
                )
            )
    )
}

/**
 * Calculates the height for featured movie
 * Since the image has dimensions of 900 x 1350, the aspect ratio is 1.5f
 * available width is equal to screen width - margins (24.dp * 2 = 48.dp)
 * height is obtained by multiplying available width with aspect ratio
 */
private fun getFeaturedMovieHeight(localConfiguration: Configuration): Dp {
    val screenWidthDp = localConfiguration.screenWidthDp.dp
    val margins = MARGIN_LARGE * 2

    val availableWidth = screenWidthDp - margins
    val aspectRatio = 1.5f
    val calculatedHeight = availableWidth * aspectRatio
    return calculatedHeight
}

@Preview
@Composable
private fun FeaturedMoviePreview() {
    NetflixCloneJetpackComposeTheme {
        FeaturedMovie(movie = null, onTapMovie = {})
    }
}