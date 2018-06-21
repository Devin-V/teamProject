package com.devin.teamproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int PASSWORD = 1234;
    public static final String DATE_MESSAGE = "com.devin.teamproject.DATE";

    private EditText mPin;
    private CheckBox mCheckbox;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        mPin = (EditText) findViewById(R.id.editText);
        mCheckbox = (CheckBox) findViewById(R.id.checkbox);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();


    }

    public void checkPin(View view) {

        String convert = mPin.getText().toString();
        int value = Integer.parseInt(convert);

        if (value == PASSWORD){
            if (mCheckbox.isChecked()) {
                mEditor.putString(getString(R.string.checkbox), "True");
                mEditor.commit();

                mEditor.putString(getString(R.string.pin), convert);
                mEditor.commit();

                Intent intent = new Intent(this, calenView.class);
                startActivity(intent);
            } else {
                mEditor.putString(getString(R.string.checkbox), "False");
                mEditor.commit();

                mEditor.putString(getString(R.string.pin), "");
                mEditor.commit();

                Intent intent = new Intent(this, calenView.class);
                startActivity(intent);
            }

        } else {
            Toast.makeText(getApplicationContext(), "Wrong Pin (try 1234)", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkSharedPreferences() {
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String pin = mPreferences.getString(getString(R.string.pin), "");

        mPin.setText(pin);

        if(checkbox.equals("True")) {
            mCheckbox.setChecked(true);
        } else {
            mCheckbox.setChecked(false);
        }

    }
}
