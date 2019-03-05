package com.introtoandroid.csci490_lab_04;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        AsyncTaskTutorial asyncTaskTutorial = new AsyncTaskTutorial(textView);
        asyncTaskTutorial.execute("https://jsonplaceholder.typicode.com/users");

    }
    public String methodNameUnknown(String s){
        return "yourMother";

    }
}
