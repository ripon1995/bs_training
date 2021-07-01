package com.example.oshudhwala.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun shortToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}