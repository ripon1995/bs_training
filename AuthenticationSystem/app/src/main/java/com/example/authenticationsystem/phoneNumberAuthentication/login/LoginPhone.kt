package com.example.authenticationsystem.phoneNumberAuthentication.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.example.authenticationsystem.R

class LoginPhone : AppCompatActivity() {
    private lateinit var etPhone: EditText
    private lateinit var etPass:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnRegistration : Button
    private lateinit var btnResetPass : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_phone)
    }

    private fun inIt(){
        etPhone = findViewById(R.id.etPhone)
        etPass = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegistration = findViewById(R.id.btnRegister)
        btnResetPass = findViewById(R.id.btnReset)

    }
}