package com.onlineexam.newsapp.presenter.di

import com.onlineexam.newsapp.presenter.view.viewmodel.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideAdapter(): NewsAdapter {
        return NewsAdapter()
    }

}