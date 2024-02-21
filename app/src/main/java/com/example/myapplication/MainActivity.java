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
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Location = findViewById(R.id.Location);
        Location.setText("Northampton");
        new Weather().execute();

    }


}
class Weather extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder response = new StringBuilder();
        try {
            // Create a URL object with the endpoint you want to connect to
            URL url = new URL("https://api.weatherapi.com/v1/current.json?key=909ca5dbb1a8401f834122709242002&q=NN48LU&aqi=");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.println("HELLO "+reader);
            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            Log.e("HttpTask", "Error", e);
        }
        System.out.println("jiih "+response.toString());
        return response.toString();
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Handle the result, update UI, etc.
        Log.d("HttpTask", "Response: " + result);
    }
}






class Colors {
    public static int Sunny = 0xFFcfd13d;
    public static int Cloudy = 0xFFC2C3C1;
    public static int Rain = 0xFF00A5B1;
}