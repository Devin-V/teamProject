package com.devin.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class dayView extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_view);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.DATE_MESSAGE);

        TextView textView = findViewById(R.id.textView3);
        textView.setText(message);
    }

}
