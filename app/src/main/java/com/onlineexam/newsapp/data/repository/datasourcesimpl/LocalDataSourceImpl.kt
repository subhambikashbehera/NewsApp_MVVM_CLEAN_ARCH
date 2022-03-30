package com.onlineexam.newsapp.data.repository.datasourcesimpl

import com.onlineexam.newsapp.data.db.NewsDao
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.data.repository.datasources.LocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LocalDataSourceImpl(private val newsDao: NewsDao):LocalDataSource {

    override fun getNewsDb(): Flow<List<Article>> {
      return newsDao.getNews()
    }

    override suspend fun saveNewsDb(article: Article) {
        CoroutineScope(Dispatchers.IO).launch {
           newsDao.saveNews(article)
        }
    }

    override suspend fun deleteNewsDb(article: Article) {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.deleteNews(article)
        }
    }
}