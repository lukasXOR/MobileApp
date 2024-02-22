package com.example.myapplication;

// Weather app
// The external API I will be using is https://www.weatherapi.com/

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.ToggleButton;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout main;
    public Entities entities;
    public WeatherData info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entities = new Entities(this);
        main = findViewById(R.id.main);


        WeatherOperation WeatherOp = new WeatherOperation("Northampton");
        WeatherOp.execute();

        try {
            String response = WeatherOp.get();
            Gson gson = new Gson();
            System.out.println(response);

            info = gson.fromJson(response, WeatherData.class);

            UpdateInfo(info);
        } catch (Exception e) {e.printStackTrace();}

        Switch DegreeType = (Switch)findViewById(R.id.DegreeType);
        DegreeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) entities.SetTemp(info.current.temp_f);
                else entities.SetTemp(info.current.temp_c);
            }
        });
    }

    void UpdateInfo(WeatherData WeatherInfo) {
        main.setBackgroundColor(WeatherColors.GetWeatherInHex(WeatherInfo.current.condition.text));
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





