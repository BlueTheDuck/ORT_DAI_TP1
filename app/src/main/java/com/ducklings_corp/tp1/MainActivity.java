package com.ducklings_corp.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processTexts(View view) {
        TextView textDif1, textDif2, output;
        EditText textInput1, textInput2;
        int textLength1, textLength2, lengthsDiff;
        String baseFormat,formatted;
        char sign1, sign2;

        textDif1 = findViewById(R.id.textDif1);
        textDif2 = findViewById(R.id.textDif2);
        output = findViewById(R.id.output);

        textInput1 = findViewById(R.id.input1);
        textInput2 = findViewById(R.id.input2);

        textLength1 = textInput1.getText().length();
        textLength2 = textInput2.getText().length();
        lengthsDiff = Math.abs(textLength1-textLength2);

        baseFormat = "%1$d (%2$c %3$d)";

        if(textLength1 > textLength2) {
            sign1 = '+';
            sign2 = '-';
        } else if(textLength1 < textLength2) {
            sign1 = '-';
            sign2 = '+';
        } else {
            sign1 = ' ';
            sign2 = ' ';
        }
        formatted = String.format(baseFormat,textLength1,sign1,lengthsDiff);
        textDif1.setText(formatted);
        formatted = String.format(baseFormat,textLength2,sign2,lengthsDiff);
        textDif2.setText(formatted);
    }
}
