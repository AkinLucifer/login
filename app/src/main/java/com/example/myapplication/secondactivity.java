package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {

    EditText e1;

    EditText e2;

    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        e1 = (EditText) findViewById(R.id.edit1);
        e2 = (EditText) findViewById(R.id.edit2);
        b2 =(Button) findViewById(R.id.back);
        String name = getIntent().getStringExtra("uname");
        String password = getIntent().getStringExtra("password");

        e1.setText(name);
        e2.setText(password);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent();
                a.putExtra("Message",name);
                setResult(2,a);
                finish();
            }
        });
    }
}