package com.example.android.sabrecounter;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePlayerA = 0;
    int scorePlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.hide();
        }
    }


    public void displayForPlayerA(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.PlayerAScore);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerB(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.PlayerBScore);
        scoreView.setText(String.valueOf(score));
    }

    public void addTOneForPlayerA(View v)
    {
        scorePlayerA++;
        displayForPlayerA(scorePlayerA);
        if (scorePlayerA >= 15)
            displayGameOver("Player A Wins!");

    }

    public void addTOneForPlayerB(View v)
    {
        scorePlayerB++;
        displayForPlayerB(scorePlayerB);
        if (scorePlayerB >= 15)
            displayGameOver("Player B Wins!");
    }

    public void resetScore(View v)
    {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayGameOver("");
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }


    public void displayGameOver(String text)
    {
        TextView t = (TextView) findViewById(R.id.GameOver);
        t.setText(text);
    }

}
