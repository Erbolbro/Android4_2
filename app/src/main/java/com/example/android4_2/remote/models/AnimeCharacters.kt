package com.example.android4_2.remote.models

import com.google.gson.annotations.SerializedName

data class AnimeCharacters(
    @SerializedName("links")
    val links: LinksX
)