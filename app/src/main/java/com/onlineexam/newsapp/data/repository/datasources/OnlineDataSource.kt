package com.onlineexam.newsapp.data.repository.datasources

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.util.Resource
import retrofit2.Response

interface OnlineDataSource {
    suspend fun getNewsFromApi( page:Int, country:String):Response<ApiResponse>
    suspend fun getSearchedNews(country : String,searchQuery:String, page : Int):Response<ApiResponse>
}