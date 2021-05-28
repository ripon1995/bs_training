package com.example.hotelorderwithdi.ui.activity

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.ui.SeekBarListener
import com.example.hotelorderwithdi.viewModel.MainActivity2ViewModel
import com.example.hotelorderwithdi.viewModel.MainActivity2ViewModelFactory

class MainActivity2 : AppCompatActivity(),SeekBarListener {

    lateinit var mainActivity2ViewModel: MainActivity2ViewModel
    lateinit var mainActivity2ViewModelFactory: MainActivity2ViewModelFactory

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        seekBar1 = findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)



        mainActivity2ViewModelFactory = MainActivity2ViewModelFactory()
        mainActivity2ViewModel = ViewModelProvider(
            this,
            mainActivity2ViewModelFactory
        ).get(MainActivity2ViewModel::class.java)

//        secondActivityViewModel.seekBarLiveData.observe(this@MainActivity2) {
//            seekBar2.setProgress(it)
//        }
//
//        secondActivityViewModel.seekBarLiveData2.observe(this){
//            seekBar2.setProgress(it)
//        }

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //secondActivityViewModel.fetchSeekbarValue(progress)
                mainActivity2ViewModel.fetchSeekBarValue2(progress,this@MainActivity2)
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