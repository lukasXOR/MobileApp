package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.graphics.Color;
import android.os.Bundle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Random;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Location = findViewById(R.id.Location);
        Location.setText("Northampton");

        Weather test = new Weather("HP111BN");
        test.execute();

        try {
            String response = test.get();
            Gson gson = new Gson();

            // Deserialising...
            // This process lets us parse json into classes making it easier
            // to access by doing 'class.property' rather then calling a method each time
            WeatherData info = gson.fromJson(response, WeatherData.class);


            System.out.println(info.location.name);
        } catch (Exception e) {e.printStackTrace();}
    }


}


class Weather extends AsyncTask<Void, Void, String> {
    private final String location;
    public Weather(String location) {
        super();
        this.location = location;
    }
    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("https://api.weatherapi.com/v1/current.json?key=909ca5dbb1a8401f834122709242002&q=" + this.location + "&aqi=");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            connection.disconnect();

        } catch (Exception e) {
            Log.e("HttpTask", "Error", e);
        }
        return response.toString();
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Handle the result, update UI, etc.
        //Log.d("HttpTask", "Response: " + result);
    }
}






class Colors {
    public static int Sunny = 0xFFcfd13d;
    public static int Cloudy = 0xFFC2C3C1;
    public static int Rain = 0xFF00A5B1;
}