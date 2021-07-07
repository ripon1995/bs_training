package com.example.authenticationsystem.emailAuthentication.resetPass

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationsystem.R
import com.example.authenticationsystem.emailAuthentication.login.Login
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : AppCompatActivity() {

    private lateinit var etMail: EditText
    private lateinit var btnResetPass: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var viewModel: ResetPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        inIt()
        btnResetPass.setOnClickListener {
            goForPasswordReset()
        }

        viewModel.passwordReset.observe(this, {
            if (it == true) {
                goToLoginActivity()
                Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
            } else {
                etMail.error = "Wrong mail"
                etMail.requestFocus()
            }
        })
    }

    private fun goForPasswordReset() {
        val mail = etMail.text.toString().trim()
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            etMail.error = "Enter valid mail"
            etMail.requestFocus()
            return
        }
        viewModel.resetPassword(mail)
    }

    private fun inIt() {
        etMail = findViewById(R.id.etMail)
        btnResetPass = findViewById(R.id.btnReset)
        mAuth = FirebaseAuth.getInstance()
        viewModel = ViewModelProvider(this).get(ResetPasswordViewModel::class.java)
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}