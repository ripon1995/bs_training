package com.example.secondproject.ui.feature.newsStoriesDetails.presenter

import com.example.secondproject.dataSource.RestApiDataSource
import com.example.secondproject.ui.feature.newsStoriesDetails.view.NewsDetailsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsDetailsPresenterImplementation(
    private var restApiDataSource: RestApiDataSource,
    private var newsDetailsView: NewsDetailsView,
    var compositeDisposable: CompositeDisposable
) : NewsDetailsPresenter {
    override fun fetchNewsDetails(id: Int) {

        compositeDisposable.add(
            restApiDataSource.fetchNewsSotriesDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    newsDetailsView.showNewsDetails(it)
                })
        )
    }

}