package com.example.multiscreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumberList(View view) {

        Intent intent = new Intent(this, NumbersActivity.class);
        startActivity(intent);
    }

    public void openFamilyMembers(View view) {
        Intent intent = new Intent(this, FamilyMembersActivity.class);
        startActivity(intent);
    }

    public void openColor(View view) {
        Intent intent = new Intent(this, ColorsActivity.class);
        startActivity(intent);
    }

    public void openPhrases(View view) {
        Intent intent = new Intent(this, PhrasesActivity.class);
        startActivity(intent);
    }
}