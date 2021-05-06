package com.example.secondproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondproject.repository.RestApiDataSource
import com.example.secondproject.repository.RestApiDataSourceImplementation
import com.example.secondproject.repository.model.NewsStoryDetails
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel(
) : ViewModel() {
    private var compositeDisposable:CompositeDisposable = CompositeDisposable()
    private var restApiDataSource: RestApiDataSource = RestApiDataSourceImplementation()

      var newsDetailsLiveData:MutableLiveData<NewsStoryDetails> = MutableLiveData<NewsStoryDetails>()

    fun fetchNewsStoryId() {

        compositeDisposable.add(
            restApiDataSource.fetchNewsId()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showNewsIdList(it)
                }, {
                    println("Error: " + it.message)
                })
        )
    }

    fun showNewsIdList(newsIdList: List<Int>) {
        for (i in newsIdList){
            println("ID: "+i)
            fetchNewsDetails(i)
        }
    }

    fun fetchNewsDetails(id: Int) {

        compositeDisposable.add(
            restApiDataSource.fetchNewsSotriesDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showNewsDetails(it)
                    newsDetailsLiveData.value = it
                })
        )
    }



    fun showNewsDetails(newsStoryDetails: NewsStoryDetails) {
        println(newsStoryDetails.by)
        println(newsStoryDetails.descendants)
        println(newsStoryDetails.id)
        println(newsStoryDetails.score)
        println(newsStoryDetails.title)
    }
}