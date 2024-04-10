package com.study.newsapp.data.api

import javax.inject.Inject

class TestRepository @Inject constructor(private val newsService: NewsService){

    suspend fun getAll() = newsService.getHeadlines()

}