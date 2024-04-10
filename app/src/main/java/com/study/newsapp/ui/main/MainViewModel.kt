package com.study.newsapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.newsapp.data.api.TestRepository
import com.study.newsapp.models.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TestRepository) : ViewModel(){

    private val _all = MutableLiveData<NewsResponse>()
    val all : LiveData<NewsResponse>
        get() = _all

    init {
        Log.d("MainViewModel", "init: Loading data")
        getAll()
    }

    fun getAll() = viewModelScope.launch {
        Log.d("MainViewModel", "getAll: Fetching data from repository")
        repository.getAll().let {
            if (it.isSuccessful){
                Log.d("MainViewModel", "getAll: Data fetch successful")
                _all.postValue(it.body())
            } else {
                Log.d ("checkData", "Failed to load articles: ${it.errorBody()}")
            }
        }
    }
}