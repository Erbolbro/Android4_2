package com.example.android4_2.remote.models

import com.example.android4_2.ui.models.AnimeData
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("relationships")
    val relationships: Relationships,
    @SerializedName("type")
    val type: String
)

fun AnimeData.toUI() = AnimeData(
    id = links.replace("https://kitsu.io/api/edge/anime", "/").replace("/", "")
        .toInt(),
    links = links,
    posterImage = posterImage
)