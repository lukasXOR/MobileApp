package com.example.myapplication;

// Weather app
// The external API I will be using is https://www.weatherapi.com/

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;
import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public Entities entities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entities = new Entities(this);
        WeatherOperation test = new WeatherOperation("Northampton");
        test.execute();


        try {
            String response = test.get();
            Gson gson = new Gson();

            // Deserialising...
            // This process lets us parse json into classes making it easier
            // to access by doing 'class.property' rather then calling a method each time
            WeatherData info = gson.fromJson(response, WeatherData.class);

            UpdateInfo(info);
        } catch (Exception e) {e.printStackTrace();}
    }

    void UpdateInfo(WeatherData WeatherInfo) {
        entities.LocationName.setText(WeatherInfo.location.name);
        entities.LocationRegion.setText(WeatherInfo.location.region);
        entities.Temp.setText(Double.toString(WeatherInfo.current.temp_c) + "°");
        entities.Condition.setText(WeatherInfo.current.condition.text);
    }
}






class Colors {
    public static int Sunny = 0xFFcfd13d;
    public static int Cloudy = 0xFFC2C3C1;
    public static int Rain = 0xFF00A5B1;
}