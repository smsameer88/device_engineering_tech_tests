package com.cleanarchitecturenews.models

data class ArticleUiModel(
    val source: SourceUiModel?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)