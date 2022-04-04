package com.example.treeplantationfrontend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.treeplantationfrontend.datasource.model.requestBody.UserRequestBody
import com.example.treeplantationfrontend.viewmodel.AuthViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class LoginActivity : AppCompatActivity() {
    lateinit var btnSignUp: MaterialTextView
    lateinit var btnSignIn: MaterialButton

    lateinit var etUserName: TextInputLayout
    lateinit var etPassword: TextInputLayout

    lateinit var viewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        inIt()
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnSignIn.setOnClickListener {
            val userName = etUserName.editText!!.text.toString()
            val pass = etPassword.editText!!.text.toString()
            val requestBody = UserRequestBody(userName, pass)
            viewModel.fetchAccessToken(requestBody)
        }
    }

    private fun inIt() {
        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        btnSignIn = findViewById(R.id.btnSignIn)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    }
}