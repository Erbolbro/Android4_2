package com.example.android4_2.remote.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4_2.data.paging.source.AnimePagingSource
import com.example.android4_2.remote.apiservices.AnimeApi
import com.example.android4_2.remote.models.Data
import javax.inject.Inject

class AnimeRepositories @Inject constructor(
    private val animeApi: AnimeApi
) {

    fun fetchAnime(): LiveData<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 40,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(animeApi) }
        ).liveData
    }
}