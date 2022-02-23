package com.cleanarchitecturenews.mappers

import com.cleanarchitecturenews.models.*
import com.domain.models.*

internal fun News.toUiModel() = NewsUiModel(
    this.status,
    this.totalResults,
    this.articles?.map { it.toUiModel() }
)

internal fun Article.toUiModel() = ArticleUiModel(
    this.source?.toUiModel(),
    this.author,
    this.title,
    this.description,
    this.url,
    this.urlToImage,
    this.publishedAt,
    this.content
)

internal fun Source.toUiModel() = SourceUiModel(
    this.id,
    this.name
)

internal fun Likes.toUiModel() = LikesUiModel(
    this.likes
)

internal fun Comments.toUiModel() = CommentsUiModel(
    this.comments,
)
