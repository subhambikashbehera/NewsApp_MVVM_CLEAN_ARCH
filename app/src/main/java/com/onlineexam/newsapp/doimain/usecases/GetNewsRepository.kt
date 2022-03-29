package com.onlineexam.newsapp.doimain.usecases

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.util.Resouce
import com.onlineexam.newsapp.doimain.repository.NewsRepository

class GetNewsRepository(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resouce<ApiResponse> = newsRepository.getHeadLines()
}