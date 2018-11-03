package com.example.user.magnant.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.magnant.R;
import com.example.user.magnant.home.dokter_pribadi.DokterPribadiActivity;


public class HomeFragment extends Fragment {
    private Toolbar toolbar;
    private CardView cv_dokter_pribadi;
    private static final String ARG_KEY_NUMBER = "tab_number";

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(int number) {
        Bundle args = new Bundle();
        args.putInt(ARG_KEY_NUMBER, number);

        HomeFragment frag = new HomeFragment();
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = view.findViewById(R.id.toolbar_home);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        cv_dokter_pribadi = view.findViewById(R.id.menu_dokter_pribadi);

        getActivity().setTitle("Home");

        //listener
        cv_dokter_pribadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), DokterPribadiActivity.class);
                startActivity(i);
            }
        });


        return view;
    }

}
