package com.devin.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.devin.teamproject.MainActivity.DATE_MESSAGE;

public class dayView extends AppCompatActivity{
    public String date = "";
    public String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_view);

        Intent intent = getIntent();
        message = intent.getStringExtra(DATE_MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }

    public void createRes(View view){
        Intent intent = new Intent(this, CreateRes.class);
        intent.putExtra(DATE_MESSAGE, message);
        startActivity(intent);
    }
}