package com.ducklings_corp.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Exercise_3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_3);
    }
    public void invertText(View view) {
        // Var decl.
        EditText inputText;
        TextView outputText, palindrome;
        String givenText;
        String invertedString;

        // Get controllers
        inputText = findViewById(R.id.ex3_textInput);
        outputText = findViewById(R.id.ex3_invertedText);
        palindrome = findViewById(R.id.ex3_palindrome);

        // Save text
        givenText = inputText.getText().toString();

        // Prevent texts that are less than 10 chars long
        if(givenText.length()<10) {
            inputText.setError("El texto tiene que tener mas the 10 caracteres");
            return;
        }

        // Initialize invertedString, the iterate through givenText from to end to the beginning...
        invertedString = "";
        for(int i=givenText.length()-1;i>=0;i--) {
            // ...appending the current character to invertedString
            invertedString += givenText.charAt(i);
        }

        if(invertedString.compareTo(givenText)==0) {
            palindrome.setText("Capicua!");
        } else {
            palindrome.setText("");
        }

        // Set output as invertedString
        outputText.setText(invertedString);
    }
}
