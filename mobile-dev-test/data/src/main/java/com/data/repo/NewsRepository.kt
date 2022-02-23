package com.data.repo

import com.data.mappers.toDomain
import com.data.source.NewsSource
import com.domain.models.Comments
import com.domain.models.Likes
import com.domain.models.News
import com.domain.repo.INewsDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsSource: NewsSource) :
    INewsDataRepository {

    override suspend fun getNews(): Flow<News> {
        return newsSource.getAllNews().map {
            it!!.toDomain()
        }
    }

    override suspend fun getLikes(url: String): Flow<Likes?> {
        return newsSource.getLikes(url).map {
            it?.toDomain()
        }
    }

    override suspend fun getComments(url: String): Flow<Comments?> {
        return newsSource.getComments(url).map {
            it?.toDomain()
        }
    }
}
