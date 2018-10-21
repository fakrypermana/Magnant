package com.example.user.magnant;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.user.magnant.Fragment.ControlFragment;
import com.example.user.magnant.Fragment.EmergencyFragment;
import com.example.user.magnant.Fragment.HomeFragment;
import com.example.user.magnant.Fragment.ProfileFragment;
import com.example.user.magnant.Fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Magnant");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    fragment = new HomeFragment();
                    loadFragment();
                    return true;
                case R.id.navigation_control:
                    toolbar.setTitle("Controlling");
                    fragment = new ControlFragment();
                    loadFragment();
                    return true;
                case R.id.navigation_shop:
                    toolbar.setTitle("Shop");
                    fragment = new ShopFragment();
                    loadFragment();
                    return true;
                case R.id.navigation_call:
                    toolbar.setTitle("Emergency");
                    fragment = new EmergencyFragment();
                    loadFragment();
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment();
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
