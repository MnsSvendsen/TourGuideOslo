package com.example.mathias.innlevering2android.Service;

import android.net.Uri;
import android.os.AsyncTask;

import com.example.mathias.innlevering2android.Data.Channel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Mathias on 28.05.2017.
 */

public class YahooWeatherService {
    private WeatherServiceCallback callback;
    private String location;
    private Exception error;

    public YahooWeatherService(WeatherServiceCallback callback)

    {
        this.callback = callback;
    }

    public String getLocation()
    {
        return location;
    }

    public void refreshWeather(final String location)
    {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings)
            {
                String YQL  = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\") and u='" + "'", location);

                String endpint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

                try {
                    URL url = new URL(endpint);

                    URLConnection connection = url.openConnection();

                    InputStream inputStream = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder resolute = new StringBuilder();
                    String line;
                    while ((line=reader.readLine()) !=null)
                    {
                        resolute.append(line);
                    }

                    return resolute.toString();

                } catch (Exception e) {
                    error = e;
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s)
            {
                if (s == null && error !=null )
                {
                    callback.serviceFaild(error);
                   return;
                }


                try {
                    JSONObject data = new JSONObject(s);

                    JSONObject queryRes = data.optJSONObject("query");
                    int count = queryRes.optInt("count");
                    if (count==0)
                    {
                        callback.serviceFaild(new LocationWeatherExeption("No info found for "+location));
                        return;
                    }

                    Channel channel = new Channel();
                    channel.populate(queryRes.optJSONObject("results").optJSONObject("channel"));

                    callback.serviceSuccess(channel);

                } catch (JSONException e) {
                    callback.serviceFaild(e);
                }


            }
        }.execute(location);
    }

    public class LocationWeatherExeption extends Exception
    {
        public LocationWeatherExeption(String message) {
            super(message);
        }
    }
}
