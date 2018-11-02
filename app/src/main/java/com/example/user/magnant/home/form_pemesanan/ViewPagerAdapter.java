package com.example.user.magnant.home.form_pemesanan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public ViewPagerAdapter(FragmentManager fragmentManager) {
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
                    return PesanDokter.newInstance(0, "Page # 1");
                case 1:
                    return PreviewOrder.newInstance(1, "Page # 2");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if (position == 0)
            {
                title = "Data diri";
            }
            else if (position == 1)
            {
                title = "Detail";
            }
            return title;
        }


}
