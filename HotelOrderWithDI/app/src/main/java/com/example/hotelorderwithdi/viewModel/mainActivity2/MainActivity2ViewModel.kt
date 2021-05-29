package com.example.hotelorderwithdi.viewModel.mainActivity2

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.dataSource.model.MainActivity2DataSource
import com.example.hotelorderwithdi.ui.activity.mainActivity2.MainActivity2Listener
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity2ViewModel @Inject constructor(private val dataSource: MainActivity2DataSource) :
    ViewModel() {


    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun fetchSeekBarValue2(value: Int, listener: MainActivity2Listener) {
        compositeDisposable.add(
            Observable.just(value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //seekBarLiveData2.value=it

                    listener.progress(it)
                    listener.stringValue(dataSource.testString)
                })
        )
    }


}