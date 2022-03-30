package com.onlineexam.newsapp.presenter.di

import com.onlineexam.newsapp.data.db.NewsDao
import com.onlineexam.newsapp.data.repository.datasources.LocalDataSource
import com.onlineexam.newsapp.data.repository.datasourcesimpl.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {


    @Provides
    @Singleton
    fun provideLocalDataSource(newsDao: NewsDao):LocalDataSource{
        return LocalDataSourceImpl(newsDao)
    }




}