package com.onlineexam.newsapp.presenter.di

import com.onlineexam.newsapp.data.api.NewsService
import com.onlineexam.newsapp.data.db.NewsDao
import com.onlineexam.newsapp.data.repository.datasources.OnlineDataSource
import com.onlineexam.newsapp.data.repository.datasourcesimpl.LocalDataSourceImpl
import com.onlineexam.newsapp.data.repository.datasourcesimpl.OnlineDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class OnlineDataSourceModule {

    @Provides
    @Singleton
    fun provideOnlineDataSource(newsService: NewsService): OnlineDataSource {
        return OnlineDataSourceImpl(newsService)
    }

}