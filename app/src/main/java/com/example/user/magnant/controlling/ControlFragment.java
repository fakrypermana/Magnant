package com.example.user.magnant.controlling;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.user.magnant.R;
import com.example.user.magnant.home.dokter_pribadi.DokterPribadiActivity;
import com.example.user.magnant.home.form_pemesanan.PemesananModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ControlFragment extends Fragment {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<PemesananModel> pemesananModelList = new ArrayList<>();
    private static final String ARG_KEY_NUMBER = "tab_number";
    private Button btn_pesan_dicontrolling;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pemesanan");

    private final static String TAG = "fakuy";

    public ControlFragment() {
        // Required empty public constructor
    }

    public static ControlFragment newInstance(int number) {
        Bundle args = new Bundle();
        args.putInt(ARG_KEY_NUMBER, number);

        ControlFragment frag = new ControlFragment();
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        //setup view
        tabLayout = view.findViewById(R.id.tab_control);
        viewPager = view.findViewById(R.id.viewpager_control);
        toolbar = view.findViewById(R.id.toolbar_control);
        btn_pesan_dicontrolling = view.findViewById(R.id.pesan_dicontrolling);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        LinearLayout pageBelumTersedia = view.findViewById(R.id.page_belumtersedia);
        LinearLayout pageTersedia = view.findViewById(R.id.sudah_tersedia);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "onDataChange: "+dataSnapshot.getChildrenCount());
                pemesananModelList.clear();
                for (DataSnapshot adSnapshot: dataSnapshot.getChildren()) {
                    pemesananModelList.add(adSnapshot.getValue(PemesananModel.class));
                }
                Log.d(TAG, "no of records of the search is "+pemesananModelList.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        /*if (pemesananModelList.size()>0){
            pageTersedia.setVisibility(View.VISIBLE);
            pageBelumTersedia.setVisibility(View.GONE);
        } else {
            pageTersedia.setVisibility(View.GONE);
            pageBelumTersedia.setVisibility(View.VISIBLE);
        }*/

        btn_pesan_dicontrolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DokterPribadiActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        ViewPagerControlAdapter adapter = new ViewPagerControlAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        toolbar.setTitle("Controlling");

        return view;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.talk);
        tabLayout.getTabAt(1).setIcon(R.drawable.measure);
    }

}
