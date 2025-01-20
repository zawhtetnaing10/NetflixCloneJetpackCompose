package com.zg.netflixloginscreenjetpackcompose.utils

import kotlinx.serialization.json.Json

val universalJsonConverter = Json{
    ignoreUnknownKeys = true
    explicitNulls = false
}