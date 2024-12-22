package com.zg.netflixloginscreenjetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zg.netflixloginscreenjetpackcompose.ui.screens.home.HomeScreen
import com.zg.netflixloginscreenjetpackcompose.ui.screens.login.NetflixLoginScreen
import kotlinx.serialization.Serializable

@Composable
fun MainNavHost(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login,
        modifier = modifier
    ) {
        composable<NavRoutes.Login>{
            NetflixLoginScreen(
                onTapSignIn = {
                    navController.navigate(NavRoutes.Home)
                }
            )
        }

        composable<NavRoutes.Home> {
            HomeScreen()
        }
    }
}

@Serializable
sealed class NavRoutes {
    @Serializable
    object Login

    @Serializable
    object Home
}