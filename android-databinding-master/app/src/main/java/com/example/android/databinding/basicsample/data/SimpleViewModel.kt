
package com.example.android.databinding.basicsample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {

    private val nameLiveData=MutableLiveData("John")
    private val lastNameLiveData=MutableLiveData("Doe")
    private var likesLiveData=MutableLiveData(0)

    val name :LiveData<String> =nameLiveData
    val lastName : LiveData<String> = lastNameLiveData
    var likes:LiveData<Int> = likesLiveData

    val popularity : LiveData<Popularity> = Transformations.map(likesLiveData){
        when{
            it>9 -> Popularity.STAR
            it>4 ->Popularity.POPULAR
            else  -> Popularity.NORMAL
        }
    }

    fun onLike(){
        likesLiveData.value=likesLiveData.value!!+1
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}
