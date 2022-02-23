package com.cleanarchitecturenews.di

import com.domain.repo.INewsDataRepository
import com.data.repo.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindingModule {

    @Singleton
    @Binds
    abstract fun provideNewsRepository(newsRepository: NewsRepository): INewsDataRepository
}
