package com.onlineexam.newsapp.data.repository.datasourcesimpl

import com.onlineexam.newsapp.data.api.NewsService
import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.repository.datasources.OnlineDataSource
import retrofit2.Response

class OnlineDataSourceImpl(private val newsService: NewsService):OnlineDataSource {

    override suspend fun getNewsFromApi(page: Int, country: String): Response<ApiResponse> {
        return newsService.getHeading(country,page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int,
    ): Response<ApiResponse> {
        return newsService.getSearchedTopHeadlines(country, searchQuery, page)
    }
}