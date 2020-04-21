package com.example.firsttimeuser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String title = "Hello and welcome";
    private String message = "Your first time eh? Have fun!";
    private String pos = "Yes indeed!";
    private boolean firstTime;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String BOOLEAN = "myBoolean";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean(BOOLEAN, true);
        if (firstTime)
        {
            showAlertDialog();

            saveData();
           // loadData();


        }


    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(pos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
                .show();

    }

    private void saveData() {
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(BOOLEAN, false);
        editor.apply();



    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean(BOOLEAN, true);

    }

}
