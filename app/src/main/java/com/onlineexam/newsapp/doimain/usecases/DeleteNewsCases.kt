package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.doimain.repository.NewsRepository

class DeleteNewsCases(private val newsRepository: NewsRepository) {
    suspend fun excute(article: Article)= newsRepository.deleteNews(article)
}