package com.example.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        firstFragment.arguments = intent.extras
        setFragment(firstFragment)
    }

    fun setFragment(firstFragment: FirstFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.first, firstFragment)
        transaction.commit()
    }
}