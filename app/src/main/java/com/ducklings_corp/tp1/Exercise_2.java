package com.ducklings_corp.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Exercise_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_2);
    }

    public void processAsText(View view) {
        String givenText;
        EditText inputController;

        inputController = findViewById(R.id.ex3_textInput);
        givenText = inputController.getText().toString();


    }
}
