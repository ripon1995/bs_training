package com.example.multiscreentest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.multiscreentest.ui.colors.ColorsActivity
import com.example.multiscreentest.ui.family.FamilyMembersActivity
import com.example.multiscreentest.ui.numbers.NumbersActivity
import com.example.multiscreentest.ui.phrase.PhrasesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNumberList(view: View?) {
        val intent = Intent(this, NumbersActivity::class.java)
        startActivity(intent)
    }

    fun openFamilyMembers(view: View?) {
        val intent = Intent(this, FamilyMembersActivity::class.java)
        startActivity(intent)
    }

    fun openColor(view: View?) {
        val intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }

    fun openPhrases(view: View?) {
        val intent = Intent(this, PhrasesActivity::class.java)
        startActivity(intent)
    }
}