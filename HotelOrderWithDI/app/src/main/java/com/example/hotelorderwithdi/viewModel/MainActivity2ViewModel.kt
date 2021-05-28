package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.dataSource.model.SeekbarTest
import com.example.hotelorderwithdi.ui.SeekBarListener
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity2ViewModel() : ViewModel() {


    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun fetchSeekBarValue2(value:Int,listener:SeekBarListener){
        compositeDisposable.add(
           Observable.just(value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //seekBarLiveData2.value=it

                    listener.listener(it)
                })
        )
    }


}