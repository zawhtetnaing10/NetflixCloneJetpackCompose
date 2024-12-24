package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.list_items.MobileGameListItem
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR_2X
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun MobileGamesSection(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM_2), modifier = modifier) {
        MobileGamesHorizontalListHeader(modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2))
        MobileGamesHorizontalList()
    }
}

@Composable
fun MobileGamesHorizontalList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
        modifier = modifier
    ) {
        items((1..10).toList()) {
            MobileGameListItem()
        }
    }
}

@Composable
fun MobileGamesHorizontalListHeader(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(
            stringResource(R.string.mobile_games),
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_REGULAR_2X,
            fontFamily = NetflixSansFontFamily
        )
        Spacer(Modifier.weight(1f))
        Text(
            stringResource(R.string.my_list),
            color = White,
            fontSize = TEXT_REGULAR_2X
        )
        Icon(
            Icons.AutoMirrored.Default.KeyboardArrowRight,
            tint = White,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun MobileGamesHorizontalListPreview() {
    NetflixCloneJetpackComposeTheme {
        MobileGamesSection()
    }
}