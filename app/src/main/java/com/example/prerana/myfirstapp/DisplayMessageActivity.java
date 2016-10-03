package com.example.prerana.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {
//***********************This is an activity tha that is executed when the question is submitted and it Displays the Message ************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //**********grabs the intent that started the activity. ************
        Intent intent = getIntent();
        //**********retrieves the data from the first activity.***********
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String name = intent.getStringExtra(MainActivity.NAME);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        //******Check if the the entry is a question********
        if (message.endsWith("?")){
        Random r = new Random();
        int i = r.nextInt(100);
        String m = Integer.toString(i);
        textView.setText("Hi "+name+",\n"+m+"%  YES. \nAll the best");}
        else{
            textView.setText("Please enter a question with a '?' in the end for a valid answer");
        }

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
}