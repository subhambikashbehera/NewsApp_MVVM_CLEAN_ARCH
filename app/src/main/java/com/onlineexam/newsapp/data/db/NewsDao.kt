package com.onlineexam.newsapp.data.db

import androidx.room.*
import com.onlineexam.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(article: Article)

    @Delete
    suspend fun deleteNews(article: Article)

    @Query("SELECT * FROM NEWSTABLE")
    fun getNews():Flow<List<Article>>



}