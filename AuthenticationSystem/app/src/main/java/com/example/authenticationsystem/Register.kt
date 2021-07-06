package com.example.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var etRePass: EditText
    private lateinit var register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        inIt()
        mAuth = FirebaseAuth.getInstance()

        register.setOnClickListener{
            goForEmailRegistration()
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            Toast.makeText(this, "Already signed in", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inIt() {
        etFullName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etMail)
        etPass = findViewById(R.id.etPass)
        etRePass = findViewById(R.id.etRePass)
        register = findViewById(R.id.btnRegister)
    }

    private fun goForEmailRegistration() {
        val email = etEmail.text.toString().trim()
        val fullName = etFullName.text.toString().trim()
        val pass = etPass.text.toString().trim()
        val rePass = etRePass.text.toString().trim()

        if (fullName.isEmpty()) {
            etFullName.error = "Full name is required"
            etFullName.requestFocus()
            return
        }
        if (email.isEmpty()) {
            etEmail.error = "Email is required"
            etEmail.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Enter a valid mail"
            etEmail.requestFocus()
            return
        }

        if (pass.isEmpty()) {
            etPass.error = "enter pass"
            etPass.requestFocus()
            return
        }
        if (rePass != pass) {
            etRePass.error = "Password did not match"
            etPass.requestFocus()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) {

                if (it.isSuccessful) {
                    val user = User(fullName, email)
                    FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().currentUser?.uid!!)
                        .setValue(user)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                                goToLogInActivity()
                            } else {
                                Toast.makeText(this, "Not successful", Toast.LENGTH_LONG).show()
                            }
                        }

                } else {
                    println(it.exception.toString())
                    if (it.exception.toString().contains("The email address is already in use")) {
                        etEmail.error = "Already in use"
                        etEmail.requestFocus()
                    }
                }
            }

    }

    private fun goToLogInActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}