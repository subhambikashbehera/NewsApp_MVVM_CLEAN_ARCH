package com.onlineexam.newsapp.data.repository.datasources

import com.onlineexam.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    fun getNewsDb(): Flow<List<Article>>
    suspend fun saveNewsDb(article:Article)
    suspend fun deleteNewsDb(article: Article)


}