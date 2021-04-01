package com.example.multiscreentest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("One","1"));
        words.add(new Word("Two","2"));
        words.add(new Word("Three","3"));
        words.add(new Word("Four","4"));
        words.add(new Word("Five","5"));
        words.add(new Word("Six","6"));
        words.add(new Word("Seven","7"));
        words.add(new Word("Eight","8"));
        words.add(new Word("Nine","9"));
        words.add(new Word("Ten","10"));
        WordAdapter adapter=new WordAdapter(this,words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}