package com.example.mathias.innlevering2android.Data;

import org.json.JSONObject;

/**
 * Created by Mathias on 28.05.2017.
 */

public class Units implements JSONPopulator{
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }
}
