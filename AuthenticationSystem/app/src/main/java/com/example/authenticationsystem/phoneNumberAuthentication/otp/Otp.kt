package com.example.authenticationsystem.phoneNumberAuthentication.otp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationsystem.DashBoard
import com.example.authenticationsystem.R
import com.google.firebase.auth.PhoneAuthProvider

class Otp : AppCompatActivity() {
    private lateinit var etOtp: EditText
    private lateinit var btnLogin: Button
    private lateinit var otpViewModel: OtpViewModel
    private lateinit var code: String
    private lateinit var verificationId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass_phone)

        verificationId = intent.getStringExtra("verificationId")!!

        init()

        otpViewModel.loginSuccessLiveData.observe(this, {
            when (it) {
                "Success" -> {
                    goToDashBoard()
                }
                "Invalid OTP" -> {
                    etOtp.error = "Invalid otp"
                    etOtp.requestFocus()
                }
            }
        })

        btnLogin.setOnClickListener {
            code = etOtp.text.toString().trim()
            if (code.isEmpty()) {
                etOtp.error = "Enter the OTP"
                etOtp.requestFocus()
            }
            val phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, code)
            otpViewModel.signInWithPhoneAuthCredential(phoneAuthCredential)
        }
    }

    private fun init() {
        etOtp = findViewById(R.id.etOtp)
        btnLogin = findViewById(R.id.btnLogin)
        otpViewModel = ViewModelProvider(this).get(OtpViewModel::class.java)
    }


    private fun goToDashBoard() {
        val intent = Intent(this, DashBoard::class.java)
        startActivity(intent)
    }
}