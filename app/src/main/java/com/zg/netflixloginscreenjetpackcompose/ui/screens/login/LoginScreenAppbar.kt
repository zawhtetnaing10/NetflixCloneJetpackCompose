package com.zg.netflixloginscreenjetpackcompose.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NETFLIX_LOGO_SIZE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenAppbar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Black),
        title = {
            Image(
                painterResource(R.drawable.netflix_logo_app_bar),
                contentDescription = "Netflix AppBar Title",
                modifier = Modifier.size(NETFLIX_LOGO_SIZE)
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null,
                tint = White,
                modifier = Modifier
                    .padding(start = MARGIN_MEDIUM_3)
                    .size(MARGIN_XLARGE)
            )
        },
        actions = {
            Text(
                stringResource(R.string.help),
                style = TextStyle(color = White, fontWeight = FontWeight.Bold, fontSize = TEXT_REGULAR_2X, fontFamily = NetflixSansFontFamily),
                modifier = Modifier.padding(end = MARGIN_MEDIUM_2)
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun LoginScreenAppbarPreview() {
    NetflixCloneJetpackComposeTheme {
        LoginScreenAppbar()
    }
}