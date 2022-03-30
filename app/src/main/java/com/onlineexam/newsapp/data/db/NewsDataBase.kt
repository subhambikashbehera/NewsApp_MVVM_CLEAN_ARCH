package com.onlineexam.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.onlineexam.newsapp.data.model.Article

@Database(entities = [Article::class], exportSchema = false, version = 1)
@TypeConverters(Converters::class)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}