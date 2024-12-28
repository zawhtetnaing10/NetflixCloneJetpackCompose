package com.zg.netflixloginscreenjetpackcompose.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zg.netflixloginscreenjetpackcompose.R
import com.zg.netflixloginscreenjetpackcompose.ui.theme.BottomNavigationBackground
import com.zg.netflixloginscreenjetpackcompose.ui.theme.BottomNavigationUnSelectedColor
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_LARGE
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixCloneJetpackComposeTheme
import com.zg.netflixloginscreenjetpackcompose.ui.theme.NetflixSansFontFamily
import com.zg.netflixloginscreenjetpackcompose.ui.theme.TEXT_SMALL
import com.zg.netflixloginscreenjetpackcompose.ui.theme.White

@Composable
fun HomeScreenBottomNavigationBar(modifier: Modifier = Modifier) {

    var selectedBottomNavigationBarItem by remember { mutableIntStateOf(R.string.home) }

    NavigationBar(containerColor = BottomNavigationBackground, modifier = modifier) {
        CustomNavigationBarItem(
            label = R.string.home,
            icon = R.drawable.home,
            onClick = {
                selectedBottomNavigationBarItem = R.string.home
            },
            selectedIconColor = Color.White,
            unSelectedIconColor = BottomNavigationUnSelectedColor,
            isSelected = selectedBottomNavigationBarItem == R.string.home,
        )
        CustomNavigationBarItem(
            label = R.string.new_and_hot,
            icon = R.drawable.play,
            onClick = {
                selectedBottomNavigationBarItem = R.string.new_and_hot
            },
            selectedIconColor = Color.White,
            unSelectedIconColor = BottomNavigationUnSelectedColor,
            isSelected = selectedBottomNavigationBarItem == R.string.new_and_hot,
        )
        CustomNavigationBarItem(
            label = R.string.my_netflix,
            icon = R.drawable.netflix_default_profile,
            onClick = {
                selectedBottomNavigationBarItem = R.string.my_netflix
            },
            selectedIconColor = Color.Unspecified,
            unSelectedIconColor = Color.Unspecified,
            isSelected = selectedBottomNavigationBarItem == R.string.my_netflix,
        )
    }
}

@Composable
fun RowScope.CustomNavigationBarItem(
    @StringRes label: Int,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    selectedIconColor: Color,
    unSelectedIconColor: Color,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    NavigationBarItem(
        selected = isSelected,
        icon = {
            if (label == R.string.my_netflix)
                // The profile picture has to keep the original color.
                Image(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(MARGIN_LARGE).clip(RoundedCornerShape(MARGIN_SMALL))
                )
            else
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(MARGIN_LARGE)
                )
        },
        onClick = onClick,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = selectedIconColor,
            unselectedIconColor = unSelectedIconColor,
            selectedTextColor = White,
            unselectedTextColor = BottomNavigationUnSelectedColor,
            indicatorColor = Color.Transparent
        ),
        label = {
            Text(
                stringResource(label),
                fontFamily = NetflixSansFontFamily, fontSize = TEXT_SMALL
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun HomeScreenBottomNavigationBarPreview() {
    NetflixCloneJetpackComposeTheme {
        HomeScreenBottomNavigationBar()
    }
}