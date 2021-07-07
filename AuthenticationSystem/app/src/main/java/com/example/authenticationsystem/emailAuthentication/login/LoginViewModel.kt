package com.example.authenticationsystem.emailAuthentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel : ViewModel() {

    private var mAuth = FirebaseAuth.getInstance()
    var exceptionLiveData: MutableLiveData<String?> = MutableLiveData()

    fun loginUser(mail: String, pass: String) {
        signInWithMail(mail, pass)
    }

    private fun signInWithMail(mail: String, pass: String) {
        mAuth.signInWithEmailAndPassword(mail, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    exceptionLiveData.postValue("Successful")
                } else {

                    if (it.exception.toString().contains("The password is invalid")) {
                        exceptionLiveData.postValue("Wrong pass")
                    } else {
                        exceptionLiveData.postValue("Invalid user")
                    }
                }
            }
    }
}