package com.example.multiscreentest.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.multiscreentest.R
import com.example.multiscreentest.fragment.color.ColorFragment
import com.example.multiscreentest.fragment.family.FamilyFragment
import com.example.multiscreentest.fragment.number.NumberFragment
import com.example.multiscreentest.fragment.phrase.PhraseFragment
import com.example.multiscreentest.adapter.CustomAdapterSecond

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNumberList(view: View?) {

        val numberFragment = NumberFragment()
        numberFragment.arguments = intent.extras
        setFragment(numberFragment)
    }

    fun openFamilyMembers(view: View?) {
        val familyFragment = FamilyFragment()
        familyFragment.arguments = intent.extras
        setFragment(familyFragment)
    }

    fun openColor(view: View?) {
        val colorFragment = ColorFragment()
        colorFragment.arguments = intent.extras
        setFragment(colorFragment)
    }

    fun openPhrases(view: View?) {
        val phraseFragment = PhraseFragment()
        phraseFragment.arguments = intent.extras
        setFragment(phraseFragment)
    }

    fun setFragment(firstFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, firstFragment)
        transaction.commit()
    }


}