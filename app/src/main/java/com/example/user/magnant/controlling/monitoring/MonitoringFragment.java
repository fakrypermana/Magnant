package com.example.user.magnant.controlling.monitoring;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.R;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class MonitoringFragment extends Fragment {

    private CircularProgressIndicator circularProgress,circularLemak,circularProtein,circularKarbo;
    private FloatingActionButton fab_add_monitoring;

    public MonitoringFragment() {
        // Required empty public constructor
    }

    public static MonitoringFragment newInstance(int page, String title) {
        MonitoringFragment fragmentPesan = new MonitoringFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentPesan.setArguments(args);
        return fragmentPesan;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monitoring, container, false);

        //setupview
        circularProgress = view.findViewById(R.id.circular_progress);
        circularKarbo = view.findViewById(R.id.circular_progress_karbohidrat);
        circularLemak = view.findViewById(R.id.circular_progress_lemak);
        circularProtein = view.findViewById(R.id.circular_progress_protein);
        fab_add_monitoring = view.findViewById(R.id.fb_create_monitoring);

        //setup layout
        fab_add_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddMonitoringActivity.class);
                startActivity(intent);
            }
        });

        setupProgressCircular();
        return view;
    }

    public void setupProgressCircular(){
        //kalori
        circularProgress.setMaxProgress(2800);
        circularProgress.setCurrentProgress(1700);
// or all at once
        circularProgress.setProgress(1700, 2800);

// you can get progress values using following getters
        circularProgress.getProgress();
        circularProgress.getMaxProgress();

        //lemak
        circularLemak.setMaxProgress(100);
        circularLemak.setCurrentProgress(91);
// or all at once
        circularLemak.setProgress(91, 100);

// you can get progress values using following getters
        circularLemak.getProgress();
        circularLemak.getMaxProgress();

        //protein
        circularProtein.setMaxProgress(140);
        circularProtein.setCurrentProgress(110);
// or all at once
        circularProtein.setProgress(110, 140);

// you can get progress values using following getters
        circularProtein.getProgress();
        circularProtein.getMaxProgress();

        //karbohidrat
        circularKarbo.setMaxProgress(342);
        circularKarbo.setCurrentProgress(280);
// or all at once
        circularKarbo.setProgress(280, 342);

// you can get progress values using following getters
        circularKarbo.getProgress();
        circularKarbo.getMaxProgress();
    }
}
