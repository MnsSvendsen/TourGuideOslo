package com.example.mathias.innlevering2android.activities;

import android.support.v4.app.Fragment;

import com.example.mathias.innlevering2android.fragments.ContactFragment;

public class ContactActivity extends FragmentHolderActivity {

    protected Fragment createFragment()
    {
        return new ContactFragment();
    }
}
