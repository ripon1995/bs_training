package com.example.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.authenticationsystem.emailAuthentication.login.Login

class MainActivity : AppCompatActivity() {

    private lateinit var btnEmailAuthentication: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inIt()

        btnEmailAuthentication.setOnClickListener {
            goToLoginActivity()
        }
    }


    private fun inIt() {
        btnEmailAuthentication = findViewById(R.id.btnEmailAuthentication)

    }

    private fun goToLoginActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }


}