package com.example.secondproject

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.secondproject.viewModel.MainActivityViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel =
            ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        mainActivityViewModel.fetchNewsStoryId()
        mainActivityViewModel.newsDetailsLiveData.observe(this) {
            if (it.type == "story") {
                Log.d("MAIN: ", "onCreate: BY: " + it.by)
                Log.d("MAIN: ", "onCreate: TITLE: " + it.title)
            } else {
                Log.d("MAIN", "onCreate: " + "not found")
            }
        }

    }

}