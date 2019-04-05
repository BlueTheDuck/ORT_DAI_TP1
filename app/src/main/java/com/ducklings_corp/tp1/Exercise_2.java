package com.ducklings_corp.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_2);
    }

    public void processAsText(View view) {
        // Var decl.
        String givenText;
        EditText inputController;
        TextView ex3_AsCount;
        CheckBox ex3_limitInput;
        int textLength, AsCount;

        // Get input controller, its text (lower cased) and save the length of said text to textLength
        inputController = findViewById(R.id.ex2_textInput);
        givenText = inputController.getText().toString().toLowerCase();
        textLength = givenText.length();

        // Get output controller
        ex3_AsCount = findViewById(R.id.ex2_AsCount);

        // Get checkbox that prevents inputs smaller than 10
        ex3_limitInput = findViewById(R.id.ex2_limitInput);

        // If the checkbox is checked and textLength is smaller than 10 we set an error, clear the output and then exit
        if(ex3_limitInput.isChecked() && textLength < 10) {
            inputController.setError("El largo del texto tiene que ser mayor a 10 si \"limitado\" está tildado");
            ex3_AsCount.setText("");
            return;
        }

        // Initialize AsCount then iterate through the text..
        AsCount = 0;
        for(int i=0;i<textLength;i++) {
            // ...When an 'a' is found add 1 to AsCount
            if(givenText.charAt(i)=='a') {
                AsCount++;
            }
        }

        // Cast AsCount to a string then show it in the controller
        ex3_AsCount.setText(""+AsCount);
    }
}
