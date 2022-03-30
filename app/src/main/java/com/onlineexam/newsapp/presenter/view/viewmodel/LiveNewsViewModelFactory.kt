package com.onlineexam.newsapp.presenter.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onlineexam.newsapp.doimain.usecases.*

class LiveNewsViewModelFactory(
    private val getNewsUseCases: GetNewsUseCases,
    private val deleteNewsCases: DeleteNewsCases,
    private val getSavedNewsUseCases: GetSavedNewsUseCases,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCases: SaveNewsUseCases,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LiveNewsViewModel(getNewsUseCases,
            deleteNewsCases,
            getSavedNewsUseCases,
            getSearchedNewsUseCase,
            saveNewsUseCases) as T
    }
}