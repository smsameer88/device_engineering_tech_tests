package com.data.mappers

import com.data.models.*
import com.domain.models.*

internal fun NewsEntity.toDomain() = News(
    this.status,
    this.totalResults,
    this.articles?.map { it.toDomain() }
)

internal fun ArticleEntity.toDomain() = Article(
    this.source?.toDomain(),
    this.author,
    this.title,
    this.description,
    this.url,
    this.urlToImage,
    this.publishedAt,
    this.content
)

internal fun SourceEntity.toDomain() = Source(
    this.id,
    this.name
)

internal fun LikesEntity.toDomain() = Likes(
    this.likes
)

internal fun CommentsEntity.toDomain() = Comments(
    this.comments,
)
