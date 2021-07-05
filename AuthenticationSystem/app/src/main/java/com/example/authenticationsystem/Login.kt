package com.example.authenticationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {

    private lateinit var buttonRegister: Button
    private lateinit var buttonLogin:Button
    private lateinit var etMail:EditText
    private lateinit var etPass:EditText
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mailFormFireBase:String
    private lateinit var passFromFireBase:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonRegister = findViewById(R.id.btnGoForReg)
        buttonLogin = findViewById(R.id.btnLogin)
        etMail = findViewById(R.id.etMail)
        etPass = findViewById(R.id.etPass)
        mAuth = FirebaseAuth.getInstance()

        getMailAndPassFromFireBase()

        buttonLogin.setOnClickListener(View.OnClickListener {
            goForLogin()
        })


        buttonRegister.setOnClickListener(View.OnClickListener {
            goToRegistrationActivity()
        })
    }
    private fun goToRegistrationActivity(){
        val intent = Intent(this,Register::class.java)
        startActivity(intent)
    }
    private fun getMailAndPassFromFireBase(){
        val currentUser = mAuth.currentUser?.uid
        val instance= FirebaseDatabase.getInstance().getReference("Users").child(currentUser!!)
        instance.child("email").get().addOnSuccessListener {
            Log.d("Login", "goForLoginTest: "+it.value)
            mailFormFireBase = it.value.toString()
        }
        instance.child("pass").get().addOnSuccessListener {
            Log.d("Login", "goForLoginTest: "+it.value)
            passFromFireBase = it.value.toString()
        }
    }

    private fun goForLogin(){
        val mail = etMail.text.toString().trim()
        val pass = etPass.text.toString().trim()

//        var mailFromFireBase :String = "TEST"
//        var passFromFireBase :String = "TEST"

//        val currentUser = mAuth.currentUser?.uid

//        Log.d("Login", "goForLogin: "+currentUser.toString())
//        val instance= FirebaseDatabase.getInstance().getReference("Users").child(currentUser!!)

//        instance.child("email").get().addOnSuccessListener {
//            Log.d("Login", "goForLoginTest: "+it.value)
//            mailFromFireBase = it.value.toString()
//        }


        Log.d("Login", "goForLogin: "+mailFormFireBase)
        Log.d("Login", "goForLogin: "+passFromFireBase)

        if(mail == mailFormFireBase && pass == passFromFireBase){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        else if(mail!=mailFormFireBase ){
            etMail.error = "Valid mail required"
            etMail.requestFocus()
            return
        }
        else if(pass!=passFromFireBase){
            etPass.error = "Invalid password"
            etPass.requestFocus()
            return
        }
    }
}