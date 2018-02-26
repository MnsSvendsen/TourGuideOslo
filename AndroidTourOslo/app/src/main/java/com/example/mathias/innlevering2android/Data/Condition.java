package com.example.mathias.innlevering2android.Data;

import org.json.JSONObject;

/**
 * Created by Mathias on 28.05.2017.
 */

public class Condition implements JSONPopulator{
    private int code;
    private int temeratur;
    private String description;

    public int getCode() {
        return code;
    }

    public int getTemeratur() {
        return temeratur;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void populate(JSONObject data) {
        code = data.optInt("code");
        temeratur = data.optInt("temp");
        description = data.optString("text");
    }
}
