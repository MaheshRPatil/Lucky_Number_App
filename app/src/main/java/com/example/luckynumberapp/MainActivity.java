package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView appname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appname=findViewById(R.id.appname);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText.getText().toString();
                //Explicit Intent
                Intent i=new Intent(getApplicationContext(),LuckyNumberActivity.class);

                //passing the name to second activity
                i.putExtra("name",name);
                startActivity(i);
            }
        });
    }
}