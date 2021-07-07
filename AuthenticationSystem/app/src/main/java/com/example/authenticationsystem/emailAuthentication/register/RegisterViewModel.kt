package com.example.authenticationsystem.emailAuthentication.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authenticationsystem.dataSource.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterViewModel : ViewModel() {
    private var mAuth = FirebaseAuth.getInstance()
    val registerSuccessLiveData: MutableLiveData<String> = MutableLiveData()

    fun registerUser(mail: String, pass: String, fullName: String) {

        mAuth.createUserWithEmailAndPassword(mail, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    registerSuccessLiveData.postValue("Successful")
                    val user = User(fullName, mail)
                    FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().currentUser?.uid!!)
                        .setValue(user)
                } else {
                    if (it.exception.toString().contains("The email address is already in use")) {
                        registerSuccessLiveData.postValue("Already in use")
                    }
                }
            }
    }
}