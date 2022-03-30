package com.onlineexam.newsapp.doimain.repository

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    suspend fun getHeadLines(page:Int,country:String): Resource<ApiResponse>
    suspend fun getSearchedNews(country: String, searchQuery: String, page: Int): Resource<ApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>

}