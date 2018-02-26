package com.example.mathias.innlevering2android.activities;

import android.support.v4.app.Fragment;

import com.example.mathias.innlevering2android.fragments.MainMenuFragment;

/**
 * Created by Mathias on 26.05.2017.
 */

public class MainMenuActivity extends FragmentHolderActivity {

    protected Fragment createFragment()
    {
        return new MainMenuFragment();
    }
}


