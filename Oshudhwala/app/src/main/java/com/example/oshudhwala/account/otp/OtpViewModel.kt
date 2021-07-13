package com.example.oshudhwala.account.otp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.database.FirebaseDatabase

class OtpViewModel : ViewModel() {

    private var mAuth = FirebaseAuth.getInstance()
    val loginSuccessLiveData: MutableLiveData<String> = MutableLiveData()


    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    loginSuccessLiveData.postValue("Success")
                    val user = task.result?.user
                    FirebaseDatabase.getInstance().getReference("AuthenticatedWithPhone")
                        .child(FirebaseAuth.getInstance().currentUser?.uid!!)
                        .setValue(user?.phoneNumber)
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        loginSuccessLiveData.postValue("Invalid OTP")
                    }
                }
            }
    }
}