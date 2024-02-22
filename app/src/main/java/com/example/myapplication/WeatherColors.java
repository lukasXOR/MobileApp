package com.example.myapplication;
public class WeatherColors {
    public static int LightYellow = 0xFFF7DC6F;
    public static int LightGray = 0xFF7F8C8D;
    public static int DarkBlue  = 0xFF2C3E50;

    /*
    Possible weather conditions https://www.weatherapi.com/docs/weather_conditions.json
     */
    static int GetWeatherInHex(String Weather) {
        switch (Weather) {
            case "Sunny":
                return LightYellow;

            case "Patchy rain possible":
            case "Moderate rain":
            case "Heavy rain at times":
            case "Light freezing rain":
            case "Heavy rain":
                return DarkBlue;

            case "Cloudy":
            case "Partly cloudy":
            case "Overcast":
            case "Mist":
                return LightGray;
        }
        return 0xFFFFFFFF;
    }
}
