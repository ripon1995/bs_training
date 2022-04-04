package com.example.treeplantationfrontend

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        viewModel.signUpConfirmation.observe(this, {
            if (it.message == "fail") {
                showToastMessage("This email is already in use")
            } else if (it.message == "success") {
                showToastMessage("Congratulation")
                val username: String = etUserName.editText!!.text.toString()
                val email: String = etMail.editText!!.text.toString()
                val password: String = etPassword.editText!!.text.toString()
                viewModel.authenticateCustomer(username, email, password)
                goToLoginPage()
            }
        })


        btnSignUp.setOnClickListener {
            val username: String = etUserName.editText!!.text.toString()
            val email: String = etMail.editText!!.text.toString()
            val password: String = etPassword.editText!!.text.toString()
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

    private fun showToastMessage(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    private fun goToLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
