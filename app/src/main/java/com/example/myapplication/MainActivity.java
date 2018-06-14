package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.myapplication.REST.CallAPI;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        CallAPI myCallAPI = new CallAPI();
        myCallAPI.setOnTaskCompletedListener(new REST.TaskCompletedListener() {
            @Override
            public void onTaskCompleted(String result) {
                textView1.setText(result);
            }
        });
        myCallAPI.execute("https://restcountries.eu/rest/v2/alpha/tw");

        REST.CallAPI myCallAPI2 = new REST.CallAPI();
        myCallAPI2.setOnTaskCompletedListener(new REST.TaskCompletedListener() {
            @Override
            public void onTaskCompleted(String result) {
                textView2.setText(result);
            }
        });
        myCallAPI2.execute("https://restcountries.eu/rest/v2/name/eesti");
    }
}
