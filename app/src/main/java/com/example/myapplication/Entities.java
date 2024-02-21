package com.example.myapplication;

import android.widget.TextView;
import android.app.Activity;

public class Entities {
    TextView LocationName;
    TextView LocationRegion ;
    TextView Temp;
    TextView Condition;
    public Entities(Activity activity) {
        this.LocationName = activity.findViewById(R.id.LocationName);
        this.LocationRegion = activity.findViewById(R.id.LocationRegion);
        this.Temp = activity.findViewById(R.id.Temp);
        this.Condition = activity.findViewById(R.id.Condition);
    }

}
