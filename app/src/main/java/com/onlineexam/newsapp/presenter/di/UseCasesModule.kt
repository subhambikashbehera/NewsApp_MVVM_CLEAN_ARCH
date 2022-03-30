package com.onlineexam.newsapp.presenter.di

import com.onlineexam.newsapp.doimain.repository.NewsRepository
import com.onlineexam.newsapp.doimain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Singleton
    @Provides
    fun provideGetNewsUseCases(newsRepository: NewsRepository):GetNewsUseCases{
       return GetNewsUseCases(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsUseCase(
        newsRepository: NewsRepository
    ): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(
        newsRepository: NewsRepository
    ):SaveNewsUseCases{
        return SaveNewsUseCases(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSavedNewsUseCases{
        return GetSavedNewsUseCases(newsRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteSavedNewsUseCase(
        newsRepository: NewsRepository
    ):DeleteNewsCases{
        return DeleteNewsCases(newsRepository)
    }

}