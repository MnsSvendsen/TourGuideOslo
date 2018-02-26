package com.example.mathias.innlevering2android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.mathias.innlevering2android.R;

/**
 * Created by Mathias on 26.05.2017.
 */

public abstract class FragmentHolderActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_holder_container);


        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_holder_container, fragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Allows the user to log out by clicking the corresponding
     * button in the top right drop-down menu.
     */
   /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_log_out:
                Intent i = new Intent(this, LoginActivity.class);
                this.startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
     }
        */

}