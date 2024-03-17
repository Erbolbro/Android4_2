package com.example.android4_2.remote.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: LinksXXXXXXXXXXXXX,
    @SerializedName("meta")
    val meta: MetaXX
)