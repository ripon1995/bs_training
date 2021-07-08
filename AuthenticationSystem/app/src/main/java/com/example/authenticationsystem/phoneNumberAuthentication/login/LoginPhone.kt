package com.example.authenticationsystem.phoneNumberAuthentication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.example.authenticationsystem.R
import com.example.authenticationsystem.phoneNumberAuthentication.register.RegisterPhone
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LoginPhone : AppCompatActivity() {
    private lateinit var etPhone: EditText
    private lateinit var etPass:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnRegistration : Button
    private lateinit var btnResetPass : Button
    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_phone)
        inIt()

        btnRegistration.setOnClickListener {
            goForRegistration()
        }
    }

    private fun inIt(){
        etPhone = findViewById(R.id.etPhone)
        etPass = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegistration = findViewById(R.id.btnRegister)
        btnResetPass = findViewById(R.id.btnReset)
        auth = FirebaseAuth.getInstance()
    }



    private fun goForRegistration(){
        val intent = Intent(this,RegisterPhone::class.java)
        startActivity(intent)
    }
}