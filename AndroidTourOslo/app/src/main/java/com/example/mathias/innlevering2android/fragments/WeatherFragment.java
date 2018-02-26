package com.example.mathias.innlevering2android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mathias.innlevering2android.R;

/**
 * Created by Mathias on 27.05.2017.
 */

public class WeatherFragment extends Fragment
{


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        return view;
    }
}



