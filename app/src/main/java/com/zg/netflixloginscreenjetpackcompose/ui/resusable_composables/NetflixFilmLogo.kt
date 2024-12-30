package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun NetflixFilmLogo(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(MARGIN_SMALL_2X), modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.netflix_n_logo),
            contentDescription = null,
            modifier = Modifier.size(MARGIN_LARGE)
        )
        Text(
            stringResource(R.string.film), color = White,
            letterSpacing = 5.sp,
            fontFamily = NetflixSansFontFamily
        )
    }
}

@Preview
@Composable
private fun NetflixFilmLogoPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixFilmLogo()
    }
}