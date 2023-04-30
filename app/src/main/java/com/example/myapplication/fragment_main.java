package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fragment_main extends AppCompatActivity {

    Button fstfragment, scndfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        fstfragment = findViewById(R.id.fragment1btn);
        scndfragment = findViewById(R.id.fragment2btn);

        fstfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new Fragment_1());
            }
        });
        scndfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new fragment_2());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager frag = getSupportFragmentManager();
        FragmentTransaction fragt = frag.beginTransaction();
        fragt.replace(R.id.FrameLayout,fragment);
        fragt.commit();
    }
}