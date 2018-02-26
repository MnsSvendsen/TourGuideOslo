package com.example.mathias.innlevering2android;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathias.innlevering2android.Data.Channel;
import com.example.mathias.innlevering2android.Data.Item;
import com.example.mathias.innlevering2android.Service.WeatherServiceCallback;
import com.example.mathias.innlevering2android.Service.YahooWeatherService;

public class YahooWeatherActivity extends ActionBarActivity implements WeatherServiceCallback {

    private ImageView weatherIconImage;
    private TextView temperaturText;
    private TextView conditionText;
    private TextView locationText;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_weather);


        weatherIconImage = (ImageView)findViewById(R.id.weatherImg);
        temperaturText = (TextView)findViewById(R.id.weathertempatur);
        conditionText = (TextView)findViewById(R.id.weathercondistion);
        locationText = (TextView)findViewById(R.id.weatherlocation);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();

        service.refreshWeather("Austin, TX");

    }


    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        int resource = getResources().getIdentifier("drawable/icon_"+ item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resource);

        weatherIconImage.setImageDrawable(weatherIconDrawable);

        temperaturText.setText(item.getCondition().getTemeratur()+ "\u2103" + channel.getUnits().getTemperature());
        conditionText.setText(item.getCondition().getDescription());
        locationText.setText(service.getLocation());
    }

    @Override
    public void serviceFaild(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
