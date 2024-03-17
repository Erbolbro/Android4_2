package com.example.android4_2.remote.models

import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("animeCharacters")
    val animeCharacters: AnimeCharacters,
    @SerializedName("animeProductions")
    val animeProductions: AnimeProductions,
    @SerializedName("animeStaff")
    val animeStaff: AnimeStaff,
    @SerializedName("castings")
    val castings: Castings,
    @SerializedName("categories")
    val categories: Categories,
    @SerializedName("episodes")
    val episodes: Episodes,
    @SerializedName("genres")
    val genres: Genres,
    @SerializedName("installments")
    val installments: Installments,
    @SerializedName("mappings")
    val mappings: Mappings,
    @SerializedName("mediaRelationships")
    val mediaRelationships: MediaRelationships,
    @SerializedName("reviews")
    val reviews: Reviews,
    @SerializedName("streamingLinks")
    val streamingLinks: StreamingLinks
)