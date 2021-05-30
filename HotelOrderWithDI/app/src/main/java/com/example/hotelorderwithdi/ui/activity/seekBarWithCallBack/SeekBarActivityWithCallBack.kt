package com.example.hotelorderwithdi.ui.activity.seekBarWithCallBack

import android.os.Bundle
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.viewModel.seekBarWithCallBack.SeekBarActivityWithCallBackViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SeekBarActivityWithCallBack : DaggerAppCompatActivity(), SeekBarListener {

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar

    private lateinit var seekBarActivityWithCallBackViewModel: SeekBarActivityWithCallBackViewModel

//    @Inject
//    lateinit var seekbaractivitywithlivedataviewmodelFactory: SeekBarActivityWithCallBackViewModelFactory

    @Inject
    lateinit var viewModelFactory:ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_with_call_back)

        seekBar1 = findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)
        seekBarActivityWithCallBackViewModel =
            ViewModelProvider(this, viewModelFactory).get(
                SeekBarActivityWithCallBackViewModel::class.java
            )

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarActivityWithCallBackViewModel.fetchSeekBarData(
                    progress,
                    this@SeekBarActivityWithCallBack
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }

    override fun listener(value: Int) {
        seekBar2.setProgress(value)
    }
}