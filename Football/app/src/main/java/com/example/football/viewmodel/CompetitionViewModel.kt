package com.example.football.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.football.datasource.model.competition.CompetitionList
import com.example.football.datasource.remoteDataSource.RestDataSource
import com.example.football.datasource.remoteDataSource.RestDataSourceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CompetitionViewModel : ViewModel() {
    private val restApiDataSource: RestDataSource = RestDataSourceImpl()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    var competitionLiveData: MutableLiveData<CompetitionList> = MutableLiveData<CompetitionList>()


    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun fetchCompetitions() {
        compositeDisposable.add(
            restApiDataSource.getCompetitions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    competitionLiveData.value = it
                }
        )
    }
}