package com.example.user.magnant.emergency;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.R;

import java.util.ArrayList;
import java.util.List;

public class EmergencyFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListofEmergencyItem> listItem;

    public EmergencyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emergency, container, false);

        toolbar = view.findViewById(R.id.toolbar_emergency);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        getActivity().setTitle("Emergency");

        recyclerView = view.findViewById(R.id.rv_emergency);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItem = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ListofEmergencyItem listItem = new ListofEmergencyItem(
                    "Person" + i,
                    "0857" + i+2 + "34436"+ i +"8"
            );

            this.listItem.add(listItem);
        }
        adapter = new MyAdapter(getActivity(), listItem);

        recyclerView.setAdapter(adapter);

        return view;
    }


}
