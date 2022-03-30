package com.onlineexam.newsapp.presenter.di

import com.onlineexam.newsapp.data.repository.NewsRepositoryImpl
import com.onlineexam.newsapp.data.repository.datasources.LocalDataSource
import com.onlineexam.newsapp.data.repository.datasources.OnlineDataSource
import com.onlineexam.newsapp.doimain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule{

    @Provides
    @Singleton
    fun provideRepository(onlineDataSource:OnlineDataSource,localDataSource: LocalDataSource): NewsRepository {
        return NewsRepositoryImpl(onlineDataSource, localDataSource)
    }

}