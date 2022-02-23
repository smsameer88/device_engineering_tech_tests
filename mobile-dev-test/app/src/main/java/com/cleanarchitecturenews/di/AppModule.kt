package com.cleanarchitecturenews.di

import com.data.api.NewsApiService
import com.domain.usecases.GetAllNewsUseCase
import com.domain.usecases.GetCommentsUseCase
import com.domain.usecases.GetLikesUseCase
import com.data.repo.NewsRepository
import com.data.source.NewsSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideNewsSource(apiService: NewsApiService) =
        NewsSource(apiService)

    @Provides
    fun provideGetAllNewsUseCase(newsRepository: NewsRepository) =
        GetAllNewsUseCase(newsRepository)

    @Provides
    fun provideGetLikesUseCase(newsRepository: NewsRepository) =
        GetLikesUseCase(newsRepository)

    @Provides
    fun provideGetCommentsUseCase(newsRepository: NewsRepository) =
        GetCommentsUseCase(newsRepository)
}
