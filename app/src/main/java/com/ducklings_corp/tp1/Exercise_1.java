package com.ducklings_corp.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_1);
    }

    public void processTexts(View view) {
        /// Variable declarations
        TextView textDif1, textDif2, joinedStringsOut;
        EditText textInput1, textInput2;
        int textLength1, textLength2, lengthsDiff;
        String baseFormat, formatted, joinedStrings;
        char sign1, sign2;

        // Get elements to work on
        textDif1 = findViewById(R.id.textDif1);
        textDif2 = findViewById(R.id.textDif2);
        joinedStringsOut = findViewById(R.id.joinedStringsOut);

        textInput1 = findViewById(R.id.input1);
        textInput2 = findViewById(R.id.input2);

        /// Section dedicated to 1.A and 1.B

        // We need the length of the texts and their difference
        textLength1 = textInput1.getText().length();
        textLength2 = textInput2.getText().length();
        lengthsDiff = Math.abs(textLength1-textLength2);

        // Show error message in case any of the inputs is empty
        if(textLength1==0) {
            textInput1.setError("Ingrese un texto");
        }
        if(textLength2==0) {
            textInput1.setError("Ingrese un texto");
        }


        // We define the formatting for the differences of length
        // This would be, for ex.: 10 (+ 4). Length of 10. 4 more than the other text
        baseFormat = "%1$d (%2$c %3$d)";

        /// We need to define the signs used for the difference of length
        // If the 1st text is bigger, then it has to use a +[DIFF]
        if(textLength1 > textLength2) {
            sign1 = '+';
            sign2 = '-';
        } else if(textLength1 < textLength2) {
            sign1 = '-';
            sign2 = '+';
        } else {
            // If both are equal then don't use signs
            sign1 = ' ';
            sign2 = ' ';
        }
        // Format and set texts
        formatted = String.format(baseFormat,textLength1,sign1,lengthsDiff);
        textDif1.setText(formatted);
        formatted = String.format(baseFormat,textLength2,sign2,lengthsDiff);
        textDif2.setText(formatted);

        /// Section dedicated to 1.C
        // Set joinedStrings as "", then append the first 3 chars of each input
        joinedStrings = "";
        joinedStrings += textInput1.getText().subSequence(0,3);
        joinedStrings += textInput2.getText().subSequence(0,3);

        joinedStringsOut.setText(joinedStrings);
    }
}
