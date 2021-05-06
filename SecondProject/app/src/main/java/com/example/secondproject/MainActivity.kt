package com.example.secondproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondproject.dataSource.RestApiDataSource
import com.example.secondproject.dataSource.RestApiDataSourceImplementation
import com.example.secondproject.dataSource.model.NewsStoryDetails
import com.example.secondproject.ui.feature.newsId.Presenter.NewsIdPresenter
import com.example.secondproject.ui.feature.newsId.Presenter.NewsIdPresenterImplementation
import com.example.secondproject.ui.feature.newsId.view.NewsIdListView
import com.example.secondproject.ui.feature.newsStoriesDetails.presenter.NewsDetailsPresenter
import com.example.secondproject.ui.feature.newsStoriesDetails.presenter.NewsDetailsPresenterImplementation
import com.example.secondproject.ui.feature.newsStoriesDetails.view.NewsDetailsView
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity(), NewsIdListView, NewsDetailsView {

    private lateinit var newsIdPresenter: NewsIdPresenter
    private lateinit var restApiDataSource: RestApiDataSource
    private lateinit var newsDetailsPresenter: NewsDetailsPresenter
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restApiDataSource = RestApiDataSourceImplementation()
        newsIdPresenter =
            NewsIdPresenterImplementation(restApiDataSource, this, compositeDisposable)
        newsIdPresenter.fetchNewsStoryId()

    }

    override fun showNewsIdList(newsIdList: List<Int>) {
        for (i in newsIdList) {
            println("ID: " + i)
            newsDetailsPresenter =
                NewsDetailsPresenterImplementation(restApiDataSource, this, compositeDisposable)
            newsDetailsPresenter.fetchNewsDetails(i)
        }
    }

    override fun showNewsDetails(newsStoryDetails: NewsStoryDetails) {
        println(newsStoryDetails.by)
        println(newsStoryDetails.descendants)
        println(newsStoryDetails.id)
        println(newsStoryDetails.score)
        println(newsStoryDetails.title)
    }
}