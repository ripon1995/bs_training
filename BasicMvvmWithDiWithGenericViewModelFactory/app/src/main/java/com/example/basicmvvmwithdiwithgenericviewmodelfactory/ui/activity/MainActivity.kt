package com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnHotel : Button
    private lateinit var btnTypeCode:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHotel = findViewById(R.id.btnHotel)
        btnTypeCode = findViewById(R.id.btnTypeCode)

        btnHotel.setOnClickListener {
            showHotelData()
        }

        btnTypeCode.setOnClickListener {
            showTypeCodeData()
        }

    }

    fun showHotelData() {
        val intent = Intent(this,HotelDataActivity::class.java)
        startActivity(intent)
    }
    fun showTypeCodeData() {
        val intent = Intent(this,TypeCodeDataActivity::class.java)
        startActivity(intent)
    }
}