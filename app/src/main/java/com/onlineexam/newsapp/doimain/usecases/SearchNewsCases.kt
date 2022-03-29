package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.util.Resouce
import com.onlineexam.newsapp.doimain.repository.NewsRepository

class SearchNewsCases(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery:String): Resouce<ApiResponse> = newsRepository.getSearchedNews(searchQuery)
}