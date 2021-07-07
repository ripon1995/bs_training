package com.example.authenticationsystem.phoneNumberAuthentication.resetPassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.authenticationsystem.R

class ResetPassPhone : AppCompatActivity() {
    private lateinit var etPhone:EditText
    private lateinit var btnReset : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass_phone)

        init()
    }

    private fun init() {
        etPhone = findViewById(R.id.etPhone)
        btnReset = findViewById(R.id.btnReset)
    }
}