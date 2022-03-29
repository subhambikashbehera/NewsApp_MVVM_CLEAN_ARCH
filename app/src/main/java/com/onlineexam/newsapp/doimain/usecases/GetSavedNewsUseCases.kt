package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.doimain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCases(private val newsRepository: NewsRepository) {

    fun excecute(): Flow<List<Article>> = newsRepository.getSavedNews()
}