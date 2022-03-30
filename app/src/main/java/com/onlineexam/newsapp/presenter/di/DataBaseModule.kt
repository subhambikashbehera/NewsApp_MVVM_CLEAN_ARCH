package com.onlineexam.newsapp.presenter.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.onlineexam.newsapp.data.db.NewsDao
import com.onlineexam.newsapp.data.db.NewsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideNewsDataBase(app: Application):NewsDataBase{
        return Room.databaseBuilder(app,NewsDataBase::class.java,"newsDb").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(dataBase: NewsDataBase):NewsDao{
       return dataBase.newsDao()
    }

}