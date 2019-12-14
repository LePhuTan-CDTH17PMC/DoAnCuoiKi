package com.example.doancuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Man_hinh_chinh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
    }

    public void Play(View view) {
        Intent intent = new Intent(Man_hinh_chinh.this, Tra_loi.class);
        startActivity(intent);
    }
}
