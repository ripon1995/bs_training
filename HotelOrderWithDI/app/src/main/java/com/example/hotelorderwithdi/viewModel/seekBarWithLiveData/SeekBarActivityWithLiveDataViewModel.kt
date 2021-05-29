package com.example.hotelorderwithdi.viewModel.seekBarWithLiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SeekBarActivityWithLiveDataViewModel @Inject constructor() : ViewModel() {

     var seekBarLiveData:MutableLiveData<Int> = MutableLiveData()

    fun fetchSeekBarValue(progress:Int){
        seekBarLiveData.value=progress
    }
}