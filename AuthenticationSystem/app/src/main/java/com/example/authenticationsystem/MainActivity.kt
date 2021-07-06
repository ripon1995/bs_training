package com.example.authenticationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var signOutButton:Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signOutButton = findViewById(R.id.btnSignOut)
        mAuth = FirebaseAuth.getInstance()

        signOutButton.setOnClickListener {
            goForSignOut()
        }
    }

    private fun goForSignOut(){
        mAuth.signOut()
        goForLogInActivity()
    }

    private fun goForLogInActivity(){
        val intent = Intent(this,Login::class.java)
        startActivity(intent)
    }

}