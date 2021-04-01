package com.example.multiscreentest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.multiscreentest.R
import com.example.multiscreentest.Word
import com.example.multiscreentest.WordAdapter
import java.util.*

class NumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)
        val words = ArrayList<Word?>()
        words.add(Word("One", "1"))
        words.add(Word("Two", "2"))
        words.add(Word("Three", "3"))
        words.add(Word("Four", "4"))
        words.add(Word("Five", "5"))
        words.add(Word("Six", "6"))
        words.add(Word("Seven", "7"))
        words.add(Word("Eight", "8"))
        words.add(Word("Nine", "9"))
        words.add(Word("Ten", "10"))
        val adapter = WordAdapter(this, words)
        val listView = findViewById<View>(R.id.list) as ListView
        listView.adapter = adapter

        // listview, recyclerview, tab layout, spinner, popup menu, viewpager
    }
}