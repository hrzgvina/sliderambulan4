package com.example.sliderambulan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    //menjalankan button slider dimulai dengan onclick listener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefManag prefManager = new PrefManag(getApplicationContext());
                prefManager.setIsFirstTimeLaunch(true);
                startActivity(new Intent(MainActivity.this, WelActivity.class));
                finish();
            }
        });

    }
    //public void displayToast(String message) {
        //Toast.makeText(getApplicationContext(),message,
                //Toast.LENGTH_SHORT).show();
    //}

    //public void showSelectedRoute(String message) {

        //displayToast(message);
    //}


    //menjalankan image showJalur yang dialihkan ke aktivitas lain dengan menggunakan intent dimana aktivitas yaitu RouteActivity
    public void showJalur(View view) {
        Intent intent = new Intent(this, RuteActivity.class);
        startActivity(intent);
    }
}
