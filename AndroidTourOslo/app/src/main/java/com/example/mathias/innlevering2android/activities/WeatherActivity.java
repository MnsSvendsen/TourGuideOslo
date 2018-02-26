package com.example.mathias.innlevering2android.activities;

import android.support.v4.app.Fragment;

import com.example.mathias.innlevering2android.fragments.WeatherFragment;

/**
 * Created by Mathias on 27.05.2017.
 */

public class WeatherActivity extends FragmentHolderActivity {

    protected Fragment createFragment()
    {
        return new WeatherFragment();
    }
}