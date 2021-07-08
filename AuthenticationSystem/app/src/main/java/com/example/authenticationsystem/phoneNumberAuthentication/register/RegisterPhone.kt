package com.example.authenticationsystem.phoneNumberAuthentication.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authenticationsystem.R
import com.example.authenticationsystem.phoneNumberAuthentication.resetPassword.ResetPassPhone
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import java.util.concurrent.TimeUnit


class RegisterPhone : AppCompatActivity() {

    private lateinit var etPhone: EditText

    private lateinit var btnRegister: Button

    private lateinit var auth: FirebaseAuth

    private lateinit var code: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_phone)
        inIt()

        btnRegister.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {

        val phoneNumber = etPhone.text.toString().trim()

        sendVerificationCode(phoneNumber)

    }

    private fun inIt() {
        etPhone = findViewById(R.id.etPhone)
        btnRegister = findViewById(R.id.btnRegister)
        auth = FirebaseAuth.getInstance()
    }

    private fun sendVerificationCode(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+88$phoneNumber")
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private val callbacks: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {

                //code = phoneAuthCredential.smsCode

                //Log.d("CODE", "onVerificationCompleted: ")
                if (code != null) {
                    //verifyVerificationCode(code)
                }


            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                verificationId: String,
                forceResendingToken: ForceResendingToken
            ) {
                super.onCodeSent(verificationId, forceResendingToken)

                Log.d("Register", "onCodeSent:$verificationId")

                getVerificationCodeFromUser(verificationId)

            }
        }

    private fun getVerificationCodeFromUser(verification:String) {
        val intent = Intent(this, ResetPassPhone::class.java)
        intent.putExtra("verificationId",verification)
        startActivity(intent)

    }


}