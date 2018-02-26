package com.example.mathias.innlevering2android.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mathias.innlevering2android.R;
import com.example.mathias.innlevering2android.activities.ContactActivity;
import com.example.mathias.innlevering2android.activities.MapsActivity;
import com.example.mathias.innlevering2android.activities.PubilcTransportActivity;
import com.example.mathias.innlevering2android.activities.TuristMapActivity;
import com.example.mathias.innlevering2android.activities.WeatherActivity;


public class MainMenuFragment extends Fragment implements View.OnClickListener{
    private Button mresturantBtn, mDiscoverBtn, mTaxiBtn, mTuristMapBtn, mPtransportbtn, mweatherbtn, mContactbtn;


    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View v)
    {
        mresturantBtn = (Button) v.findViewById(R.id.restaurantMain);
        mresturantBtn.setOnClickListener(this);
        mDiscoverBtn = (Button) v.findViewById(R.id.discoverMain);
        mDiscoverBtn.setOnClickListener(this);
        mTaxiBtn = (Button) v.findViewById(R.id.callTaxiMain);
        mTaxiBtn.setOnClickListener(this);
        mTuristMapBtn = (Button) v.findViewById(R.id.localMapMain);
        mTuristMapBtn.setOnClickListener(this);
        mPtransportbtn = (Button) v.findViewById(R.id.publicTransportMain);
        mPtransportbtn.setOnClickListener(this);
        mweatherbtn = (Button) v.findViewById(R.id.weatherHome);
        mweatherbtn.setOnClickListener(this);
        mContactbtn = (Button) v.findViewById(R.id.contactHome);
        mContactbtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        Button clicked = (Button) v;

        // Open a map of resturant in Oslo
        if (clicked == mresturantBtn) {
            Intent ResturantMapIntent = new Intent(getContext(), MapsActivity.class);
            getContext().startActivity(ResturantMapIntent);
        }

            // Open the webpage to VisitNorvay.no
            else if (clicked == mDiscoverBtn) {
                Uri VisitOslouri = Uri.parse("https://www.visitoslo.com/no/aktiviteter-og-attraksjoner/attraksjoner/");
                Intent intent = new Intent(Intent.ACTION_VIEW, VisitOslouri);
                startActivity(intent);
            }
            // Starts a call to a taxi company
            else if (clicked == mTaxiBtn) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:02323"));
                startActivity(phoneIntent);
            }
            //Display a local turist map of Oslo
            else if (clicked == mTuristMapBtn) {
                Intent turistmapintent = new Intent(getContext(), TuristMapActivity.class);
                getContext().startActivity(turistmapintent);
            }
            //Display a local public transport map of Oslo
            else if (clicked == mPtransportbtn) {
                Intent publictransportintent = new Intent(getContext(), PubilcTransportActivity.class);
                getContext().startActivity(publictransportintent);
            }
            // Gets the weatherforcast
            else if (clicked == mweatherbtn) {
                Intent weatherIntent = new Intent(getContext(), WeatherActivity.class);
                getContext().startActivity(weatherIntent);
            }
            // Shows contact information
            else if (clicked == mContactbtn) {
                Intent contactIntent = new Intent(getContext(), ContactActivity.class);
                getContext().startActivity(contactIntent);
            }
        }


}



