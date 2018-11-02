package com.example.user.magnant.controlling.konseling;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.R;

public class KonselingFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_konseling, container, false);
    }

}
