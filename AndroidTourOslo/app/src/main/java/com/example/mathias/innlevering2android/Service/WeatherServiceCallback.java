package com.example.mathias.innlevering2android.Service;


import com.example.mathias.innlevering2android.Data.Channel;

/**
 * Created by Mathias on 28.05.2017.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFaild(Exception exception);


}
