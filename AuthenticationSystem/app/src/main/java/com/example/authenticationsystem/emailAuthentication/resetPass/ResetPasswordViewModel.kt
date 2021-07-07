package com.example.authenticationsystem.emailAuthentication.resetPass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordViewModel : ViewModel() {
    private var mAuth = FirebaseAuth.getInstance()
    var passwordReset: MutableLiveData<Boolean> = MutableLiveData()

    fun resetPassword(mail: String) {

        mAuth.sendPasswordResetEmail(mail)
            .addOnCompleteListener {
                passwordReset.value = it.isSuccessful
            }

    }


}