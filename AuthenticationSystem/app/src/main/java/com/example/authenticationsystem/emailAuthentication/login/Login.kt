package com.example.authenticationsystem.emailAuthentication.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationsystem.DashBoard
import com.example.authenticationsystem.R
import com.example.authenticationsystem.emailAuthentication.register.Register
import com.example.authenticationsystem.emailAuthentication.resetPass.ResetPassword

class Login : AppCompatActivity() {

    private lateinit var buttonRegister: Button
    private lateinit var buttonLogin: Button
    private lateinit var buttonForgotPassword: Button
    private lateinit var etMail: EditText
    private lateinit var etPass: EditText
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inIt()

        buttonLogin.setOnClickListener {
            Log.d("Login", "onCreate: methodCalling")
            goForLogin()
        }

        buttonRegister.setOnClickListener {
            goToRegistrationActivity()
        }

        buttonForgotPassword.setOnClickListener {
            goForResetPassword()
        }


        viewModel.exceptionLiveData.observe(this, {
            when (it) {
                "Successful" -> {
                    goToDashBoard()
                }
                "Wrong pass" -> {
                    etPass.error = "Wrong password"
                    etPass.requestFocus()
                }
                "Invalid user" -> {
                    etMail.error = "Wrong mail"
                    etMail.requestFocus()
                }
            }
        })
    }

    private fun goForLogin() {
        val mail = etMail.text.toString().trim()
        val pass = etPass.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            etMail.error = "Please enter a valid mail"
            etMail.requestFocus()
            return
        }
        if (pass.isEmpty()) {
            etPass.error = "Please enter your password"
            etPass.requestFocus()
            return
        }

        Log.d("Login", "goForLogin: callingViewModel:::::Start")
        viewModel.loginUser(mail, pass)
        Log.d("Login", "goForLogin: CallingViewModel:::::End")
    }


    private fun goToDashBoard() {
        val intent = Intent(this, DashBoard::class.java)
        startActivity(intent)
    }

    private fun goToRegistrationActivity() {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    private fun goForResetPassword() {
        val intent = Intent(this, ResetPassword::class.java)
        startActivity(intent)
    }

    private fun inIt() {
        buttonRegister = findViewById(R.id.btnGoForReg)
        buttonLogin = findViewById(R.id.btnLogin)
        buttonForgotPassword = findViewById(R.id.btnForgotPass)
        etMail = findViewById(R.id.etMail)
        etPass = findViewById(R.id.etPass)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }
}