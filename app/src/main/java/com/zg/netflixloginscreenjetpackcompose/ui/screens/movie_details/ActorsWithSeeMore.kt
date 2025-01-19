package com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.data.models.CastAndCrew
import com.zg.netflixloginscreenjetpackcompose.ui.theme.CastTextColor
import com.zg.netflixloginscreenjetpackcompose.ui.theme.LINE_HEIGHT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL


@Composable
fun ActorsAndDirector(
    cast: List<CastAndCrew>?,
    crew: List<CastAndCrew>?,
    onTapMoreActors: () -> Unit, modifier: Modifier = Modifier
) {

    val directorName = crew?.firstOrNull { it.isDirector() }?.name

    Column(modifier = modifier) {
        // Actors
        if(cast != null)
            ActorsWithSeeMore(
                cast = cast,
                onTapMoreActors = onTapMoreActors
            )

        // Director
        if(directorName != null)
            Text(
                "Director: $directorName",
                color = CastTextColor,
                fontSize = TEXT_SMALL,
                lineHeight = LINE_HEIGHT_SMALL,
                fontFamily = NetflixSansFontFamily
            )
    }
}

@Composable
fun ActorsWithSeeMore(
    cast: List<CastAndCrew>,
    onTapMoreActors: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Annotated String
    val actorsAnnotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = CastTextColor, fontSize = TEXT_SMALL, fontFamily = NetflixSansFontFamily)) {
            append("Cast: ${cast.take(3).joinToString(",") { it.name }} ")
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
        ActorsAndDirector(cast = listOf(), crew = listOf(), onTapMoreActors = {})
    }
}