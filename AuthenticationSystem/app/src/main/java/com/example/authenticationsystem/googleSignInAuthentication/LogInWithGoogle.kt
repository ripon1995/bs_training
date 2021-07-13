package com.example.authenticationsystem.googleSignInAuthentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authenticationsystem.DashBoard
import com.example.authenticationsystem.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LogInWithGoogle : AppCompatActivity() {
    private lateinit var signInButton: SignInButton
    val RC_SIGN_IN = 101
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_with_google)


       inIt()

        signInButton.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {

        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account != null){
            goToDashBoard()
        }
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            Log.d("onStart", "Currently Signed in: " + currentUser.email);
            //showToastMessage("Currently Logged in: " + currentUser.getEmail());
            Toast.makeText(applicationContext, "Currently Logged in: "+currentUser.email, Toast.LENGTH_SHORT).show()
        }
    }

    private fun signInViaGoogleMail() {
        val googleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("133614558658-ueu9opuu114p3dtikkfbsnl37f7nc365.apps.googleusercontent.com")
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
    }

    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)

            account?.idToken?.let {
                firebaseAuthWithGoogle(it)
            }

        } catch (e: ApiException) {

            Log.w("TEST", "signInResult:failed code=" + e.statusCode)
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = mAuth.currentUser
                    goToDashBoard()

                } else {

                    Log.w("TEST", "signInWithCredential:failure", task.exception)
                }
            }
    }

    private fun goToDashBoard(){
        val intent = Intent(this,DashBoard::class.java)
        startActivity(intent)
    }

    private fun inIt(){
        mAuth = FirebaseAuth.getInstance()
        signInViaGoogleMail()
        signInButton = findViewById(R.id.btnSignInWithGoogle)
    }
}