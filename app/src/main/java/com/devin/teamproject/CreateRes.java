package com.devin.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.devin.teamproject.MainActivity.DATE_MESSAGE;

public class CreateRes extends AppCompatActivity{

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_time);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //gets date from previous screen
        Intent intent = getIntent();
        String message = intent.getStringExtra(DATE_MESSAGE);

        // Displays date at top of screen
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        // Dropdown menu for court number
        Spinner court = findViewById(R.id.spinner);
        String[] courts = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> adapterCourt = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, courts);
        court.setAdapter(adapterCourt);

        // Dropdown menu for start time
        Spinner timeStart = findViewById(R.id.spinner2);
        String[] startTimes = new String[]{"7am", "8am", "9am", "10am","11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm"};
        ArrayAdapter<String> adapterStartTime = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, startTimes);
        timeStart.setAdapter(adapterStartTime);

        // Dropdown menu for end time
        Spinner timeEnd = findViewById(R.id.spinner3);
        String[] endTimes = new String[]{"8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "10pm"};
        ArrayAdapter<String> adapterEndTime = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, endTimes);
        timeEnd.setAdapter(adapterEndTime);
    }

    public void makeRes(View view){
        // Removes the "Date:" from date string
        Intent intent = getIntent();
        String oldDate = intent.getStringExtra(DATE_MESSAGE);
        String middleDate = oldDate.replaceAll("Date:", "").trim();
        String blankDate = middleDate.replaceAll("/", "").trim();

        //Converts court# to an int
        Spinner court = findViewById(R.id.spinner);
        String courtNumber = court.getItemAtPosition(court.getSelectedItemPosition()).toString();
        int courtNum = Integer.parseInt(courtNumber);

        //Gets the name user input
        EditText userName = findViewById(R.id.editText2);
        String name = userName.getText().toString();

        //Converts startHour to an int
        Spinner timeStart = findViewById(R.id.spinner2);
        String timeStartString = timeStart.getItemAtPosition(timeStart.getSelectedItemPosition()).toString();
        switch (timeStartString){
            case "1pm":
                timeStartString = "13pm";
                break;
            case "2pm":
                timeStartString = "14pm";
                break;
            case "3pm":
                timeStartString = "15pm";
                break;
            case "4pm":
                timeStartString = "16pm";
                break;
            case "5pm":
                timeStartString = "17pm";
                break;
            case "6pm":
                timeStartString = "18pm";
                break;
            case "7pm":
                timeStartString = "19pm";
                break;
            case "8pm":
                timeStartString = "20pm";
                break;
            case "9pm":
                timeStartString = "21pm";
                break;
            case "10pm":
                timeStartString = "22pm";
                break;
        }
        String fixedString = timeStartString.replaceAll("am|pm", "");
        int startHour = Integer.parseInt(fixedString);

        //Converts endHour to an int
        Spinner timeEnd = findViewById(R.id.spinner3);
        String timeEndString = timeEnd.getItemAtPosition(timeEnd.getSelectedItemPosition()).toString();
        switch (timeEndString){
            case "1pm":
                timeEndString = "13pm";
                break;
            case "2pm":
                timeEndString = "14pm";
                break;
            case "3pm":
                timeEndString = "15pm";
                break;
            case "4pm":
                timeEndString = "16pm";
                break;
            case "5pm":
                timeEndString = "17pm";
                break;
            case "6pm":
                timeEndString = "18pm";
                break;
            case "7pm":
                timeEndString = "19pm";
                break;
            case "8pm":
                timeEndString = "20pm";
                break;
            case "9pm":
                timeEndString = "21pm";
                break;
            case "10pm":
                timeEndString = "22pm";
                break;
        }
        String correctString = timeEndString.replaceAll("am|pm", "");
        int endHour = Integer.parseInt(correctString);

        // Creates the Schedule Object
        Schedule entry = new Schedule(courtNum, name, startHour, endHour);

        // Adds the object to the database
        String id = mDatabase.push().getKey();
        mDatabase.child("schedule").child(blankDate).child(id).setValue(entry);

        // Jumps back to dayView
        Intent intent1 = new Intent(this, dayView.class);
        intent1.putExtra(DATE_MESSAGE, oldDate);
        startActivity(intent1);
    }
}