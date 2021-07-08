package com.example.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.authenticationsystem.emailAuthentication.login.Login
import com.google.firebase.auth.FirebaseAuth

class DashBoard : AppCompatActivity() {
    private lateinit var signOutButton: Button
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        inIt()
        signOutButton.setOnClickListener {
            goForSignOut()
        }
    }

    private fun inIt() {
        signOutButton = findViewById(R.id.btnSignOut)
        mAuth = FirebaseAuth.getInstance()
    }

    private fun goForSignOut() {
        mAuth.signOut()
        goForMainActivity()
    }

    private fun goForMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}