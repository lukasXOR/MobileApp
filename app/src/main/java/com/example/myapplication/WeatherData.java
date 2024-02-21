package com.example.myapplication;

public class WeatherData {
    public LocationData location;
    public CurrentData current;

    static class LocationData {
        public String name;
        public String region;
        public String country;
        public double lat;
        public double lon;
        public String tz_id;
        public long localtime_epoch;
        public String localtime;
    }

    static class CurrentData {
        public long last_updated_epoch;
        public String last_updated;
        public double temp_c;
        public double temp_f;
        public int is_day;
        public ConditionData condition;
        public double wind_mph;
        public double wind_kph;
        public int wind_degree;
        public String wind_dir;
        public double pressure_mb;
        public double pressure_in;
        public double precip_mm;
        public double precip_in;
        public int humidity;
        public int cloud;
        public double feelslike_c;
        public double feelslike_f;
        public double vis_km;
        public double vis_miles;
        public double uv;
        public double gust_mph;
        public double gust_kph;
    }

    static class ConditionData {
        public String text;
        public String icon;
        public int code;
    }
}
