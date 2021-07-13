package com.example.oshudhwala.account.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.oshudhwala.account.otp.Otp
import com.example.oshudhwala.base.BaseActivity
import com.example.oshudhwala.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inIt()

        binding.btnLogin.setOnClickListener{
            logInUser()
            //getVerificationCodeFromUser("test","01791015207")
        }
    }

    private fun logInUser() {
        phoneNumber = binding.etMobileNumber.text.toString().trim()
        if (binding.etMobileNumber.text.toString().trim().length != 11) {
            binding.etMobileNumber.error = "Enter a valid number"
            binding.etMobileNumber.requestFocus()
        }
        sendVerificationCode(phoneNumber)
    }

    private fun sendVerificationCode(phoneNumber: String) {

        val options = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber("+88$phoneNumber")
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private val callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {

                val code = phoneAuthCredential.smsCode

                Log.d("CODE", "onVerificationCompleted: ")
                if (code != null) {
                    //verifyVerificationCode(code)
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                verificationId: String,
                forceResendingToken: PhoneAuthProvider.ForceResendingToken
            ) {
                super.onCodeSent(verificationId, forceResendingToken)

                Log.d("Register", "onCodeSent:$verificationId")

                getVerificationCodeFromUser(verificationId,phoneNumber)

            }
        }

    private fun getVerificationCodeFromUser(verification: String,phoneNumber: String) {
        val intent = Intent(this, Otp::class.java)
        intent.putExtra("verificationId", verification)
        intent.putExtra("phoneNumber", phoneNumber)
        startActivity(intent)
    }

    private fun inIt() {
        mAuth = FirebaseAuth.getInstance()
    }
}