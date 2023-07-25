package org.pattersonclippers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionTV;
    Button falseBTN, trueBTN, scoreBTN;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        scoreBTN = (Button) findViewById(R.id.scoreBTN);
        score = 0;

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "You are correct! Good job!";
                score++;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "You are wrong! Try again!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });
        scoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                scoreIntent.putExtra("score", score);
                startActivity(scoreIntent);
            }
        });
    }
}