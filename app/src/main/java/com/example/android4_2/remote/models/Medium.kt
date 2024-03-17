package com.example.android4_2.remote.models

import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("height")
    val height: Any,
    @SerializedName("width")
    val width: Any
)