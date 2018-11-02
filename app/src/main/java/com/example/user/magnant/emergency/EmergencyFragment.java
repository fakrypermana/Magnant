package com.example.user.magnant.emergency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.PhoneAccountHandle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.magnant.ClickListener;
import com.example.user.magnant.R;

import java.util.ArrayList;
import java.util.List;

public class EmergencyFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private static final String TAG = "qcel";

    private List<EmergencyItem> listItem;

    public EmergencyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_emergency, container, false);

        toolbar = view.findViewById(R.id.toolbar_emergency);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        getActivity().setTitle("Emergency");

        recyclerView = view.findViewById(R.id.rv_emergency);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItem = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int j = i + 1;
            EmergencyItem listItem = new EmergencyItem(
                    "Person " + j,
                    "0857" + i+2 + "34436"+ i +"8"
            );

            this.listItem.add(listItem);
        }
        adapter = new EmergencyAdapter(listItem, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                // Get data for number
                Log.d(TAG, "onPositionClicked: "+listItem.get(position).getDesc());
            }

            @Override
            public void onLongClicked(int position) {

            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }


}
