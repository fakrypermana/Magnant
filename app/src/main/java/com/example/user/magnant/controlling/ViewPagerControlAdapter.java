package com.example.user.magnant.controlling;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.magnant.controlling.konseling.KonselingFragment;
import com.example.user.magnant.controlling.monitoring.MonitoringFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerControlAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public ViewPagerControlAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return KonselingFragment.newInstance(0, "Page # 1");
            case 1:
                return MonitoringFragment.newInstance(1, "Page # 2");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        return title;
    }


}
