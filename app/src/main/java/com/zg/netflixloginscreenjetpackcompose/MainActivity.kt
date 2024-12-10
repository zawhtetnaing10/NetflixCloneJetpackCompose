package com.zg.netflixloginscreenjetpackcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixLoginScreenJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.BLACK),
            navigationBarStyle = SystemBarStyle.dark(Color.BLACK)
        )
        setContent {
            NetflixLoginScreenJetpackComposeTheme {
                NetflixLoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetflixLoginScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
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

    // State
    var emailOrPhoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordHidden by remember { mutableStateOf(true) }

    Surface(color = Black, modifier = modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Column(modifier = Modifier.padding(48.dp)) {

                // Email or Phone number
                OutlinedTextField(
                    value = emailOrPhoneNumber,
                    onValueChange = {
                        emailOrPhoneNumber = it
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = androidx.compose.ui.graphics.Color.Transparent,
                        unfocusedBorderColor = androidx.compose.ui.graphics.Color.Transparent,
                        focusedContainerColor = NetflixGrey,
                        unfocusedContainerColor = NetflixGrey,
                        focusedTextColor = White,
                        unfocusedTextColor = White,
                        cursorColor = White,
                        focusedLabelColor = androidx.compose.ui.graphics.Color.White,
                    ),
                    placeholder = {
                        Text(
                            "Email or phone number", style = TextStyle(
                                fontSize = 16.sp, color = HintGrey
                            )
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                // Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    visualTransformation = if(isPasswordHidden)PasswordVisualTransformation() else VisualTransformation.None,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = androidx.compose.ui.graphics.Color.Transparent,
                        unfocusedBorderColor = androidx.compose.ui.graphics.Color.Transparent,
                        focusedContainerColor = NetflixGrey,
                        unfocusedContainerColor = NetflixGrey,
                        focusedTextColor = White,
                        unfocusedTextColor = White,
                        cursorColor = White,
                        focusedLabelColor = androidx.compose.ui.graphics.Color.White,
                    ),
                    placeholder = {
                        Text(
                            "Password",
                            style = TextStyle(fontSize = 16.sp, color = HintGrey),
                        )
                    },
                    suffix = {
                        Text(
                            if(isPasswordHidden) "SHOW" else "HIDE", style = TextStyle(
                                fontSize = 16.sp,
                                color = HintGrey,
                            ),
                            modifier = Modifier.clickable {
                                isPasswordHidden = !isPasswordHidden
                            }
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                )

            }
        }
    }
}


@Preview(showBackground = true, name = "NetflixLoginPreview")
@Composable
fun NetflixLoginPreview() {
    NetflixLoginScreenJetpackComposeTheme {
        NetflixLoginScreen()
    }
}