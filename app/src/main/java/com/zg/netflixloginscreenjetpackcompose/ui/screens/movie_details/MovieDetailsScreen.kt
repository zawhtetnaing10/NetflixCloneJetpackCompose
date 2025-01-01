package com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.MovieReleaseInfo
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixFilmLogo
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixRoundedButton
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixTabBar
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.VideoPlayer
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White
import com.zg.netflixloginscreenjetpackcompose.ui.utils.IconSource

@Composable
fun MovieDetailsScreen(onTapBack: () -> Unit, modifier: Modifier = Modifier) {

    // TODO: - Move this to ViewModel
    val movieDetailsScreenTabs = listOf(stringResource(R.string.more_like_this), stringResource(R.string.trailers_and_more))

    Scaffold(topBar = { MovieDetailsAppbar(onTapBack = onTapBack) }, modifier = modifier.fillMaxSize()) { paddingValues ->
        MovieDetailsContent(tabs = movieDetailsScreenTabs, modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()))
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
fun MovieDetailsContent(tabs: List<String>, modifier: Modifier = Modifier) {
    Surface(color = Black, modifier = modifier.fillMaxSize()) {
        Column {
            // Video Player
            VideoPlayer(modifier = Modifier.fillMaxWidth())
            // Body
            MovieDetailsBody(tabs = tabs)
        }
    }
}

@Composable
fun MovieDetailsBody(tabs: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(MARGIN_MEDIUM_2)
            .verticalScroll(rememberScrollState())
    ) {
        // Movie Name & Netflix Logo
        NetflixFilmLogo()
        // Spacer
        Spacer(Modifier.height(MARGIN_MEDIUM))
        // Movie Name
        Text("Carry On", color = White, fontFamily = NetflixSansFontFamily, fontWeight = FontWeight.Bold)
        // Spacer
        Spacer(Modifier.height(MARGIN_MEDIUM))
        // Movie Release Info
        MovieReleaseInfo()
        Spacer(Modifier.height(MARGIN_MEDIUM_2))
        // Play and Download Buttons
        PlayAndDownloadButtons()
        Spacer(Modifier.height(MARGIN_MEDIUM_2))
        Text(
            "A crowded airport. A dangerous suitcase. A mysterious criminal mastermind. On Christmas Eve, a security officer faces the ultimate travel nightmare.",
            color = White,
            fontFamily = NetflixSansFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TEXT_REGULAR,
            maxLines = 3,
        )
        Spacer(Modifier.height(MARGIN_MEDIUM_2))
        // Actors And Directors
        ActorsAndDirector(onTapMoreActors = { })
        Spacer(Modifier.height(MARGIN_LARGE))
        // Action Buttons
        MovieDetailsActionButtons()
        Spacer(Modifier.height(MARGIN_LARGE))
        NetflixTabBar(tabs)
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
        MovieDetailsScreen(onTapBack = {})
    }
}