package com.example.user.magnant.controlling.konseling;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.magnant.ClickListener;
import com.example.user.magnant.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class KonselingFragment extends Fragment {
    RecyclerView recyclerView;
    private List<KonselingModel> konselingList = new ArrayList<>();
    private KonselingRVAdapter mAdapter ;
    private FloatingActionButton fb_addKonseling;
    private TextView tv_date_konseling, view_more_date;
    private final Calendar myCalendar = Calendar.getInstance();

    public KonselingFragment() {
        // Required empty public constructor
    }

    public static KonselingFragment newInstance(int page, String title) {
        KonselingFragment fragmentPesan = new KonselingFragment();
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
        View view = inflater.inflate(R.layout.fragment_konseling, container, false);


        //dummy
        final Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        konselingList.add(new KonselingModel("Konseling Gizi",formattedDate,"Dr. Sinta Wijayanti","Ibu mengalami kekurangan kalori"));

        //setup view
        recyclerView = view.findViewById(R.id.rv_sesi_konseling);
        fb_addKonseling = view.findViewById(R.id.fb_create_konseling);
        tv_date_konseling = view.findViewById(R.id.tv_date_konseling);
        view_more_date = view.findViewById(R.id.view_more_konseling);



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

        //floating action button add konseling
        fb_addKonseling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),KonselingMessageActivity.class);
                startActivity(intent);
            }
        });

        mAdapter = new KonselingRVAdapter(konselingList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Intent intent = new Intent(getActivity(),DetailKonselingActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClicked(int position) {

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        return view;
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tv_date_konseling.setText(sdf.format(myCalendar.getTime()));
    }

}
