package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.ui.theme.BUTTON_HEIGHT
import com.zg.netflixloginscreenjetpackcompose.ui.theme.HOME_SCREEN_CATEGORY_BORDER_WIDTH
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_CARD_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_2
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_MEDIUM_3
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_REGULAR
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun HomeScreenCategories(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_CARD_MEDIUM_2),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        // TV Shows
        HomeScreenCategoryItem {
            Text(
                "TV Shows", color = White,
                fontFamily = NetflixSansFontFamily,
                fontSize = TEXT_REGULAR,
                modifier = Modifier.padding(end = MARGIN_MEDIUM)
            )
        }

        // Movies
        HomeScreenCategoryItem {
            Text(
                "Movies", color = White,
                fontFamily = NetflixSansFontFamily,
                fontSize = TEXT_REGULAR,
                modifier = Modifier.padding(end = MARGIN_MEDIUM)
            )
        }

        // Categories
        HomeScreenCategoryItem {
            Row(horizontalArrangement = Arrangement.spacedBy(MARGIN_SMALL)) {
                Text(
                    "Categories", color = White,
                    fontFamily = NetflixSansFontFamily,
                    fontSize = TEXT_REGULAR,
                )

                Icon(Icons.Default.KeyboardArrowDown, tint = White, contentDescription = "Categories")
            }
        }

    }
}

@Composable
fun HomeScreenCategoryItem(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(
        color = Color.Transparent,
        border = BorderStroke(width = HOME_SCREEN_CATEGORY_BORDER_WIDTH, color = Color.White),
        shape = RoundedCornerShape(MARGIN_MEDIUM_3),
        modifier = modifier.height(BUTTON_HEIGHT)
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.padding(
                start = MARGIN_MEDIUM_2,
                end = MARGIN_MEDIUM
            )
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun HomeScreenCategoriesPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreenCategories()
    }
}