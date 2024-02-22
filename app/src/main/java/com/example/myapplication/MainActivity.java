package com.example.myapplication;

// Weather app
// The external API I will be using is https://www.weatherapi.com/

import androidx.appcompat.app.AppCompatActivity;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.ToggleButton;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    public Entities entities;
    public WeatherData info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entities = new Entities(this);

        WeatherOperation WeatherOp = new WeatherOperation("Northampton");
        WeatherOp.execute();

        try {
            String response = WeatherOp.get();
            Gson gson = new Gson();
            System.out.println(response);
            /*
             Deserialising...
             This process lets us parse json into classes making it easier
             to access by doing 'class.property' rather then calling a method each time
            */

            info = gson.fromJson(response, WeatherData.class);

            UpdateInfo(info);
        } catch (Exception e) {e.printStackTrace();}

        Switch DegreeType = (Switch)findViewById(R.id.DegreeType);
        DegreeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    entities.SetTemp(info.current.temp_f);
                } else {
                    entities.SetTemp(info.current.temp_c);
                }
            }
        });
    }

    void UpdateInfo(WeatherData WeatherInfo) {
        entities.LocationName.setText(WeatherInfo.location.name);
        entities.LocationRegion.setText(WeatherInfo.location.region);
        entities.Temp.setText(Double.toString(WeatherInfo.current.temp_c) + "°");
        entities.Condition.setText(WeatherInfo.current.condition.text);

        String ExtraInfo = "";

        ExtraInfo += "Wind (MPH): " + WeatherInfo.current.wind_mph + "\n";
        ExtraInfo += "Wind (Degree): " + WeatherInfo.current.wind_degree + "\n";
        ExtraInfo += "Wind (Direction): " + WeatherInfo.current.wind_dir + "\n";
        ExtraInfo += "Pressure (inches): " + WeatherInfo.current.pressure_in + "\n";
        ExtraInfo += "Precipitation (inches): " + WeatherInfo.current.precip_in + "\n";
        ExtraInfo += "Humidity: " + WeatherInfo.current.humidity + "\n";
        ExtraInfo += "Cloud: " + WeatherInfo.current.cloud + "\n";
        ExtraInfo += "Feels Like (C): " + WeatherInfo.current.feelslike_c + "\n";
        ExtraInfo += "Gust (MPH): " + WeatherInfo.current.gust_mph + "\n";

        entities.ExtraInfo.setText(ExtraInfo);

    }
}






class Colors {
    public static int Sunny = 0xFFcfd13d;
    public static int Cloudy = 0xFFC2C3C1;
    public static int Rain = 0xFF00A5B1;
}