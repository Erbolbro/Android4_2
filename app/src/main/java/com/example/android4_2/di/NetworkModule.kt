package com.example.android4_2.di

import com.example.android4_2.remote.apiservices.AnimeApi
import com.example.android4_2.remote.repositories.AnimeRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {

    @Provides
    @Singleton
    fun provideAnimeRepositories(animeApi: AnimeApi) = AnimeRepositories(animeApi)
}