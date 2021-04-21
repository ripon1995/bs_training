package com.example.firstproject.ui.features.news.view

import com.example.firstproject.dataSource.model.Post

interface NewsView {
    fun showNewsList(newsList: List<Post>)
}