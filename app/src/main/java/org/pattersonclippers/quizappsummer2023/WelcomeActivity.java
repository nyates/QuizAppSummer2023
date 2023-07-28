package org.pattersonclippers.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "org.pattersonclippers.quizappsummer2023";
    private final String NAME_KEY = "NAME";
    EditText nameET;
    Button startQuizBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        nameET = (EditText) findViewById(R.id.nameET);
        startQuizBTN = (Button) findViewById(R.id.quizStartBTN);

        startQuizBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Created SharedPreferences editor object
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                //Write the id of the selected button to our SharedPreferences file
                preferencesEditor.putString(NAME_KEY, nameET.getText().toString());
                //Commit the value and save the file.
                preferencesEditor.apply();
                Intent startQuizIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(startQuizIntent);
            }
        });

    }
}