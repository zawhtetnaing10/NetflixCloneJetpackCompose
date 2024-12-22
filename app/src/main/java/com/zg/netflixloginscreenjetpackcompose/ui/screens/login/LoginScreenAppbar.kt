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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
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
                modifier = Modifier.size(130.dp)
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null,
                tint = White,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(32.dp)
            )
        },
        actions = {
            Text(
                "Help",
                style = TextStyle(color = White, fontWeight = FontWeight.Bold, fontSize = 16.sp, fontFamily = NetflixSansFontFamily),
                modifier = Modifier.padding(end = 16.dp)
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