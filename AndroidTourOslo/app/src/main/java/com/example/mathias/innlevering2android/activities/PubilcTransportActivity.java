package com.example.mathias.innlevering2android.activities;

import android.support.v4.app.Fragment;

import com.example.mathias.innlevering2android.fragments.PublicTransportFragment;

/**
 * Created by Mathias on 27.05.2017.
 */

public class PubilcTransportActivity extends FragmentHolderActivity {

    protected Fragment createFragment()
    {
        return new PublicTransportFragment();
    }
}
