package com.example.authenticationsystem.phoneNumberAuthentication.register

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.authenticationsystem.R

class RegisterPhone : AppCompatActivity() {
    private lateinit var etFullName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPass: EditText
    private lateinit var etRePass: EditText
    private lateinit var register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_phone)
        inIt()
    }

    private fun inIt() {
        etFullName = findViewById(R.id.etName)
        etPhone = findViewById(R.id.etPhone)
        etPass = findViewById(R.id.etPass)
        etRePass = findViewById(R.id.etRePass)
        register = findViewById(R.id.btnRegister)
    }
}