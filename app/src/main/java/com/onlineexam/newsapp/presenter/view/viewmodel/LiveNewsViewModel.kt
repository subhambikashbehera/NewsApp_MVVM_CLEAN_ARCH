package com.onlineexam.newsapp.presenter.view.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.onlineexam.newsapp.data.model.ApiResponse
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.data.util.Resource
import com.onlineexam.newsapp.doimain.usecases.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LiveNewsViewModel(
    private val getNewsUseCases: GetNewsUseCases,
    private val deleteNewsCases: DeleteNewsCases,
    private val getSavedNewsUseCases: GetSavedNewsUseCases,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCases: SaveNewsUseCases,
) : ViewModel() {

    val topHeadingData:MutableLiveData<Resource<ApiResponse>?> = MutableLiveData()

     fun searchNews(query:String){
         topHeadingData.value=null
         CoroutineScope(Dispatchers.IO).launch {
             topHeadingData.postValue(getSearchedNewsUseCase.execute("us",query,1))
         }
    }

    fun getNewsHeadLines(country:String,page:Int)=viewModelScope.launch(Dispatchers.IO){
        topHeadingData.postValue(Resource.Loading())
        topHeadingData.postValue(getNewsUseCases.execute(page, country))
    }

    //local data
    fun saveArticle(article: Article) = viewModelScope.launch {
        saveNewsUseCases.execute(article)
    }

    fun getSavedNews() = liveData{
        getSavedNewsUseCases.excecute().collect {
            emit(it)
        }
    }

    fun deleteArticle(article: Article) = viewModelScope.launch {
        deleteNewsCases.excute(article)
    }



}