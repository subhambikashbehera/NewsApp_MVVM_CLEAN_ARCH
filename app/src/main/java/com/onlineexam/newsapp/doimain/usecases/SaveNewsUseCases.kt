package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.doimain.repository.NewsRepository

class SaveNewsUseCases (private val newsRepository: NewsRepository){

    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}