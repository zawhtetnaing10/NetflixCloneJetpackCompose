package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun NetflixOutlineTextField(placeholder: String, onTextChanged: (String) -> Unit, modifier: Modifier = Modifier) {
    var textValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue,
        onValueChange = {
            textValue = it
            onTextChanged(it)
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
                placeholder, style = TextStyle(
                    fontSize = TEXT_REGULAR_2X, color = HintGrey, fontFamily = NetflixSansFontFamily
                )
            )
        },
        shape = RoundedCornerShape(MARGIN_MEDIUM),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun NetflixOutlineTextFieldPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixOutlineTextField(placeholder = "Email or password", onTextChanged = {})
    }
}