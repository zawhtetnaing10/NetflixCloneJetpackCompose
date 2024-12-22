package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun NetflixPasswordTextField(placeholder: String, onChangePassword: (String) -> Unit, modifier: Modifier = Modifier) {
    var password by remember { mutableStateOf("") }
    var isPasswordHidden by remember { mutableStateOf(true) }

    // Password
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
            onChangePassword(it)
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
                placeholder,
                style = TextStyle(
                    fontSize = TEXT_REGULAR_2X, color = HintGrey, fontFamily = NetflixSansFontFamily
                ),
            )
        },
        suffix = {
            Text(
                if (isPasswordHidden)
                    stringResource(R.string.password_show)
                else
                    stringResource(R.string.password_hide),
                style = TextStyle(
                    fontSize = TEXT_REGULAR_2X,
                    color = HintGrey,
                    fontFamily = NetflixSansFontFamily
                ),
                modifier = Modifier.clickable {
                    isPasswordHidden = !isPasswordHidden
                }
            )
        },
        shape = RoundedCornerShape(MARGIN_MEDIUM),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun NetflixPasswordTextFieldPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixPasswordTextField(placeholder = "Password", onChangePassword = {})
    }
}