package com.example.prerana.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String name = intent.getStringExtra(MainActivity.NAME);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        //textView.setText(message);
        if (message.endsWith("?")){
        Random r = new Random();
        int i = r.nextInt(100);
        //textView.setText(message);
        String m = Integer.toString(i);
        textView.setText("Hi "+name+",\n"+m+"%  YES. \nAll the best making your decision");}
        else{
            textView.setText("Please enter a question with a '?' in the end for a valid answer");
        }


        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
}