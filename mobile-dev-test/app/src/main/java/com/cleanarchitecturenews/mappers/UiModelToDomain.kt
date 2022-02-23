package com.cleanarchitecturenews.mappers

import com.cleanarchitecturenews.models.*
import com.domain.models.*

internal fun NewsUiModel.toDomain()= News(
    this.status,
    this.totalResults,
    this.articles?.map { it.toDomain() }
)

internal fun ArticleUiModel.toDomain()= Article(
    this.source?.toDomain(),
    this.author,
    this.title,
    this.description,
    this.url,
    this.urlToImage,
    this.publishedAt,
    this.content
)

internal fun SourceUiModel.toDomain()= Source(
    this.id,
    this.name
)

internal fun LikesUiModel.toDomain()= Likes(
    this.likes
)

internal fun CommentsUiModel.toDomain()= Comments(
    this.comments,
)
