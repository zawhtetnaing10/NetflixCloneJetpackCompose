package com.zg.netflixloginscreenjetpackcompose.ui.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixOutlineTextField
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixPasswordTextField
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixPrimaryButton
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixSecondaryButton
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun NetflixLoginScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        LoginScreenAppbar()
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
            Column(modifier = Modifier.padding(48.dp)) {
                NetflixOutlineTextField(
                    placeholder = stringResource(R.string.email_or_phone_number_placeholder),
                    onTextChanged = {
                        // TODO: - Communicate with ViewModel later.
                    }
                )
                Spacer(Modifier.height(16.dp))
                NetflixPasswordTextField(
                    placeholder = stringResource(R.string.password_placeholder),
                    onChangePassword = {
                        // TODO: - Communicate with ViewModel later
                    }
                )
                Spacer(Modifier.height(16.dp))
                NetflixPrimaryButton(
                    title = stringResource(R.string.sign_in),
                    onButtonTapped = {
                        // TODO: - Communicate with ViewModel later
                    }
                )
                Spacer(Modifier.height(16.dp))
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        stringResource(R.string.or), style = TextStyle(
                            fontFamily = NetflixSansFontFamily
                        )
                    )
                }
                Spacer(Modifier.height(16.dp))
                NetflixSecondaryButton(
                    label = stringResource(R.string.use_a_sign_in_code),
                    onTapButton = {
                        // TODO: - Communicate with ViewModel later
                    }
                )
                Spacer(Modifier.height(32.dp))
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(stringResource(R.string.forgot_password), style = TextStyle(fontWeight = FontWeight.SemiBold, fontFamily = NetflixSansFontFamily))
                }
                Spacer(Modifier.height(32.dp))
                SignInTermsAndConditions()
            }
        }
    }
}

@Composable
fun SignInTermsAndConditions(modifier: Modifier = Modifier) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = HintGrey, fontSize = 14.sp)) {
            append(stringResource(R.string.sign_in_protected_by_recaptcha))
        }
        withStyle(style = SpanStyle(color = HintGrey, fontWeight = FontWeight.Bold, fontSize = 14.sp)) {
            append(stringResource(R.string.learn_more))
        }
    }

    Text(
        annotatedText,
        textAlign = TextAlign.Center,
        style = TextStyle(lineHeight = 18.sp, fontFamily = NetflixSansFontFamily),
        modifier = modifier
    )
}