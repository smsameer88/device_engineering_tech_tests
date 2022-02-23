package com.cleanarchitecturenews.models

data class NewsUiModel(
    val status: String?,
    val totalResults: Int?,
    val articles: List<ArticleUiModel>?
)