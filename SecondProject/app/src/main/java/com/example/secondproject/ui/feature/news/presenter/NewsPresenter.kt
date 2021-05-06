package com.example.secondproject.ui.feature.news.presenter

interface NewsPresenter {

    fun fetchNewsStoryId()

    fun fetchNewsDetails(id: Int)
}