package com.example.oshudhwala.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.oshudhwala.R
import com.example.oshudhwala.base.BaseActivity
import com.example.oshudhwala.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        })
    }
}