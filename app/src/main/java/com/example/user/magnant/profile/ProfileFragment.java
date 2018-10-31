package com.example.user.magnant.profile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import com.example.user.magnant.LoginActivity;
import com.example.user.magnant.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {
    private android.support.v7.widget.Toolbar toolbar;
    FirebaseAuth mAuth;
    ImageView editProfilePic;
    TextView editTextNama;
    TextView editTextUmur;
    TextView editTextHp;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        editTextNama = view.findViewById(R.id.profileNama);
        editTextUmur = view.findViewById(R.id.profileUmur);
        editTextHp = view.findViewById(R.id.profileNoHp);
        editProfilePic = view.findViewById(R.id.profileImage);
        toolbar = view.findViewById(R.id.toolbar_profile);

        mAuth = FirebaseAuth.getInstance();
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        getActivity().setTitle("Profile");

        loadUserInformation();

        return view;
    }


    private void loadUserInformation(){
        FirebaseUser user = mAuth.getCurrentUser();

        if(user!=null) {
            if (user.getPhotoUrl() != null) {
                Glide.with(this)
                        .load(user.getPhotoUrl().toString())
                        .into(editProfilePic);
//                Picasso.get().load(user.getPhotoUrl().toString()).into(editProfilePic);
                //editProfilePic.setImageDrawable(getResources().getDrawable());
                //editTextHp.setText(user.getPhotoUrl().toString());
            }
            if (user.getDisplayName() != null) {
                editTextNama.setText(user.getDisplayName());
            }
        }
    }

}
