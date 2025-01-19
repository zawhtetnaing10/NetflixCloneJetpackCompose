package com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details

import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.data.models.Actor
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.data.models.TrailerVideo
import com.zg.netflixloginscreenjetpackcompose.ui.list_items.MovieListItem
import com.zg.netflixloginscreenjetpackcompose.ui.navigation.NavRoutes
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.MovieReleaseInfo
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixFilmLogo
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixRoundedButton
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixTabBar
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.VideoPlayer
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.YoutubeVideoPlayer
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MOVIE_IMAGE_HEIGHT
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White
import com.zg.netflixloginscreenjetpackcompose.ui.utils.IconSource
import com.zg.netflixloginscreenjetpackcompose.ui.utils.calculateHeightForGrid
import com.zg.netflixloginscreenjetpackcompose.viewmodels.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(movieId: Int, onTapBack: () -> Unit, modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<MovieDetailsViewModel, MovieDetailsViewModel.MovieDetailsViewModelFactory> {
        it.create(movieId = movieId)
    }

    // State for details screen
    val detailsScreenState by viewModel.detailsScreenState.collectAsStateWithLifecycle()

    // TODO: - Move this to ViewModel
    val movieDetailsScreenTabs = listOf(stringResource(R.string.more_like_this), stringResource(R.string.trailers_and_more))

    Scaffold(topBar = { MovieDetailsAppbar(onTapBack = onTapBack) }, modifier = modifier.fillMaxSize()) { paddingValues ->
        MovieDetailsContent(
            movie = detailsScreenState.movie,
            trailer = detailsScreenState.trailer,
            cast = detailsScreenState.cast,
            crew = detailsScreenState.crew,
            relatedMovies = detailsScreenState.relatedMovies,
            tabs = movieDetailsScreenTabs,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsAppbar(onTapBack: () -> Unit, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = onTapBack) {
                Icon(
                    Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    tint = White,
                    contentDescription = null,
                    modifier = Modifier.size(MARGIN_XLARGE)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier,
    )
}

@Composable
fun MovieDetailsContent(
    movie: Movie?,
    trailer: TrailerVideo?,
    cast: List<Actor>?,
    crew: List<Actor>?,
    relatedMovies: List<Movie>?,
    tabs: List<String>,
    modifier: Modifier = Modifier
) {
    Surface(color = Black, modifier = modifier.fillMaxSize()) {
        Column {
            // Video Player
            if (trailer != null && trailer.isYoutubeVideo())
                YoutubeVideoPlayer(videoKey = trailer.key, modifier = Modifier.fillMaxWidth())
            // Body
            MovieDetailsBody(movie = movie, cast = cast, crew = crew, relatedMovies = relatedMovies, tabs = tabs)
        }
    }
}

@Composable
fun MovieDetailsBody(
    movie: Movie?,
    cast: List<Actor>?,
    crew: List<Actor>?,
    relatedMovies: List<Movie>?,
    tabs: List<String>, modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(MARGIN_MEDIUM_2)
    ) {
        // Movie Name & Netflix Logo
        item { NetflixFilmLogo() }

        // Spacer
        item { Spacer(Modifier.height(MARGIN_MEDIUM)) }
        // Movie Name
        item { Text(movie?.title ?: "", color = White, fontFamily = NetflixSansFontFamily, fontWeight = FontWeight.Bold) }
        // Spacer
        item { Spacer(Modifier.height(MARGIN_MEDIUM)) }
        // Movie Release Info
        item { MovieReleaseInfo() }
        item { Spacer(Modifier.height(MARGIN_MEDIUM_2)) }
        // Play and Download Buttons
        item { PlayAndDownloadButtons() }
        item { Spacer(Modifier.height(MARGIN_MEDIUM_2)) }
        item {
            Text(
                "A crowded airport. A dangerous suitcase. A mysterious criminal mastermind. On Christmas Eve, a security officer faces the ultimate travel nightmare.",
                color = White,
                fontFamily = NetflixSansFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = TEXT_REGULAR,
                maxLines = 3,
            )
        }
        item { Spacer(Modifier.height(MARGIN_MEDIUM_2)) }
        item {
            // Actors And Directors
            ActorsAndDirector(onTapMoreActors = { })
        }
        item { Spacer(Modifier.height(MARGIN_LARGE)) }
        // Action Buttons
        item { MovieDetailsActionButtons() }
        item {
            Spacer(Modifier.height(MARGIN_LARGE))
        }
        item {
            NetflixTabBar(tabs)
        }
        item {
            // Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM_2),
                contentPadding = PaddingValues(vertical = MARGIN_LARGE),
                // TODO: - replace with real data from view model
                modifier = Modifier.height(
                    calculateHeightForGrid(
                        noOfItems = 12,
                        noOfColumns = 3,
                        heightPerItem = MOVIE_IMAGE_HEIGHT + MARGIN_LARGE
                    )
                ) // Added a bit more height to avoid nested scrolling
            ) {
                items((1..12).toList()) {
                    MovieListItem(movie = null, onTapMovie = {})
                }
            }
        }
    }
}

@Composable
fun PlayAndDownloadButtons(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth()) {
        NetflixRoundedButton(
            label = stringResource(R.string.play),
            icon = IconSource.VectorSource(Icons.Default.PlayArrow),
            backgroundColor = White,
            contentColor = Black,
            onButtonClicked = {},
            modifier = Modifier.fillMaxWidth()
        )
        NetflixRoundedButton(
            label = stringResource(R.string.download),
            icon = IconSource.PainterSource(painterResource(R.drawable.download)),
            backgroundColor = NetflixGrey,
            contentColor = White,
            onButtonClicked = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    NetflixCloneJetpackComposeTheme {
        MovieDetailsScreen(movieId = 0, onTapBack = {})
    }
}