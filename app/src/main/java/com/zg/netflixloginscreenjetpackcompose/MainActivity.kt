@file:OptIn(ExperimentalMaterial3Api::class)

package com.zg.netflixloginscreenjetpackcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.screens.login.NetflixLoginScreen
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.BLACK),
            navigationBarStyle = SystemBarStyle.dark(Color.BLACK)
        )
        setContent {
            NetflixCloneJetpackComposeTheme {
                NetflixLoginScreen()
            }
        }
    }
}


@Preview(showBackground = true, name = "NetflixLoginPreview")
@Composable
fun NetflixLoginPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixLoginScreen()
    }
}