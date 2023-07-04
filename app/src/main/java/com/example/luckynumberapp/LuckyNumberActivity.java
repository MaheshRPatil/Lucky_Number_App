package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView lucky,number;
    Button sharebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        lucky=findViewById(R.id.lucky);
        number=findViewById(R.id.number);
        sharebtn=findViewById(R.id.sharebtn);

        //UserName
        Intent i=getIntent();
        String user_name=i.getStringExtra("name");

        //Random Number Generater
        int random_Num= generaterandomNumber();
        lucky.setText(""+random_Num);
        Toast.makeText(this, "User Name ="+i, Toast.LENGTH_SHORT).show();

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(user_name,random_Num);
            }
        });
    }
    public int generaterandomNumber(){
        Random random=new Random();
        int upper_limit=1000;

        int randomNumberGenerated=random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String username,int randomNumber){
        //Implicit Number
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //converting int to string
        String number=String.valueOf(randomNumber);

        i.putExtra(Intent.EXTRA_SUBJECT,username);
        i.putExtra(Intent.EXTRA_TEXT,randomNumber);

        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}