@file:OptIn(ExperimentalMaterial3Api::class)

package com.zg.netflixloginscreenjetpackcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixLoginScreenJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
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
                    textStyle = TextStyle(
                        fontFamily = NetflixSansFontFamily
                    ),
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
                                fontSize = 16.sp, color = HintGrey, fontFamily = NetflixSansFontFamily
                            )
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(Modifier.height(16.dp))

                // Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    visualTransformation = if (isPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
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
                    textStyle = TextStyle(
                        fontFamily = NetflixSansFontFamily
                    ),
                    placeholder = {
                        Text(
                            "Password",
                            style = TextStyle(
                                fontSize = 16.sp, color = HintGrey, fontFamily = NetflixSansFontFamily
                            ),
                        )
                    },
                    suffix = {
                        Text(
                            if (isPasswordHidden) "SHOW" else "HIDE", style = TextStyle(
                                fontSize = 16.sp,
                                color = HintGrey,
                                fontFamily = NetflixSansFontFamily
                            ),
                            modifier = Modifier.clickable {
                                isPasswordHidden = !isPasswordHidden
                            }
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                // Spacer
                Spacer(Modifier.height(16.dp))

                // Sign In Button
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        "Sign In", style = TextStyle(
                            color = HintGrey, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = NetflixSansFontFamily
                        )
                    )
                }

                // Spacer
                Spacer(Modifier.height(16.dp))

                // OR
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "OR", style = TextStyle(
                            fontFamily = NetflixSansFontFamily
                        )
                    )
                }

                // Spacer
                Spacer(Modifier.height(16.dp))

                // Use a Sign-in Code
                // Sign In Button
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NetflixGrey
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        "Use a Sign-In Code", style = TextStyle(
                            color = White, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = NetflixSansFontFamily
                        )
                    )
                }

                // Spacer
                Spacer(Modifier.height(32.dp))

                // Forgot Password
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text("Forgot Password?", style = TextStyle(fontWeight = FontWeight.SemiBold, fontFamily = NetflixSansFontFamily))
                }

                // Spacer
                Spacer(Modifier.height(32.dp))

                // RECAPTCHA text
                SignInTermsAndConditions()
            }
        }
    }
}

@Composable
fun SignInTermsAndConditions(modifier: Modifier = Modifier) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = HintGrey, fontSize = 14.sp)) {
            append("Sign is protected by Google reCAPTCHA to ensure you are not a robot.")
        }
        withStyle(style = SpanStyle(color = HintGrey, fontWeight = FontWeight.Bold, fontSize = 14.sp)) {
            append(" Learn more.")
        }
    }

    Text(
        annotatedText,
        textAlign = TextAlign.Center,
        style = TextStyle(lineHeight = 18.sp, fontFamily = NetflixSansFontFamily),
        modifier = modifier
    )
}


@Preview(showBackground = true, name = "NetflixLoginPreview")
@Composable
fun NetflixLoginPreview() {
    NetflixLoginScreenJetpackComposeTheme {
        NetflixLoginScreen()
    }
}