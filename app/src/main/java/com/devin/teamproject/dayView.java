package com.devin.teamproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import static com.devin.teamproject.MainActivity.DATE_MESSAGE;

public class dayView extends AppCompatActivity{
    public String date = "";
    public String message = "";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    public String month = "";
    public String day = "";
    public String year = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_view);

        // Gets date from previous screen
        Intent intent = getIntent();
        message = intent.getStringExtra(DATE_MESSAGE);

        // Adds date to top of page
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        // Removes the "Date:" from date string
        String oldDate = intent.getStringExtra(DATE_MESSAGE);
        String blankDate = oldDate.replaceAll("Date:", "");

        // Separates the date into individual numbers day = [1] month = [0] year = [2]
        String[] dateStuff = blankDate.split("/");
        month = dateStuff[0];
        day = dateStuff[1];
        year = dateStuff[2];

        // Calls the database for the given date
        databaseStuff(month, day, year);

        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void databaseStuff(String month, String day, String year){
        // Sets the path for the database reference
        DatabaseReference myRef = database.getReference().child(month).child(day).child(year);

        // Checks Database for Schedules in given date
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Gets objects from database in a map
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                Log.i("CONTENTS", String.valueOf(map));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Error", "failed to read value");
            }
        });

        // fill schedules to table here
    }


    public void createRes(View view){
        Intent intent = new Intent(this, CreateRes.class);
        intent.putExtra(DATE_MESSAGE, message);
        startActivity(intent);
    }
}
