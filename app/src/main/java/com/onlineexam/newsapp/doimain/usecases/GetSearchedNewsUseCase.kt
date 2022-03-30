package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.util.Resource
import com.onlineexam.newsapp.doimain.repository.NewsRepository


class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
     suspend fun execute(country:String,searchQuery:String,page:Int): Resource<ApiResponse> {
         return newsRepository.getSearchedNews(country,searchQuery,page)
     }
}