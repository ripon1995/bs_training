package com.example.secondproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondproject.dataSource.RestApiDataSource
import com.example.secondproject.dataSource.RestApiDataSourceImplementation
import com.example.secondproject.dataSource.model.NewsStoryDetails
import com.example.secondproject.ui.feature.news.presenter.NewsPresenter
import com.example.secondproject.ui.feature.news.presenter.NewsPresenterImplementation
import com.example.secondproject.ui.feature.news.view.NewsView

import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity(), NewsView {

    private lateinit var newsPresenter: NewsPresenter
    private lateinit var restApiDataSource: RestApiDataSource

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restApiDataSource = RestApiDataSourceImplementation()
        newsPresenter =
            NewsPresenterImplementation(restApiDataSource, this, compositeDisposable)
        newsPresenter.fetchNewsStoryId()

    }

    override fun showNewsIdList(newsIdList: List<Int>) {
        for (i in newsIdList){
            println("ID: "+i)
            newsPresenter = NewsPresenterImplementation(restApiDataSource,this,compositeDisposable)
            newsPresenter.fetchNewsDetails(i)
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