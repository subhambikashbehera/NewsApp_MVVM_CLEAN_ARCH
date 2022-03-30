package com.onlineexam.newsapp.data.api

import com.onlineexam.newsapp.BuildConfig
import com.onlineexam.newsapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {


    @GET("/v2/top-headlines")
    suspend fun getHeading(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apikey: String = BuildConfig.API_KEY
    ): Response<ApiResponse>


    @GET("v2/top-headlines")
    suspend fun getSearchedTopHeadlines(
        @Query("country")
        country:String,
        @Query("q")
        searchQuery:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<ApiResponse>

}