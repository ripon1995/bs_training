package com.example.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.authenticationsystem.emailAuthentication.login.Login
import com.example.authenticationsystem.phoneNumberAuthentication.login.RegisterPhone

class MainActivity : AppCompatActivity() {

    private lateinit var btnEmailAuthentication: Button
    private lateinit var btnPhoneAuthentication: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inIt()

        btnEmailAuthentication.setOnClickListener {
            goToLoginActivity()
        }

        btnPhoneAuthentication.setOnClickListener {
            goToLoginPhoneActivity()
        }
    }


    private fun inIt() {
        btnEmailAuthentication = findViewById(R.id.btnEmailAuthentication)
        btnPhoneAuthentication = findViewById(R.id.btnPhoneAuthentication)

    }

    private fun goToLoginActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    private fun goToLoginPhoneActivity() {
        val intent = Intent(this, RegisterPhone::class.java)
        startActivity(intent)
    }
}