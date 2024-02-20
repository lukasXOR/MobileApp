package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.graphics.Color;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Location = findViewById(R.id.Location);
        Location.setText("Northampton");
    }
}

class Weather {
    public static void get() {
        try {

        } catch (Exeception e) {
        }
        }
        URL WeatherAPIURL = new URL("http://example.com/api/datajjjj");

        HttpURLConnection connection = (HttpURLConnection) WeatherAPIURL.openConnection();

        connection.setRequestMethod("GET");



    }
}

class Colors {
    public static int Sunny = 0xFFcfd13d;
    public static int Cloudy = 0xFFC2C3C1;
    public static int Rain = 0xFF00A5B1;
}