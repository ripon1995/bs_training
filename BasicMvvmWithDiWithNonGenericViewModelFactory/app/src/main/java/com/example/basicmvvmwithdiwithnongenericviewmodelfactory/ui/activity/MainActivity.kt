package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showHotelData(view: View) {
        val intent = Intent(this,HotelDataActivity::class.java)
        startActivity(intent)
    }
    fun showTypeCodeData(view: View) {
        val intent = Intent(this,TypeCodeDataActivity::class.java)
        startActivity(intent)
    }
}