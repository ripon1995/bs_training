package com.example.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var buttonRegister: Button
    private lateinit var buttonLogin: Button
    private lateinit var buttonForgotPassword: Button
    private lateinit var etMail: EditText
    private lateinit var etPass: EditText
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inIt()

        buttonLogin.setOnClickListener{
            goForLogin()
        }

        buttonRegister.setOnClickListener{
            goToRegistrationActivity()
        }

        buttonForgotPassword.setOnClickListener {
            goForResetPassword()
        }
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

        mAuth.signInWithEmailAndPassword(mail, pass)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    goToMainActivity()
                } else {
                    Log.w("Login", "signInWithEmail:failure", it.exception)
                    if (it.exception.toString().contains("The password is invalid")) {
                        etPass.error = "Wrong passord"
                        etPass.requestFocus()
                    }
                    if (it.exception.toString()
                            .contains("There is no user record corresponding to this identifier")
                    ) {
                        etMail.error = "Wrong mail"
                        etMail.requestFocus()
                    }
                }
            }

    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
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
        mAuth = FirebaseAuth.getInstance()
    }
}