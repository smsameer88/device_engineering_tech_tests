package com.data.models

data class NewsEntity(
    val status: String?,
    val totalResults: Int?,
    val articles: List<ArticleEntity>?
)