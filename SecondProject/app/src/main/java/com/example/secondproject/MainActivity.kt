package com.example.secondproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.secondproject.viewModel.MainActivityViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel by lazy { ViewModelProviders.of(this).get(MainActivityViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel.fetchNewsStoryId()
        mainActivityViewModel.newsDetailsLiveData.observe(this){
            if(it.type == "story")
            {
                Log.d("MAIN: ", "onCreate: BY: "+it.by)
                Log.d("MAIN: ", "onCreate: TITLE: "+it.title)
            }
            else
            {
                Log.d("MAIN", "onCreate: "+"not found")
            }
            //Log.d("MAIN ACTIVITY: ", "onCreate: SCORE: "+it.score)

            //Log.d("MAIN ACTIVITY: ", "onCreate: TYPE: "+it.type)
        }

    }

}