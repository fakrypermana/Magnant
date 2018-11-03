package com.example.user.magnant.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.bumptech.glide.request.RequestOptions;
import com.example.user.magnant.R;
import com.example.user.magnant.loginregis.LoginActivity;

import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class ProfileFragment extends Fragment {
    private Toolbar toolbar;
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

        editTextHp = view.findViewById(R.id.profileNoHp);
        editProfilePic = view.findViewById(R.id.profileImage);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_profile);

        mAuth = FirebaseAuth.getInstance();
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        getActivity().setTitle("Profile");

        loadUserInformation();
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.setup, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.AlertDialog);

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_dialogs, null);

                TextView title = (TextView) view.findViewById(R.id.title);
                ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

                title.setText("Logout");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "You're logout", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        getActivity().finish();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getActivity(), "Never Mind!", Toast.LENGTH_SHORT).show();
                    }
                }).create();


                builder.setView(view);
                builder.show();
//                FirebaseAuth.getInstance().signOut();
//                getActivity().finish();
//                startActivity(new Intent(getActivity(), LoginActivity.class));

                break;
        }

        return true;
    }

    private void loadUserInformation(){
        FirebaseUser user = mAuth.getCurrentUser();

        if(user!=null) {
            if (user.getPhotoUrl() != null) {
                Glide.with(this)
                        .load(user.getPhotoUrl().toString())
                        .apply(RequestOptions.circleCropTransform())
                        .into(editProfilePic);
            }
            if (user.getDisplayName() != null) {
                editTextNama.setText(user.getDisplayName());

            }
            if(user.getPhoneNumber()!=null){
                editTextHp.setText(user.getPhoneNumber());
            }
        }
    }



}
