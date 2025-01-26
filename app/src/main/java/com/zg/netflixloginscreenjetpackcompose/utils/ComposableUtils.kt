package com.zg.netflixloginscreenjetpackcompose.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zg.netflixloginscreenjetpackcompose.ui.theme.MARGIN_XXLARGE

/**
 * Returns whether the lazy list is currently scrolling up.
 */
@Composable
fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableIntStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableIntStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}

/**
 * Returns whether the LazyList is currently at the top.
 */
/**
 * Returns whether the LazyList is currently close to the top within a given offset.
 */
@Composable
fun LazyListState.isCloseToTop(threshold: Dp = MARGIN_XXLARGE): Boolean {
    val thresholdPx = with(LocalDensity.current) { threshold.toPx() }
    return remember(this) {
        derivedStateOf {
            // Check if within the threshold from the top
            firstVisibleItemIndex == 0 && firstVisibleItemScrollOffset <= thresholdPx
        }
    }.value
}