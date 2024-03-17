package com.example.android4_2.remote.models

import com.google.gson.annotations.SerializedName

data class Dimensions(
    @SerializedName("large")
    val large: Large,
    @SerializedName("small")
    val small: Small,
    @SerializedName("tiny")
    val tiny: Tiny
)