package com.data.api

import com.data.models.CommentsEntity
import com.data.models.LikesEntity
import com.data.models.NewsEntity
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApiService {

    @GET("top-headlines?country=us&category=business&apiKey=1271dae3c97a4375883aba79a2bf8bee")
    suspend fun getAllNewsData(): NewsEntity

    @GET("")
    suspend fun getLikes(@Url url: String): LikesEntity

    @GET("")
    suspend fun getComments(@Url url: String): CommentsEntity
}
