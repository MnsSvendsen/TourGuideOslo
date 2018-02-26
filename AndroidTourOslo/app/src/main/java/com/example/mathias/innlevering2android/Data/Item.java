package com.example.mathias.innlevering2android.Data;

import org.json.JSONObject;

/**
 * Created by Mathias on 28.05.2017.
 */

public class Item implements JSONPopulator{
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {

        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
