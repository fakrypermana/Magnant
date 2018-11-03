package com.example.user.magnant.controlling.monitoring;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.user.magnant.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class MonitoringFragment extends Fragment {

    private CircularProgressIndicator circularProgress,circularLemak,circularProtein,circularKarbo;
    private FloatingActionButton fab_add_monitoring;
    private TextView tv_date_monitoring,view_more_date;
    private final Calendar myCalendar = Calendar.getInstance();

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
        tv_date_monitoring = view.findViewById(R.id.tv_date_monitoring);
        view_more_date = view.findViewById(R.id.view_more_monitoring);

        //setup layout
        fab_add_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddMonitoringActivity.class);
                startActivity(intent);
            }
        });



        final DatePickerDialog.OnDateSetListener date_picker = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        //setup layout

        view_more_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date_picker, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
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

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tv_date_monitoring.setText(sdf.format(myCalendar.getTime()));
    }
}
