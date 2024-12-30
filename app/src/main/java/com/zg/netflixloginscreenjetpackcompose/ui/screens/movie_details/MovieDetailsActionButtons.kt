package com.zg.netflixloginscreenjetpackcompose.ui.screens.movie_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XXLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White
import com.zg.netflixloginscreenjetpackcompose.ui.utils.IconSource

@Composable
fun MovieDetailsActionButtons(modifier: Modifier = Modifier) {
    Row (horizontalArrangement = Arrangement.spacedBy(MARGIN_XXLARGE), modifier = modifier.padding(start = MARGIN_LARGE)){
        MovieDetailsActionButton(
            label = stringResource(R.string.my_list),
            icon = IconSource.PainterSource(painterResource(R.drawable.add))
        )
        MovieDetailsActionButton(
            label = stringResource(R.string.rate),
            icon = IconSource.PainterSource(painterResource(R.drawable.rate))
        )
        MovieDetailsActionButton(
            label = stringResource(R.string.share),
            icon = IconSource.PainterSource(painterResource(R.drawable.share))
        )
    }
}

@Composable
fun MovieDetailsActionButton(label: String, icon: IconSource, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MARGIN_SMALL),
        modifier = modifier
    ) {
        // Icon
        when (icon) {
            is IconSource.VectorSource -> {
                Icon(
                    icon.vector,
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(MARGIN_MEDIUM_3)
                )
            }

            is IconSource.PainterSource -> {
                Icon(
                    icon.painter,
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(MARGIN_MEDIUM_3)
                )
            }
        }
        // Label
        Text(label, color = White, fontFamily = NetflixSansFontFamily, fontSize = TEXT_SMALL)
    }
}

@Preview
@Composable
private fun MovieDetailsActionButtonsPreview() {
    NetflixCloneJetpackComposeTheme {
       MovieDetailsActionButtons()
    }
}