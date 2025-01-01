package com.zg.netflixloginscreenjetpackcompose.ui.utils

import androidx.compose.ui.unit.Dp
import kotlin.math.ceil

/**
 * Calculates the height of a GridView.
 * This is necessary when using a LazyVerticalGrid inside a LazyColumn.
 * @param noOfItems Number of items in the grid
 * @param noOfColumns Number of columns of the grid
 * @param heightPerItem Height of a single item in the grid measured in DP
 * @return The total height of the LazyVerticalGrid
 */
fun calculateHeightForGrid(noOfItems : Int, noOfColumns: Int, heightPerItem: Dp) : Dp{
    val numberOfRow = ceil(noOfItems.toDouble() / noOfColumns.toDouble()).toInt()
    return heightPerItem * numberOfRow.toFloat()
}