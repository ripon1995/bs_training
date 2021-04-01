package com.example.multiscreentest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.ilst_item,parent,false);
        }
        TextView textView=convertView.findViewById(R.id.tvFirst);
        TextView textView1=convertView.findViewById(R.id.tvSecond);
        Word word= (Word) getItem(position);
        textView.setText(word.getmWord());
        textView1.setText(word.getnWord());
        return convertView;

    }
}
