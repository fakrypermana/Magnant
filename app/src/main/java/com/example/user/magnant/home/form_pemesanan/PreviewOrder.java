package com.example.user.magnant.home.form_pemesanan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.R;

public class PreviewOrder extends Fragment {

    public PreviewOrder() {
        // Required empty public constructor
    }

    public static PreviewOrder newInstance(int page, String title) {
        PreviewOrder fragmentPreview = new PreviewOrder();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentPreview.setArguments(args);
        return fragmentPreview;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preview_order, container, false);

        return view;
    }

}
