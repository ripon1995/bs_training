package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarActivityWithLiveDataViewModel : ViewModel() {

     var seekBarLiveData:MutableLiveData<Int> = MutableLiveData()

    fun fetchSeekBarValue(progress:Int){
        seekBarLiveData.value=progress
    }
}