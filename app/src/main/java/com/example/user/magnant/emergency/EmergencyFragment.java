package com.example.user.magnant.emergency;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.ClickListener;
import com.example.user.magnant.R;

import java.util.ArrayList;
import java.util.List;

public class EmergencyFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private static final String TAG = "qcel";
    private final int REQUEST_PERMISSION_PHONE_STATE=1;

    private List<EmergencyItem> listItem;

    public EmergencyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_emergency, container, false);

        toolbar = view.findViewById(R.id.toolbar_emergency);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        getActivity().setTitle("Emergency");

        recyclerView = view.findViewById(R.id.rv_emergency);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItem = new ArrayList<>();
        this.listItem.add(new EmergencyItem("Arsyel","085723443658"));
        for (int i = 0; i < 9; i++) {
            int j = i + 1;
            EmergencyItem listItem = new EmergencyItem(
                    "Person " + j,
                    "0813" + i + "4694153"
            );
            this.listItem.add(listItem);
        }

        adapter = new EmergencyAdapter(listItem, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                if (isCallAllowed() >= 0){
                    String phoneNum = listItem.get(position).getDesc();

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + phoneNum));

                    // Get data for number
                    Log.d(TAG, "onPositionClicked: "+phoneNum);

                    startActivity(intent);
                }
                else{
                    showPhoneStatePermission();
                }
            }

            @Override
            public void onLongClicked(int position) {

            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    private int isCallAllowed(){
        return ContextCompat.checkSelfPermission(
                getContext(), Manifest.permission.CALL_PHONE);
    }

    private void showPhoneStatePermission() {
        int permissionCheck = isCallAllowed();
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.CALL_PHONE)) {
                showExplanation("Permission Needed", "Need to be granted Phone permission by user.",
                        Manifest.permission.CALL_PHONE, REQUEST_PERMISSION_PHONE_STATE);
            } else {
                requestPermission(Manifest.permission.CALL_PHONE, REQUEST_PERMISSION_PHONE_STATE);
            }
        } else {
            System.out.println("PERM: PERMISSION IS GRANTED");
        }
        System.out.println("PERM: Permission Int >>> " + permissionCheck);
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{permissionName}, permissionRequestCode);
        System.out.println("PERM: REQUEST PERMISSION");
    }

    private void showExplanation(String title,
                                 String message,
                                 final String permission,
                                 final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        requestPermission(permission, permissionRequestCode);
                    }
                });
        builder.create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults){
        switch (requestCode) {
            case REQUEST_PERMISSION_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    System.out.println("PERM: PERMISSION GRANTED!");

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    System.out.println("PERM: PERMISSION DENIED!");
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}
