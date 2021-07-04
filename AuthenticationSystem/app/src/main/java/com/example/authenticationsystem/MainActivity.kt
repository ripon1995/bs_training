package com.example.authenticationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var buttonRegister:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegister = findViewById(R.id.btnGoForReg)
        buttonRegister.setOnClickListener(View.OnClickListener {
            goToRegistrationActivity()
        })
    }

    private fun goToRegistrationActivity(){
        val intent = Intent(this,Register::class.java)
        startActivity(intent)
    }
}