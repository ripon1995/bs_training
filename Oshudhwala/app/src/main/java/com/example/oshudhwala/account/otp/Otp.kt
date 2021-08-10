package com.example.oshudhwala.account.otp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.oshudhwala.dashboard.DashBoard
import com.example.oshudhwala.base.BaseActivity
import com.example.oshudhwala.databinding.ActivityOtpBinding
import com.google.firebase.auth.PhoneAuthProvider

class Otp : BaseActivity() {
    private lateinit var binding : ActivityOtpBinding
    private lateinit var viewModel: OtpViewModel
    private lateinit var verificationId: String
    private lateinit var code: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(OtpViewModel::class.java)

        val phoneNumber = intent.getStringExtra("phoneNumber")
        verificationId = intent.getStringExtra("verificationId")!!


        binding.tvPhoneNumber.text = phoneNumber?.let {
            fancyPhoneNumber(it)
        }

        viewModel.loginSuccessLiveData.observe(this, Observer {
            when (it) {
                "Success" -> {
                    goToDashBoard()
                }
                "Invalid OTP" -> {
                    binding.etOtp.showError()
                    binding.etOtp.requestFocus()
                }
            }
        })

        binding.btnVerify.setOnClickListener{

            code = binding.etOtp.otp!!
            if (code.isEmpty()) {
                binding.etOtp.showError()
                binding.etOtp.requestFocus()
            }

            Log.d("OTP", "onCreate: $code")
            println("OTP: $code")
            val phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, code)
            viewModel.signInWithPhoneAuthCredential(phoneAuthCredential)
        }

    }

    private fun fancyPhoneNumber(phoneNumber:String):String{

        val fancyNumber = "+"+phoneNumber.dropLast(8)+"*****"+phoneNumber.drop(8)
        return fancyNumber
    }

    private fun goToDashBoard(){
        val intent = Intent(this, DashBoard::class.java)
        startActivity(intent)
    }
}