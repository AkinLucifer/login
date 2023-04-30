package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Dialog_Box_Example extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box_example);
        OnClickListener();
    }

    public void OnClickListener() {
        b1 = findViewById(R.id.alert);

        b1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Dialog_Box_Example.this);

            builder.setMessage("Yeta aaune vayexa ni hajur k kam paryo?");
            builder.setTitle("K ho");
            builder.setPositiveButton("Agadi ko page niskinus",(DialogInterface.OnClickListener)(dialog, which)->{
                finish();
            });

            builder.setNegativeButton("Firta janus",(DialogInterface.OnClickListener)(dialog,whic)->{
                dialog.cancel();
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }
}