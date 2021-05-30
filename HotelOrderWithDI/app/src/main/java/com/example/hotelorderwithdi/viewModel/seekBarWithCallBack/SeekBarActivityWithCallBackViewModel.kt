package com.example.hotelorderwithdi.viewModel.seekBarWithCallBack

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.ui.activity.seekBarWithCallBack.SeekBarListener
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SeekBarActivityWithCallBackViewModel @Inject constructor() : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun fetchSeekBarData(progress: Int, seekBarListener: SeekBarListener) {
        compositeDisposable.add(
            Observable.just(progress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    seekBarListener.listener(it)
                })
        )
    }
}