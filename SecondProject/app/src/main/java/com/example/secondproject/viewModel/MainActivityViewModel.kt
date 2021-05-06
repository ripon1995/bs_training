package com.example.secondproject.viewModel

import androidx.lifecycle.ViewModel
import com.example.secondproject.repository.RestApiDataSource
import com.example.secondproject.ui.feature.news.view.NewsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(private var restApiDataSource: RestApiDataSource,
                    private var newsView: NewsView,
                    var compositeDisposable: CompositeDisposable
) :ViewModel(){
    fun fetchNewsStoryId() {

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

    fun fetchNewsDetails(id: Int) {

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