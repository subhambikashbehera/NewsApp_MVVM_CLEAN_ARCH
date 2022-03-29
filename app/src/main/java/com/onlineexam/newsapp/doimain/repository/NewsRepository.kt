package com.onlineexam.newsapp.doimain.repository

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.data.util.Resouce
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    fun getHeadLines() : Resouce<ApiResponse>
    fun getSearchedNews(searchQuery:String) : Resouce<ApiResponse>
    fun saveNews(article:Article)
    fun deleteNews(article:Article)
    fun getSavedNews(): Flow<List<Article>>

}