package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.typeCode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceTypeCode.RestTypeCodeImplementation
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class TypeCodeViewModel @Inject constructor(private val restTypeCodeImplementation: RestTypeCodeImplementation) :
    ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var postListLiveData: MutableLiveData<Posts> = MutableLiveData<Posts>()

    fun fetchPostDetails() {

        compositeDisposable.add(
            restTypeCodeImplementation.fetchPostDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    postListLiveData.value = it
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}