package com.example.hotelorderwithdi.viewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.ui.SeekBarListener

class SeekBarActivityWithCallBack : AppCompatActivity(),SeekBarListener {

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar

    private lateinit var seekBarActivityWithCallBackViewModel: SeekBarActivityWithCallBackViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_with_call_back)

        seekBar1 = findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)
        seekBarActivityWithCallBackViewModel = ViewModelProvider(this).get(SeekBarActivityWithCallBackViewModel::class.java)

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarActivityWithCallBackViewModel.fetchSeekBarData(progress,this@SeekBarActivityWithCallBack)
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