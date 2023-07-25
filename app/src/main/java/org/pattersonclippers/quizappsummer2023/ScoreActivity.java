package org.pattersonclippers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);

        Intent incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", 0);

        scoreTV.setText("SCORE = " + score);


    }
}