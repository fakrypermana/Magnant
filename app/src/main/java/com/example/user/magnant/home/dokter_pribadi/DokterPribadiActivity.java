package com.example.user.magnant.home.dokter_pribadi;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.user.magnant.MyApplication;

import com.example.user.magnant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DokterPribadiActivity extends AppCompatActivity {

    private static final String TAG = DokterPribadiActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<DokterModel> dokterList = new ArrayList<>();
    private DokterPribadiAdapter mAdapter;
    private Toolbar toolbar;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter_pribadi);

        dokterList.add(new DokterModel("Dr.Sinta Wijayanti", "3 tahun", 24, 1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti", "3 tahun", 24, 1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti", "3 tahun", 24, 1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti", "3 tahun", 24, 1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti", "3 tahun", 24, 1500000));

        toolbar = findViewById(R.id.toolbar_dokter_pribadi);
        recyclerView = findViewById(R.id.rv_dokter_pribadi);
        setSupportActionBar(toolbar);


        //firebase
        FirebaseDatabase mFirebase = FirebaseDatabase.getInstance();
        mDatabase = mFirebase.getReference("dokter");


        //layout

        mAdapter = new DokterPribadiAdapter(getApplicationContext(),dokterList);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Daftar Dokter");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

    }


    public void getData(){
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot adSnapshot: dataSnapshot.getChildren()) {
                    DokterModel dokter = adSnapshot.getValue(DokterModel.class);
                    Log.d(TAG, "onDataChange: isi dokter"+dokter);
                    dokterList.add(dokter);
                }
                Log.d("magi", "magi"+dokterList.size());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "onCancelled: ", databaseError.toException());
            }
        });
    }

    public void onRecyclerItemClicked(int position){
        DokterModel dokter = dokterList.get(position);
        
    }

}
