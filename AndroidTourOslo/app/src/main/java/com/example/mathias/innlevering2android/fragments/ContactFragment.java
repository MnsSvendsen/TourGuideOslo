package com.example.mathias.innlevering2android.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mathias.innlevering2android.R;
import com.example.mathias.innlevering2android.activities.MapsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements View.OnClickListener{
    private ImageView mPhoneBtn, mMapBtn, mEmailBtn, mtwitter, mInstaBtn,  mFacebookBtn;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View v){
        mPhoneBtn = (ImageView) v.findViewById(R.id.btn_phone);
        mPhoneBtn.setOnClickListener(this);
        mMapBtn = (ImageView) v.findViewById(R.id.btn_map);
        mMapBtn.setOnClickListener(this);
        mEmailBtn = (ImageView) v.findViewById(R.id.btn_email);
        mEmailBtn.setOnClickListener(this);
        mtwitter = (ImageView) v.findViewById(R.id.btn_twitter);
        mtwitter.setOnClickListener(this);
        mInstaBtn = (ImageView) v.findViewById(R.id.btn_instagram);
        mInstaBtn.setOnClickListener(this);
        mFacebookBtn = (ImageView) v.findViewById(R.id.btn_facebook);
        mFacebookBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ImageView clicked = (ImageView) v;
        // Open the dial dialog with the number set below
        if (clicked == mPhoneBtn) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            phoneIntent.setData(Uri.parse("tel:004722005700"));
            startActivity(phoneIntent);
        }
        // Start the map fragment
        else if (clicked == mMapBtn) {
            Intent mapIntent = new Intent(getContext(), MapsActivity.class);
            getContext().startActivity(mapIntent);
        }
        // Starts email intent
        else if (clicked == mEmailBtn) {
            String[] emails = {"cc.folketeateret@choice.no"};
            String subject = "your subject";
            String message = "your message";

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, emails);
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);

            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        }
        // Opens a web action_view with DNBs twitter page
        else if (clicked == mtwitter) {
            Uri uri = Uri.parse("https://twitter.com/nordic_choice");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        // same as above but instagram
        else if (clicked == mInstaBtn) {
            Uri uri = Uri.parse("https://www.instagram.com/nordicchoice/?hl=en");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        // Open web action_view with DNBs facebook page
        else if (clicked == mFacebookBtn) {
            Uri uri = Uri.parse("https://www.facebook.com/Nordicchoicehotels/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

    }
}
