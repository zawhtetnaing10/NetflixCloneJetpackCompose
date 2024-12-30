package com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.CastTextColor
import com.zg.netflixloginscreenjetpackcompose.ui.theme.LINE_HEIGHT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL_3X


@Composable
fun ActorsAndDirector(onTapMoreActors: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        // Actors
        ActorsWithSeeMore(onTapMoreActors = onTapMoreActors)

        // Director
        Text(
            "Director: Jaume Collet-Serra",
            color = CastTextColor,
            fontSize = TEXT_SMALL,
            lineHeight = LINE_HEIGHT_SMALL,
            fontFamily = NetflixSansFontFamily
        )
    }
}

@Composable
fun ActorsWithSeeMore(onTapMoreActors: () -> Unit, modifier: Modifier = Modifier) {
    // Annotated String
    val actorsAnnotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = CastTextColor, fontSize = TEXT_SMALL, fontFamily = NetflixSansFontFamily)) {
            append("Cast: Taron Egerton, Sofia Carson, Jason Bateman ")
        }

        withLink(
            LinkAnnotation.Url("more",
                styles = TextLinkStyles(
                    style = SpanStyle(color = CastTextColor, fontSize = TEXT_SMALL, fontFamily = NetflixSansFontFamily)
                ), linkInteractionListener = {
                    onTapMoreActors()
                })
        ) {
            append(stringResource(R.string.more))
        }
    }

    Text(actorsAnnotatedString, lineHeight = LINE_HEIGHT_SMALL, modifier = modifier)
}

@Preview
@Composable
private fun ActorsWithSeeMorePreview() {
    NetflixCloneJetpackComposeTheme {
        ActorsAndDirector(onTapMoreActors = {})
    }
}