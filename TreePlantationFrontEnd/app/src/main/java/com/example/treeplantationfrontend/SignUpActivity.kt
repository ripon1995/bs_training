package com.example.treeplantationfrontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.treeplantationfrontend.viewmodel.AuthViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var etUserName: TextInputLayout
    lateinit var etMail: TextInputLayout
    lateinit var etPassword: TextInputLayout
    lateinit var btnSignUp: MaterialButton
    lateinit var viewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()



        btnSignUp.setOnClickListener {
            val username: String = etUserName.editText!!.text.toString()
            val email: String = etMail.editText!!.text.toString()
            val password: String = etMail.editText!!.text.toString()
            viewModel.signUpCustomers(username, email, password)
        }


    }

    private fun init() {
        btnSignUp = findViewById(R.id.btnSignIn)
        etUserName = findViewById(R.id.etUserName)
        etMail = findViewById(R.id.etMail)
        etPassword = findViewById(R.id.etPassword)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    }
}
