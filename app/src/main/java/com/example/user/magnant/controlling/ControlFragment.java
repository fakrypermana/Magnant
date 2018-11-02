package com.example.user.magnant.controlling;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ControlFragment extends Fragment {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pemesanan");

    public ControlFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        //setup view
        tabLayout = view.findViewById(R.id.tab_control);
        viewPager = view.findViewById(R.id.viewpager_control);
        toolbar = view.findViewById(R.id.toolbar_control);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        ViewPagerControlAdapter adapter = new ViewPagerControlAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        toolbar.setTitle("Controlling");

        return view;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.talk);
        tabLayout.getTabAt(1).setIcon(R.drawable.measure);
    }

}
