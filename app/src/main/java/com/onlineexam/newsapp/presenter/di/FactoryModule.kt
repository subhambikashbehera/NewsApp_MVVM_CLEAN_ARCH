package com.onlineexam.newsapp.presenter.di

import com.onlineexam.newsapp.doimain.usecases.*
import com.onlineexam.newsapp.presenter.view.viewmodel.LiveNewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {



    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        getNewsHeadlinesUseCase: GetNewsUseCases,
        deleteSavedNewsUseCase: DeleteNewsCases,
        getSavedNewsUseCase: GetSavedNewsUseCases,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCases


    ):LiveNewsViewModelFactory{
        return LiveNewsViewModelFactory(
            getNewsHeadlinesUseCase,
            deleteSavedNewsUseCase,
            getSavedNewsUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase
        )
    }


}