package com.zg.netflixloginscreenjetpackcompose.ui.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HintGrey
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MOBILE_GAME_ITEM_SIZE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun MobileGameListItem(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(MARGIN_SMALL), modifier = modifier.width(MOBILE_GAME_ITEM_SIZE)) {
        Image(
            painterResource(R.drawable.katana_zero_game_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(MOBILE_GAME_ITEM_SIZE)
                .clip(RoundedCornerShape(MARGIN_MEDIUM_3))
        )
        Text(
            "Katana Zero",
            fontSize = TEXT_SMALL,
            color = White,
            fontWeight = FontWeight.Bold,
            fontFamily = NetflixSansFontFamily,
            maxLines = 2,
            lineHeight = 12.sp
        )
        Text(
            "Action",
            fontSize = TEXT_SMALL,
            color = HintGrey,
            fontFamily = NetflixSansFontFamily,
            maxLines = 1,
            lineHeight = 12.sp
        )
    }
}

@Preview
@Composable
private fun MobileGameListItemPreview() {
    NetflixCloneJetpackComposeTheme {
        MobileGameListItem()
    }
}