package com.example.readmoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.readmorelib.ReadMoreView;

public class MainActivity extends AppCompatActivity {

    private ReadMoreView my_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_view = (ReadMoreView)findViewById(R.id.main_LAY_textview);
        //my_view.setText(""); you can set the text in running using this line

    }
}