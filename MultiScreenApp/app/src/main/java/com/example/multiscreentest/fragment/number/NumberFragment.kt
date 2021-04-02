package com.example.multiscreentest.fragment.number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multiscreentest.R
import com.example.multiscreentest.adapter.CustomAdapterSecond
import com.example.multiscreentest.model.Word

class NumberFragment : Fragment() {
    private lateinit var customAdapter: CustomAdapterSecond
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater?.inflate(R.layout.activity_numbers, container, false)
        prepareAdapter(prepareItems(),view)
        return view
    }
    private fun prepareAdapter(items: List<Word>, view:View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        customAdapter = CustomAdapterSecond(items)
        val layoutManager = LinearLayoutManager(context)
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