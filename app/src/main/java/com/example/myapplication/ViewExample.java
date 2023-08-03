package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewExample extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_example);
        onexecuting();
    }

    private void onexecuting() {
        b1 = findViewById(R.id.lv_example);
        b2 = findViewById(R.id.cus_lv_example) ;
        b3 = findViewById(R.id.gr_example) ;
        b4 = findViewById(R.id.recy_example);
    }
}