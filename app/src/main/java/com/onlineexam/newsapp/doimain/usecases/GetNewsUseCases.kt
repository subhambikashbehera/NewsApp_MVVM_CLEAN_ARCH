package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.util.Resource
import com.onlineexam.newsapp.doimain.repository.NewsRepository

class GetNewsUseCases(private val newsRepository: NewsRepository) {

    suspend fun execute(page:Int,country:String): Resource<ApiResponse> = newsRepository.getHeadLines(page,country)
}