package com.example.doancuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doancuoiki.Adapter.LichSuAdapter;
import com.example.doancuoiki.Class.LichSu;
import com.example.doancuoiki.Database.DB_LichSuChoi;

import java.util.ArrayList;

public class LichSuChoi extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_choi);

    }
}
