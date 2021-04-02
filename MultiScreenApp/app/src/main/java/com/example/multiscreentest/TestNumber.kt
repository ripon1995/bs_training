package com.example.multiscreentest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TestNumber : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_number)

//        val words=ArrayList<Word?>()
//        words.add(Word("One","1"))
//        words.add(Word("Two", "2"))
//        words.add(Word("Three", "3"))
//        words.add(Word("Four", "4"))
//        words.add(Word("Five", "5"))
//        words.add(Word("Six", "6"))
//        words.add(Word("Seven", "7"))
//        words.add(Word("Eight", "8"))
//        words.add(Word("Nine", "9"))
//        words.add(Word("Ten", "10"))

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun prepareItems() {
        itemsList.add("Item 1")
        itemsList.add("Item 2")
        itemsList.add("Item 3")
        itemsList.add("Item 4")
        itemsList.add("Item 5")
        itemsList.add("Item 6")
        itemsList.add("Item 7")
        itemsList.add("Item 8")
        itemsList.add("Item 9")
        itemsList.add("Item 10")
        itemsList.add("Item 11")
        itemsList.add("Item 12")
        itemsList.add("Item 13")
        customAdapter.notifyDataSetChanged()
    }
}