package com.example.authenticationsystem.phoneNumberAuthentication.resetPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.authenticationsystem.DashBoard
import com.example.authenticationsystem.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class ResetPassPhone : AppCompatActivity() {
    private lateinit var etOtp:EditText
    private lateinit var btnReset : Button
    private lateinit var mAuth : FirebaseAuth

    private lateinit var code:String
    private lateinit var verificationId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass_phone)

        verificationId = intent.getStringExtra("verificationId")!!


        init()

        btnReset.setOnClickListener {
            code = etOtp.text.toString().trim()

            val phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId,code)
            signInWithPhoneAuthCredential(phoneAuthCredential)
        }
    }

    private fun init() {
        etOtp = findViewById(R.id.etOtp)
        btnReset = findViewById(R.id.btnReset)
        mAuth = FirebaseAuth.getInstance()
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Register", "signInWithCredential:success")

                        goToDashBoard()

                    val user = task.result?.user
                    Log.d("UserPhone: ", "signInWithPhoneAuthCredential: "+user?.phoneNumber)
                    Log.d("UserPhone: ", "signInWithPhoneAuthCredential: "+user?.email)

                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("Register", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    private fun goToDashBoard(){
        val intent = Intent(this,DashBoard::class.java)
        startActivity(intent)
    }
}