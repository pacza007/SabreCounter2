package com.example.android.sabrecounter;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.transformPivotY;

public class MainActivity extends AppCompatActivity {


    int scorePlayerA = 0;
    int scorePlayerB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        if (savedInstanceState != null) {
            scorePlayerA = savedInstanceState.getInt("MyScorePlayerA");
            scorePlayerB = savedInstanceState.getInt("MyScorePlayerB");
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the data
        outState.putInt("MyScorePlayerA", scorePlayerA);
        outState.putInt("MyScorePlayerB", scorePlayerB);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // restore the data
        scorePlayerA = savedInstanceState.getInt("MyScorePlayerA");
        scorePlayerB = savedInstanceState.getInt("MyScorePlayerB");
        UpdateScreen();
    }
    private void UpdateScreen() {
        // update the screen after rotating the phone
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
    private void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.PlayerAScore);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.PlayerBScore);
        scoreView.setText(String.valueOf(score));
    }
    public void addTOneForPlayerA(View v) {
        scorePlayerA++;
        displayForPlayerA(scorePlayerA);
        if (scorePlayerA >= 15)
            displayGameOver("Player A Wins!");

    }
    public void addTOneForPlayerB(View v) {
        scorePlayerB++;
        displayForPlayerB(scorePlayerB);
        if (scorePlayerB >= 15)
            displayGameOver("Player B Wins!");
    }
    public void resetScore(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayGameOver("");
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
    private void displayGameOver(String text) {
        TextView t = (TextView) findViewById(R.id.GameOver);
        t.setText(text);
    }
}
