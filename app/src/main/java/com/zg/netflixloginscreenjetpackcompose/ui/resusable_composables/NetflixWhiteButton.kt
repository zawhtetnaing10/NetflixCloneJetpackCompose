package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.Black
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XLARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun NetflixRoundedButton(
    label: String,
    icon: ImageVector,
    backgroundColor : Color,
    contentColor : Color,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClicked,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        shape = RoundedCornerShape(MARGIN_MEDIUM),
        contentPadding = PaddingValues(vertical = MARGIN_SMALL, horizontal = MARGIN_LARGE),
        modifier = modifier
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(MARGIN_SMALL), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                icon,
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(MARGIN_XLARGE)
            )

            Text(
                label,
                color = contentColor,
                fontSize = TEXT_REGULAR_2X,
                fontFamily = NetflixSansFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
private fun NetflixWhiteButtonPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixRoundedButton(label = "Play", icon = Icons.Default.PlayArrow, backgroundColor = White, contentColor = Black, onButtonClicked = {})
    }
}