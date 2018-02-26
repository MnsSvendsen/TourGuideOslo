package com.example.mathias.innlevering2android.Data;

import org.json.JSONObject;

/**
 * Created by Mathias on 28.05.2017.
 */

public class Channel implements JSONPopulator{
    private Item item;
    private Units units;

    public Item getItem() {
        return item;
    }

    public Units getUnits() {
        return units;
    }

    @Override
    public void populate(JSONObject data) {

        units = new Units();
        units.populate(data.optJSONObject("units"));


        item = new Item();
        units.populate(data.optJSONObject("item"));


    }
}
