package com.zg.netflixloginscreenjetpackcompose.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zg.netflixloginscreenjetpackcompose.ui.screens.home.HomeScreen
import com.zg.netflixloginscreenjetpackcompose.ui.screens.login.NetflixLoginScreen
import com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details.MovieDetailsScreen
import kotlinx.serialization.Serializable

@Composable
fun MainNavHost(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login,
        modifier = modifier
    ) {
        // Sign In
        composable<NavRoutes.Login> {
            NetflixLoginScreen(
                onTapSignIn = {
                    navController.navigate(NavRoutes.Home)
                }
            )
        }
        // Home
        composable<NavRoutes.Home> {
            HomeScreen(onTapMovie = {
                navController.navigate(NavRoutes.MovieDetails(it))
            })
        }
        // MovieDetails
        composable<NavRoutes.MovieDetails> { backStackEntry ->
            val args = backStackEntry.toRoute<NavRoutes.MovieDetails>()
            val movieId = args.movieId

            MovieDetailsScreen(
                movieId = movieId,
                onTapBack = {
                    navController.navigateUp()
                })
        }
    }
}

@Serializable
sealed class NavRoutes {
    @Serializable
    object Login

    @Serializable
    object Home

    @Serializable
    data class MovieDetails(val movieId: Int)
}