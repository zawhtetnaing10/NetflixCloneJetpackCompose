package com.zg.netflixloginscreenjetpackcompose.ui.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixOutlineTextField
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixPasswordTextField
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixPrimaryButton
import com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables.NetflixSecondaryButton
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.LINE_HEIGHT_REGULAR
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XXLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR

@Composable
fun NetflixLoginScreen(onTapSignIn: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        LoginScreenAppbar()
    }, modifier = modifier.fillMaxSize()) { innerPadding ->
        NetflixLoginContent(
            onTapSignIn = onTapSignIn,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun NetflixLoginContent(onTapSignIn : () -> Unit, modifier: Modifier = Modifier) {
    Surface(color = Black, modifier = modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Column(modifier = Modifier.padding(MARGIN_XXLARGE)) {
                NetflixOutlineTextField(
                    placeholder = stringResource(R.string.email_or_phone_number_placeholder),
                    onTextChanged = {
                        // TODO: - Communicate with ViewModel later.
                    }
                )
                Spacer(Modifier.height(MARGIN_MEDIUM_2))
                NetflixPasswordTextField(
                    placeholder = stringResource(R.string.password_placeholder),
                    onChangePassword = {
                        // TODO: - Communicate with ViewModel later
                    }
                )
                Spacer(Modifier.height(MARGIN_MEDIUM_2))
                NetflixPrimaryButton(
                    title = stringResource(R.string.sign_in),
                    onButtonTapped = {
                        // TODO: - Communicate with ViewModel later
                        onTapSignIn()
                    }
                )
                Spacer(Modifier.height(MARGIN_MEDIUM_2))
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        stringResource(R.string.or), style = TextStyle(
                            fontFamily = NetflixSansFontFamily
                        )
                    )
                }
                Spacer(Modifier.height(MARGIN_MEDIUM_2))
                NetflixSecondaryButton(
                    label = stringResource(R.string.use_a_sign_in_code),
                    onTapButton = {
                        // TODO: - Communicate with ViewModel later
                    }
                )
                Spacer(Modifier.height(MARGIN_XLARGE))
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                    Text(stringResource(R.string.forgot_password), style = TextStyle(fontWeight = FontWeight.SemiBold, fontFamily = NetflixSansFontFamily))
                }
                Spacer(Modifier.height(MARGIN_XLARGE))
                SignInTermsAndConditions()
            }
        }
    }
}

@Composable
fun SignInTermsAndConditions(modifier: Modifier = Modifier) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = HintGrey, fontSize = TEXT_REGULAR)) {
            append(stringResource(R.string.sign_in_protected_by_recaptcha))
        }
        withStyle(style = SpanStyle(color = HintGrey, fontWeight = FontWeight.Bold, fontSize = TEXT_REGULAR)) {
            append(stringResource(R.string.learn_more))
        }
    }

    Text(
        annotatedText,
        textAlign = TextAlign.Center,
        style = TextStyle(lineHeight = LINE_HEIGHT_REGULAR, fontFamily = NetflixSansFontFamily),
        modifier = modifier
    )
}

@Preview(showBackground = true, name = "NetflixLoginPreview")
@Composable
fun NetflixLoginScreenPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixLoginScreen(onTapSignIn = {})
    }
}