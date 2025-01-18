package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.MobileGamesSection
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.TitleAndContinueWatchingMovieListSection
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.TitleAndHorizontalMovieListSection
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_CATEGORIES_TOP_MARGIN
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.viewmodels.HomeViewModel

@Composable
fun HomeScreen(onTapMovie: (Int) -> Unit, viewModel: HomeViewModel = hiltViewModel(), modifier: Modifier = Modifier) {

    // State from ViewModel
    val homeScreenState by viewModel.homeScreenState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            HomeScreenAppbar()
        }, bottomBar = {
            HomeScreenBottomNavigationBar()
        }, modifier = modifier
    ) { paddingValues ->
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
                LazyColumn(modifier = Modifier.padding(top = 140.dp)) {
                    // Featured Movie
                    item {
                        if(homeScreenState.featuredMovie != null)
                            FeaturedMovie(movie = homeScreenState.featuredMovie, onTapMovie = onTapMovie)
                    }
                    // Spacer
                    item {
                        Spacer(Modifier.height(MARGIN_MEDIUM_3))
                    }
                    // Mobile Games
                    item {
                        if(homeScreenState.mobileGames?.isNotEmpty() == true)
                            MobileGamesSection()
                    }
                    // Continue Watching Section
                    item {
                        if(homeScreenState.continueWatching?.isNotEmpty() == true)
                            TitleAndContinueWatchingMovieListSection(
                                title = "Continue Watching",
                                movieList = homeScreenState.continueWatching ?: listOf(),
                                onTapMovie = onTapMovie,
                                modifier = Modifier.padding(top = MARGIN_MEDIUM_3)
                            )
                    }
                    // TODO: Replace with real movie lists
                    items(homeScreenState.moviesWithGenre ?: listOf()) {
                        // Horizontal Movie List
                        TitleAndHorizontalMovieListSection(
                            title = it.first,
                            movieList = it.second,
                            onTapMovie = onTapMovie,
                            modifier = Modifier.padding(top = MARGIN_MEDIUM_3)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreen(onTapMovie = {})
    }
}