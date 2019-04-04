package com.ducklings_corp.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAct(View view) {
        int id;
        Intent destination;

        destination = null;

        id  = view.getId();
        switch(id) {
            case R.id.goAct1:
                destination = new Intent(MainActivity.this,Exercise_1.class);
                break;
            case R.id.goAct2:
                destination = new Intent(MainActivity.this,Exercise_2.class);
                break;
            default:
                return;
        }
        startActivity(destination);
    }
}
