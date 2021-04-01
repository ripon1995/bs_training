package com.example.multiscreentest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.*

class WordAdapter(context: Context, words: ArrayList<Word?>?) : ArrayAdapter<Word?>(context, 0, words!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ilst_item, parent, false)
        }
        val textView = convertView!!.findViewById<TextView>(R.id.tvFirst)
        val textView1 = convertView.findViewById<TextView>(R.id.tvSecond)
        val word = getItem(position)
        textView.text = word!!.mWord
        textView1.text = word.nWord
        return convertView
    }
}