package com.zg.netflixloginscreenjetpackcompose.ui.utils

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IconSource{
    data class PainterSource(val painter: Painter) : IconSource()
    data class VectorSource(val vector: ImageVector) : IconSource()
}