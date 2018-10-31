package com.example.user.magnant.home.dokter_pribadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.user.magnant.R;
import com.example.user.magnant.home.form_pemesanan.PesanDokterActivity;
import com.example.user.magnant.ClickListener;

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
                DokterModel dokter = dokterList.get(position);
                Intent intent = new Intent(getApplicationContext(),PesanDokterActivity.class);
                intent.putExtra("nama","Dr. Sinta Wijayanti");
                intent.putExtra("exp","4 tahun");
                intent.putExtra("pasien","1500000");
                intent.putExtra("harga","1500000");
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
