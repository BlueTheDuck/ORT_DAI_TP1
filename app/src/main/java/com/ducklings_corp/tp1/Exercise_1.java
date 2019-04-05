package com.ducklings_corp.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Exercise_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_1);

        // Get the bar
        SeekBar ex1_charsToJoin;
        ex1_charsToJoin = findViewById(R.id.ex1_charsToJoinBar);

        // Set the default amount of chars we will work on (3)
        ex1_charsToJoin.setProgress(3);

        // Add listener to update the TextView charsToJoinText
        ex1_charsToJoin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView charsToJoinText;

                charsToJoinText = findViewById(R.id.ex1_charsToJoinText);

                charsToJoinText.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void processTexts(View view) {
        // Var decl.
        TextView textDif1, textDif2, joinedStringsOut;
        EditText textInput1, textInput2;
        SeekBar charsToJoinBar;
        int textLength1, textLength2, lengthsDiff, minCharsToJoin;
        String baseFormat, formatted, joinedStrings;
        String text1, text2;
        char sign1, sign2;

        // Get controllers to work on
        textDif1 = findViewById(R.id.ex1_textDif1);
        textDif2 = findViewById(R.id.ex1_textDif2);
        joinedStringsOut = findViewById(R.id.ex1_joinedStringsOut);

        textInput1 = findViewById(R.id.ex1_input1);
        textInput2 = findViewById(R.id.ex1_input2);

        charsToJoinBar = findViewById(R.id.ex1_charsToJoinBar);

        /// Section dedicated to 1.A and 1.B

        // We need the strings, their lengths and their difference
        text1 = textInput1.getText().toString();
        text2 = textInput2.getText().toString();
        textLength1 = text1.length();
        textLength2 = text2.length();
        lengthsDiff = Math.abs(textLength1-textLength2);

        // Get the smallest amount of chars we want to work on
        minCharsToJoin = charsToJoinBar.getProgress();

        // Show error message in case any of the inputs is less than 3 characters
        if(textLength1<minCharsToJoin) {
            textInput1.setError("Ingrese un texto con mas de "+minCharsToJoin+" caracteres");
        }
        if(textLength2<minCharsToJoin) {
            textInput2.setError("Ingrese un texto con mas de "+minCharsToJoin+" caracteres");
        }
        // Exit if an invalid text was given, cleaning the output in the process
        if(textLength1<minCharsToJoin || textLength2<minCharsToJoin) {
            textDif1.setText("");
            textDif2.setText("");
            joinedStringsOut.setText("");
            return;
        }


        // We define the formatting for the differences of length
        // This would be, for ex.: 10 (+ 4). Length of 10, 4 more than the other text
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
        // Set joinedStrings as "", then append the first 3 chars of each input UNLESS the string is smaller than 3 characters
        joinedStrings = "";
        joinedStrings += textInput1.getText().subSequence(0,minCharsToJoin);
        joinedStrings += textInput2.getText().subSequence(0,minCharsToJoin);

        joinedStringsOut.setText(joinedStrings);
    }
}
