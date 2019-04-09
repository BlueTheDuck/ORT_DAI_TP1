package com.ducklings_corp.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_2);

        EditText inputChar;

        inputChar = findViewById(R.id.ex2_charInput);
        inputChar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                /*
                 * This input sets the character we have to count
                 * */

                // Var decl
                TextView countLabel, charsCount;

                countLabel = findViewById(R.id.ex2_countLalbel);
                charsCount = findViewById(R.id.ex2_charsCount);

                // When someone changes the char to count, remove the previous counter and show the new char
                // If no character was written, the the program defaults to A (shows a hint, not a text)
                if(s.length()==0) {
                    countLabel.setText("");
                } else {
                    countLabel.setText(s.toString()+"'s: ");
                }
                charsCount.setText("");
            }
        });
    }

    public void processAsText(View view) {
        // Var decl.
        String givenText;
        EditText inputText, inputChar;
        TextView charsCount;
        CheckBox limitInput;
        int textLength, charsCounted;
        char charToCount;

        // Get input controller, its text (lower cased) and save the length of said text to textLength
        inputText = findViewById(R.id.ex2_textInput);
        givenText = inputText.getText().toString().toLowerCase();
        textLength = givenText.length();
        inputChar = findViewById(R.id.ex2_charInput);

        // Get the char to count: If no char was provided, "a" will be the first char on the string
        charToCount = (inputChar.getText().toString().toLowerCase()+"a").charAt(0);

        // Get output controller
        charsCount = findViewById(R.id.ex2_charsCount);

        // Get checkbox that prevents inputs smaller than 10
        limitInput = findViewById(R.id.ex2_limitInput);

        // If the checkbox is checked and textLength is smaller than 10 we set an error, clear the output and then exit
        if(limitInput.isChecked() && textLength < 10) {
            inputText.setError("El largo del texto tiene que ser mayor a 10 si \"limitado\" está tildado");
            charsCount.setText("");
            return;
        }

        // Initialize AsCount then iterate through the text..
        charsCounted = 0;
        for(int i=0;i<textLength;i++) {
            // ...When an 'a' is found add 1 to AsCount
            if(givenText.charAt(i)==charToCount) {
                charsCounted++;
            }
        }

        // Cast AsCount to a string then show it in the controller
        charsCount.setText(""+charsCounted);
    }
}
