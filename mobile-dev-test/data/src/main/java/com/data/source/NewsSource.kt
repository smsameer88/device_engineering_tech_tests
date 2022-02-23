package com.data.source

import com.data.api.NewsApiService
import com.data.models.CommentsEntity
import com.data.models.LikesEntity
import com.data.models.NewsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsSource @Inject constructor(private val apiService: NewsApiService) {

    suspend fun getAllNews(): Flow<NewsEntity?> {
        val response = apiService.getAllNewsData()
        return flow { emit(response) }
    }

    suspend fun getLikes(url: String): Flow<LikesEntity?> {
        val response = apiService.getLikes(url)
        return flow { emit(response) }
    }

    suspend fun getComments(url: String): Flow<CommentsEntity?> {
        val response = apiService.getComments(url)
        return flow { emit(response) }
    }
}
