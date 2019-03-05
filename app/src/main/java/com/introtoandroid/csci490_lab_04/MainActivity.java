package com.introtoandroid.csci490_lab_04;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(methodNameUnknown("https://jsonplaceholder.typicode.com/users"));


    }
    public String methodNameUnknown(String s){

        URL url = null;
        try{
            url = new URL(s);
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
        URLConnection urlConnection = null;
        try{
            urlConnection = url.openConnection();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        InputStreamReader iSReader = null;
        try{
            iSReader = new InputStreamReader(urlConnection.getInputStream());
        }
        catch(IOException e){
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(iSReader);

        String line = null;

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("broken", line);

        return "yourMother";

    }
}
