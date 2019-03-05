package com.introtoandroid.csci490_lab_04;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskTutorial extends AsyncTask<String, Void, String> {

    private TextView textView;

    public AsyncTaskTutorial(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... String) {

        URL url = null;
        try{
            url = new URL(String[0]);
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
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("broken", line);

        return line;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s.substring(13, 26));
    }
}
