package com.example.authenticationsystem

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : AppCompatActivity() {

    private lateinit var etMail: EditText
    private lateinit var etPass: EditText
    private lateinit var etRePass: EditText
    private lateinit var btnResetPass: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        inIt()
        btnResetPass.setOnClickListener {
            goForPasswordReset()
        }
    }

    private fun goForPasswordReset() {
        val mail = etMail.text.toString().trim()
        mAuth.sendPasswordResetEmail(mail)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Email sent successful", Toast.LENGTH_SHORT).show()
                } else {
                    Log.w("ResetPass", "goForPasswordReset: ", it.exception)
                }
            }
    }

    private fun inIt() {
        etMail = findViewById(R.id.etMail)
        etPass = findViewById(R.id.etPass)
        etRePass = findViewById(R.id.etRePass)
        btnResetPass = findViewById(R.id.btnReset)
        mAuth = FirebaseAuth.getInstance()
    }
}