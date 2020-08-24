package com.example.sliderambulan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SlideRegistActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide2);


    Button btnCek = findViewById(R.id.btn_cekdf);
    btnCek.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent goCek = new Intent(SlideRegistActivity.this, ListRSActivity.class);
            startActivity(goCek);
            finish();
        }
    });
    }
}
