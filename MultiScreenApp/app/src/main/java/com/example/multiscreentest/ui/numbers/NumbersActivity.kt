package com.example.multiscreentest.ui.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multiscreentest.R

class NumbersActivity : AppCompatActivity() {

    private lateinit var customAdapter: CustomAdapterSecond

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)

        prepareAdapter(prepareItems())
    }

    private fun prepareAdapter(items: List<Word>) {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        customAdapter = CustomAdapterSecond(items)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
    }

    private fun prepareItems(): List<Word> {
        val words = mutableListOf<Word>()
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

        return words
    }

}