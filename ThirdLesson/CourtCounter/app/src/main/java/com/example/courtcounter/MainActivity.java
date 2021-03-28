package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void displayForTeamA(int score)
    {
        TextView scoreView=findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    void displayForTeamB(int score)
    {
        TextView scoreView=findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addPoint3(View view) {
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }

    public void addPoint2(View view) {
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }

    public void addPoint1(View view) {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }

    public void add3(View view) {
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }

    public void add2(View view) {
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }

    public void add1(View view) {
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }

    public void reset(View view) {
        scoreTeamB=0;
        scoreTeamA=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}