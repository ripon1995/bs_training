package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SeekBarTestActivityWithRXjavaViewModel : ViewModel() {

    private var compositeDisposable = CompositeDisposable()

    val seekbarLiveData: MutableLiveData<Int> = MutableLiveData()

    fun fetchSeekbarValue(progress: Int) {
        compositeDisposable.add(
            Observable.just(progress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    seekbarLiveData.value = it
                })
        )
    }
}