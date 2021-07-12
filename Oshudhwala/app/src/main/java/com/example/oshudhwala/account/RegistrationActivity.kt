package com.example.oshudhwala.account

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.oshudhwala.databinding.ActivityRegistrationBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegistrationActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inIt()


        binding.btnSave.setOnClickListener(View.OnClickListener {

        })

        binding.signInButton.setOnClickListener(View.OnClickListener {
            signIn()
        })
    }

    private fun inIt(){
        signInViaGoogleMail()

        auth = Firebase.auth
    }

    private fun signInViaGoogleMail(){
        val googleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("922588703563-relh734qm3c47155edmdmt5pnil5k2bi.apps.googleusercontent.com")
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
    }

    private fun signIn() {

        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            firebaseAuthWithGoogle(account?.idToken!!)

            Log.d("Account", "handleSignInResult: "+account?.email)
            Log.d("Account", "handleSignInResult: "+account?.photoUrl)
            Log.d("Account", "handleSignInResult: "+account?.displayName)
            // Signed in successfully, show authenticated UI.
            //updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("DEBUG::::::::::::::", "signInResult:failed code=" + e.statusCode)
            //updateUI(null)
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Authentication", "signInWithCredential:success")
                    val user = auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                Log.d("EMAIL", "firebaseAuthWithGoogle: "+it.result)
                            }
                        }

                    if(user.isEmailVerified){
                        Log.d("EMAIL", "firebaseAuthWithGoogle: "+user.isEmailVerified)
                    }

                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Authentication", "signInWithCredential:failure", task.exception)
                    //updateUI(null)
                }
            }
    }

}