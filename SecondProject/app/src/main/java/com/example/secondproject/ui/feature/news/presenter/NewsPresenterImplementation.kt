package com.example.secondproject.ui.feature.news.presenter

import com.example.secondproject.dataSource.RestApiDataSource
import com.example.secondproject.ui.feature.news.view.NewsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsPresenterImplementation(
    private var restApiDataSource: RestApiDataSource,
    private var newsView: NewsView,
    var compositeDisposable: CompositeDisposable
) : NewsPresenter {
    override fun fetchNewsStoryId() {

        compositeDisposable.add(
            restApiDataSource.fetchNewsId()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    newsView.showNewsIdList(it)
                }, {
                    println("Error: " + it.message)
                })
        )
    }
    override fun fetchNewsDetails(id: Int) {

        compositeDisposable.add(
            restApiDataSource.fetchNewsSotriesDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    newsView.showNewsDetails(it)
                })
        )
    }

}