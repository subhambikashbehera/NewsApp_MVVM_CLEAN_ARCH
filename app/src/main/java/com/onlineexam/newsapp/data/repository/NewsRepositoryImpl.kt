package com.onlineexam.newsapp.data.repository

import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.data.repository.datasources.LocalDataSource
import com.onlineexam.newsapp.data.repository.datasources.OnlineDataSource
import com.onlineexam.newsapp.data.util.Resource
import com.onlineexam.newsapp.doimain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private var onlineDataSource: OnlineDataSource,
    private var localDataSource: LocalDataSource,
) : NewsRepository {

    private fun responseToResource(response: Response<ApiResponse>): Resource<ApiResponse>{
        if (response.isSuccessful) {
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun getHeadLines(page: Int, country: String): Resource<ApiResponse> {
        return responseToResource(onlineDataSource.getNewsFromApi(page, country))
    }

    override suspend fun getSearchedNews(country: String, searchQuery: String, page: Int): Resource<ApiResponse> {
     return responseToResource(onlineDataSource.getSearchedNews(country,searchQuery,page))
    }

    override suspend fun saveNews(article: Article) {
       localDataSource.saveNewsDb(article)
    }

    override suspend fun deleteNews(article: Article) {
       localDataSource.deleteNewsDb(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return   localDataSource.getNewsDb()
    }

}