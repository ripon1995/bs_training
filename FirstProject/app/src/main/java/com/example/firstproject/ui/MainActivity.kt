package com.example.firstproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstproject.R
import com.example.firstproject.fragmentCallbacks.FragmentCallback

import com.example.firstproject.ui.features.news.view.NewsFragment


class MainActivity : AppCompatActivity(), FragmentCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newsFragment = NewsFragment(this)
        changeFragment(newsFragment)
    }

    override fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}