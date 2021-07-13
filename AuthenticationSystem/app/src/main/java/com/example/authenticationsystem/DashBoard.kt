package com.example.authenticationsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class DashBoard : AppCompatActivity() {
    private lateinit var signOutButton: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient:GoogleSignInClient
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
        googleSignInClient = GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN);
    }

    private fun goForSignOut() {
        mAuth.signOut()
        //goForMainActivity()

        googleSignInClient.signOut().addOnCompleteListener(this) {
            goForMainActivity()
        }
    }

    private fun goForMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}