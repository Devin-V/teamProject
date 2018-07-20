package com.devin.teamproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import java.util.ArrayList;


import static com.devin.teamproject.MainActivity.DATE_MESSAGE;

public class dayView extends AppCompatActivity{
    public String date = "";
    public String message = "";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef =  database.getReference();
    public String month = "";
    public String day = "";
    public String year = "";
    public String firebaseString = "";
    ArrayList<Schedule> array  = new ArrayList<>();

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
        firebaseString = blankDate.replace("/","").trim();

        Log.i("Passed String", String.valueOf(firebaseString));
        // Separates the date into individual numbers day = [1] month = [0] year = [2]
        String[] dateStuff = blankDate.split("/");
        month = dateStuff[0];
        day = dateStuff[1];
        year = dateStuff[2];

        // Calls the database for the given date
        //databaseStuff(month, day, year);

        myRef.child("schedule").child(firebaseString).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Schedule sched = new Schedule();
            Log.i("SCHEDULE", String.valueOf(ds.getValue()));
            sched.setName(ds.getValue(Schedule.class).getName()); //set the name
            sched.setCourtNum(ds.getValue(Schedule.class).getCourtNum()); //set the court num
            sched.setStartHour(ds.getValue(Schedule.class).getStartHour()); //set the start hour
            sched.setEndHour(ds.getValue(Schedule.class).getEndHour()); //set the end hour

            //display all the information
            Log.d("Sched", "showData: name: " + sched.getName());
            Log.d("Sched", "showData: courtNum: " + sched.getCourtNum());
            Log.d("Sched", "showData: startHour: " + sched.getStartHour());
            Log.d("Sched", "showData: endHour: " + sched.getEndHour());

            String textbox;
            int resourceID;
            TextView textView;
            int[] middleTimes = new int[16];
            int counter = 0;

            for (int i = sched.getStartHour(); i <= sched.getEndHour(); i++){
                middleTimes[counter] = i;
                counter++;
            }

            switch(sched.getCourtNum()){
                case 1:
                    for(int i = 0; i < (sched.getEndHour() - sched.getStartHour() + 1); i++){
                        textbox = "c1_" + middleTimes[i];
                        resourceID = getResources().getIdentifier(textbox, "id", getPackageName());
                        textView = findViewById(resourceID);
                        textView.setText(sched.getName());
                    }
                    break;
                case 2:
                    for(int i = 0; i < (sched.getEndHour() - sched.getStartHour() + 1); i++){
                        textbox = "c2_" + middleTimes[i];
                        resourceID = getResources().getIdentifier(textbox, "id", getPackageName());
                        textView = findViewById(resourceID);
                        textView.setText(sched.getName());
                    }
                    break;
                case 3:
                    for(int i = 0; i < (sched.getEndHour() - sched.getStartHour() + 1); i++){
                        textbox = "c3_" + middleTimes[i];
                        resourceID = getResources().getIdentifier(textbox, "id", getPackageName());
                        textView = findViewById(resourceID);
                        textView.setText(sched.getName());
                    }
                    break;
                case 4:
                    for(int i = 0; i < (sched.getEndHour() - sched.getStartHour() + 1); i++){
                        textbox = "c4_" + middleTimes[i];
                        resourceID = getResources().getIdentifier(textbox, "id", getPackageName());
                        textView = findViewById(resourceID);
                        textView.setText(sched.getName());
                    }
                    break;
                case 5:
                    for(int i = 0; i < (sched.getEndHour() - sched.getStartHour() + 1); i++){
                        textbox = "c5_" + middleTimes[i];
                        resourceID = getResources().getIdentifier(textbox, "id", getPackageName());
                        textView = findViewById(resourceID);
                        textView.setText(sched.getName());
                    }
                    break;
                case 6:
                    for(int i = 0; i < (sched.getEndHour() - sched.getStartHour() + 1); i++){
                        textbox = "c6_" + middleTimes[i];
                        resourceID = getResources().getIdentifier(textbox, "id", getPackageName());
                        textView = findViewById(resourceID);
                        textView.setText(sched.getName());
                    }
                    break;
            }
            array.add(sched);
        }
    }

    public void createRes(View view){
        Intent intent = new Intent(this, CreateRes.class);
        intent.putExtra(DATE_MESSAGE, message);
        startActivity(intent);
    }
}