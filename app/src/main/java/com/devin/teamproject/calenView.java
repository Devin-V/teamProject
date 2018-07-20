package com.devin.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import static com.devin.teamproject.MainActivity.DATE_MESSAGE;

public class calenView extends AppCompatActivity{
    public String date ="";
    boolean checking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = ("Date: " + (month + 1) + "/" + dayOfMonth + "/" + year);
                checking = true;
                Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void viewDay(View view) {
        if(checking == true){
            nextPage();
        } else {
            Toast.makeText(getApplicationContext(), "Please select a date", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void nextPage(){
        Intent intent = new Intent(this, dayView.class);
        intent.putExtra(DATE_MESSAGE, date);
        startActivity(intent);
    }

}
