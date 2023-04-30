package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    Button b1;

    TextView t1,t2;
    Button b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickListener();
        t2 = (TextView) findViewById(R.id.cmenu_example);
        registerForContextMenu(t2);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Log in");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu,menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Selected Item : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.one:
                return true;

            case R.id.two:
                return true;

            case R.id.three:
                return true;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
    }

    public void OnClickListener(){
        e1 =  findViewById(R.id.edit);
        e2 =  findViewById(R.id.edit2);
        b1 =  findViewById(R.id.log);
        t1 = findViewById(R.id.sign);

        b3 =  findViewById(R.id.demo);
        b4 = findViewById(R.id.popup_menu);

        b2 = findViewById(R.id.button2);

        b2.setOnClickListener(v -> {
            Intent train = new Intent(MainActivity.this,Dialog_Box_Example.class);
            startActivity(train);
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getText().toString();
                String password = e2.getText().toString();
                Intent i = new Intent(MainActivity.this,secondactivity.class);
                i.putExtra("uname",name);
                i.putExtra("password",password);
                /*if(name.equals("bibek") && password.equals("bibek")){
                    startActivityForResult(i,0);
                }
                else{
                    Toast.makeText(getBaseContext(),"INCORRECT PASSWORD OR USERNAME" , Toast.LENGTH_LONG).show();
                }*/
                startActivityForResult(i,2);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,fragment_main.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, b4);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){
            String name = getIntent().getStringExtra("Message");
            e1 = (EditText) findViewById(R.id.edit);
            e1.setText(name);
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        }
    }
}