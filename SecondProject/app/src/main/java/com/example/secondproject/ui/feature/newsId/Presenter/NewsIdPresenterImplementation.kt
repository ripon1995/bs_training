package com.example.secondproject.ui.feature.newsId.Presenter

import com.example.secondproject.dataSource.RestApiDataSource
import com.example.secondproject.ui.feature.newsId.view.NewsIdListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsIdPresenterImplementation(
    private var restApiDataSource: RestApiDataSource,
    private var newsIdListView: NewsIdListView,
    var compositeDisposable: CompositeDisposable
) : NewsIdPresenter {
    override fun fetchNewsStoryId() {

        compositeDisposable.add(
            restApiDataSource.fetchNewsId()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    newsIdListView.showNewsIdList(it)
                }, {
                    println("Error: " + it.message)
                })
        )
    }
}