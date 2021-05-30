package com.example.hotelorderwithdi.ui.activity.mainActivity2

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R

import com.example.hotelorderwithdi.viewModel.mainActivity2.MainActivity2ViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity2 : DaggerAppCompatActivity(), MainActivity2Listener {

    lateinit var mainActivity2ViewModel: MainActivity2ViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar
    lateinit var textView: TextView
    lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        seekBar1 = findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)
        textView = findViewById(R.id.tvFirstProgress)
        textView2 = findViewById(R.id.tvSecondProgress)
        mainActivity2ViewModel =
            ViewModelProvider(this, viewModelFactory).get(MainActivity2ViewModel::class.java)

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
                mainActivity2ViewModel.fetchSeekBarValue2(progress, this@MainActivity2)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    override fun progress(value: Int) {
        seekBar2.setProgress(value)
        textView2.text = value.toString()
    }

    override fun stringValue(value: String) {
        textView.setText(value)
    }
}