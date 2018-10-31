package com.example.user.magnant.home.dokter_pribadi;

import android.content.Intent;
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
import com.example.user.magnant.home.form_pemesanan.PesanDokterActivity;
import com.example.user.magnant.profile.ClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DokterPribadiActivity extends AppCompatActivity {

    private static final String TAG = DokterPribadiActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<DokterModel> dokterList = new ArrayList<>();
    private DokterPribadiAdapter mAdapter ;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter_pribadi);

        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));

        recyclerView = findViewById(R.id.rv_dokter_pribadi);
        mAdapter = new DokterPribadiAdapter(dokterList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Intent intent = new Intent(getApplicationContext(),PesanDokterActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClicked(int position) {

            }
        });

                toolbar = findViewById(R.id.toolbar_dokter_pribadi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Daftar Dokter");
        ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);


    }


}
