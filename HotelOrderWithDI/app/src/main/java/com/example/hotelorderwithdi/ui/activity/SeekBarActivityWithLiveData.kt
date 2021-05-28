package com.example.hotelorderwithdi.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.viewModel.SeekBarActivityWithLiveDataViewModel

class SeekBarActivityWithLiveData : AppCompatActivity() {

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar


    lateinit var seekBarActivityWithLiveDataViewModel: SeekBarActivityWithLiveDataViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_with_live_data)

        seekBar1= findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)
        seekBarActivityWithLiveDataViewModel = ViewModelProvider(this).get(SeekBarActivityWithLiveDataViewModel::class.java)

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarActivityWithLiveDataViewModel.fetchSeekBarValue(progress)

                seekBarActivityWithLiveDataViewModel.seekBarLiveData.observe(this@SeekBarActivityWithLiveData){
                    seekBar2.setProgress(it)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
}