package com.example.hotelorderwithdi.ui.activity.seekBarWithRxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.viewModel.seekBarWithRxJava.SeekBarTestActivityWithRXjavaViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SeekBarTestActivityWithRXJava : DaggerAppCompatActivity() {

    lateinit var seekBar1: SeekBar
    lateinit var seekBar2: SeekBar

    @Inject
     lateinit var seekBarTestActivityWithRXjavaViewModel: SeekBarTestActivityWithRXjavaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_test_with_r_x_java)


        seekBar1 = findViewById(R.id.seekbarFirst)
        seekBar2 = findViewById(R.id.seekbarSecond)


        seekBarTestActivityWithRXjavaViewModel = ViewModelProvider(this).get(
            SeekBarTestActivityWithRXjavaViewModel::class.java)

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarTestActivityWithRXjavaViewModel.fetchSeekbarValue(progress)
                seekBarTestActivityWithRXjavaViewModel.seekbarLiveData.observe(this@SeekBarTestActivityWithRXJava){
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