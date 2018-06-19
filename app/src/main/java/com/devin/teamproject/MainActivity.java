package com.devin.teamproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int PASSWORD = 1234;
    public static final String DATE_MESSAGE = "com.devin.teamproject.DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
    }

    public void checkPin(View view) {
        EditText loginAttempt = findViewById(R.id.editText);
        String convert = loginAttempt.getText().toString();
        int value = Integer.parseInt(convert);

        if (value == PASSWORD){
            Intent intent = new Intent(this, calenView.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Pin (try 1234", Toast.LENGTH_SHORT).show();
        }
    }
}
