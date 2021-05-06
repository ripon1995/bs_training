package com.example.secondproject.ui.feature.newsStoriesDetails.view

import com.example.secondproject.dataSource.model.NewsStoryDetails

interface NewsDetailsView {

    fun showNewsDetails(newsStoryDetails: NewsStoryDetails)
}