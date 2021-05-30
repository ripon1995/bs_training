package com.example.hotelorderwithdi.ui.activity.seekBarWithLiveData

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.viewModel.seekBarWithLiveData.SeekBarActivityWithLiveDataViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SeekBarActivityWithLiveData : DaggerAppCompatActivity() {

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar

    lateinit var textView1:TextView
    lateinit var textView2:TextView


    lateinit var seekBarActivityWithLiveDataViewModel: SeekBarActivityWithLiveDataViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_with_live_data)

        seekBar1= findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)
        textView1 = findViewById(R.id.tvFirstProgress)
        textView2 = findViewById(R.id.tvSecondProgress)


        seekBarActivityWithLiveDataViewModel = ViewModelProvider(this,viewModelFactory).get(
            SeekBarActivityWithLiveDataViewModel::class.java)

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarActivityWithLiveDataViewModel.fetchSeekBarValue(progress)
                textView1.text = progress.toString()

                seekBarActivityWithLiveDataViewModel.seekBarLiveData.observe(this@SeekBarActivityWithLiveData){
                    seekBar2.setProgress(it)

                    textView2.text=it.toString()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
}