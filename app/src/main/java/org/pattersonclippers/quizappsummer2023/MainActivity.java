package org.pattersonclippers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String NEW_VARIABLE;
    TextView questionTV, greetingTV;
    Button falseBTN, trueBTN, nextBTN;
    int score;
    Question q1, q2, q3, q4, q5, currentQ;
    Question[] questions;
    int currentIndex;
    String message, name;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "org.pattersonclippers.quizappsummer2023";
    private final String NAME_KEY = "NAME";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = (TextView) findViewById(R.id.questionTV);
        greetingTV = (TextView) findViewById(R.id.greetingTV);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        score = 0;
        currentIndex = 0;
        q1 = new Question(getString(R.string.q1text), false);
        q2 = new Question(getString(R.string.q2text), true);
        q3 = new Question("Pi is a transcendental number", true);
        q4 = new Question("Pi is a perfect number", false);
        q5 = new Question("Pi(e) is delicious", true);
        currentQ = q1;
        questions = new Question[] {q1, q2, q3, q4, q5};
        message = "";

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        name = mPreferences.getString(NAME_KEY, "");
        greetingTV.setText("Hello, " + name + "!");


        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAnswer() == false)
                {
                    message = "You are correct! Good job!";
                    score++;
                }
                else
                {
                    message = "You are wrong. Try again.";
                }


                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAnswer() == true)
                {
                    message = getString(R.string.rightMsg);
                    score++;
                }
                else
                {
                    message = getString(R.string.wrongMsg);
                }
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                if (currentIndex < 5)
                {
                    currentQ = questions[currentIndex];
                    questionTV.setText(currentQ.getqPrompt());
                }
                else
                {
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    scoreIntent.putExtra("score", score);
                    startActivity(scoreIntent);
                }

            }
        });
    }
}