package com.zg.netflixloginscreenjetpackcompose.ui.resusable_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_CARD_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixRedPrimary
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun NetflixTabBar(tabs: List<String>, modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(tabs.first()) }

    Row(horizontalArrangement = Arrangement.spacedBy(MARGIN_LARGE), modifier = modifier) {
        tabs.forEach {
            NetflixTab(label = it,
                isSelected = selectedTab == it,
                onSelectTab = {
                    selectedTab = it
                })
        }
    }
}

@Composable
fun NetflixTab(label: String, isSelected: Boolean, onSelectTab: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .width(IntrinsicSize.Max)
        .clickable { onSelectTab() }) {
        // Indicator
        if (isSelected)
            Box(
                modifier = Modifier
                    .background(color = NetflixRedPrimary)
                    .height(MARGIN_SMALL)
                    .fillMaxWidth()
            )
        else
            Spacer(Modifier.height(MARGIN_SMALL))

        Spacer(Modifier.height(MARGIN_CARD_MEDIUM_2))
        // Tab Label
        Text(label, color = White, fontWeight = FontWeight.Bold, fontFamily = NetflixSansFontFamily)
    }
}

@Preview
@Composable
private fun NetflixTabBarPreview() {
    NetflixCloneJetpackComposeTheme {
        NetflixTabBar(listOf("More Like This", "Trailers and More"))
    }
}