package com.domain.repo

import com.domain.models.Comments
import com.domain.models.Likes
import com.domain.models.News
import kotlinx.coroutines.flow.Flow

interface INewsDataRepository {

    suspend fun getNews(): Flow<News?>

    suspend fun getLikes(url: String): Flow<Likes?>

    suspend fun getComments(url: String):Flow<Comments?>
}
