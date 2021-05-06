package com.example.secondproject.ui.feature.news.view

import com.example.secondproject.dataSource.model.NewsStoryDetails

interface NewsView {

    fun showNewsIdList(newsIdList: List<Int>)

    fun showNewsDetails(newsStoryDetails: NewsStoryDetails)
}