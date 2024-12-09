@file:OptIn(ExperimentalMaterial3Api::class)

package com.zg.netflixloginscreenjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixLoginScreenJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.BLACK),
            navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.BLACK)
        )
        setContent {
            NetflixLoginScreenJetpackComposeTheme {
                NetflixLoginScreen()
            }
        }
    }
}

@Composable
fun NetflixLoginScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Black),
            title = {
                Image(
                    painterResource(R.drawable.netflix_logo_app_bar),
                    contentDescription = "Netflix AppBar Title"
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(32.dp)
                )
            },
            actions = {
                Text(
                    "Help",
                    style = TextStyle(color = White, fontWeight = FontWeight.Bold, fontSize = 16.sp),
                    modifier = Modifier.padding(end = 12.dp)
                )
            }
        )
    }, modifier = modifier.fillMaxSize()) { innerPadding ->
        NetflixLoginContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun NetflixLoginContent(modifier: Modifier = Modifier) {
    Surface(color = Black, modifier = modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Text("Netflix")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetflixLoginScreenJetpackComposeTheme {
        NetflixLoginScreen()
    }
}