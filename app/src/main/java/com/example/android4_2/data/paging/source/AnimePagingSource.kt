package com.example.android4_2.data.paging.source

import androidx.core.net.toUri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4_2.remote.apiservices.AnimeApi
import com.example.android4_2.remote.models.Data
import okio.IOException

private const val START_KEY = 0

class AnimePagingSource(private val animeApi: AnimeApi) :
    PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {

        return try {
            val offset = params.key ?: START_KEY
            val response = animeApi.getAnime(offset = offset, params.loadSize)
            val nextKey = response.links.next.toUri().getQueryParameter("offset")?.toInt()
            LoadResult.Page(
                data = response.data,
                nextKey = nextKey,
                prevKey = null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)

        } catch (e: retrofit2.HttpException) {
            LoadResult.Error(e)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}