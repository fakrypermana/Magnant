package com.example.user.magnant.home.dokter_pribadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;
import com.example.user.magnant.home.HomeFragment;
import com.example.user.magnant.home.form_pemesanan.FormPemesananActivity;
import com.example.user.magnant.ClickListener;
import com.example.user.magnant.home.form_pemesanan.PemesananModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DokterPribadiActivity extends AppCompatActivity {

    private static final String TAG = "fakuy";

    private RecyclerView recyclerView;
    private List<DokterModel> dokterList = new ArrayList<>();
    private DokterPribadiAdapter mAdapter ;
    private Toolbar toolbar;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter_pribadi);


        /*dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));
        dokterList.add(new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000));*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("dokter");
//        final DokterModel dokterPush = new DokterModel("Dr.Sinta Wijayanti","4 tahun", 21,1500000,"Jln. Telekomunikasi");
//
//        myRef.push().setValue(dokterPush);



        recyclerView = findViewById(R.id.rv_dokter_pribadi);
        progressbar = findViewById(R.id.progressbar);
        progressbar.setVisibility(View.VISIBLE);

        mAdapter = new DokterPribadiAdapter(dokterList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                //DokterModel dokter = dokterList.get(position);
                Intent intent = new Intent(getApplicationContext(),FormPemesananActivity.class);
                intent.putExtra("nama",dokterList.get(position).getNama());
                intent.putExtra("exp",dokterList.get(position).getExp());
                intent.putExtra("pasien",dokterList.get(position).getPasien());
                intent.putExtra("harga",dokterList.get(position).getHarga());
                intent.putExtra("alamat_klinik",dokterList.get(position).getAlamat_klinik());
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);


        //get database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "onDataChange: "+dataSnapshot.getChildrenCount());
                dokterList.clear();
                for (DataSnapshot adSnapshot: dataSnapshot.getChildren()) {
                    DokterModel dokterModel = adSnapshot.getValue(DokterModel.class);
                    Log.d(TAG, "onDataChange: "+dokterModel.getNama());
                    dokterList.add(adSnapshot.getValue(DokterModel.class));
                }
                mAdapter.notifyDataSetChanged();
                Log.d(TAG, "no of records of the search is "+dokterList.size());
                progressbar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DokterPribadiActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
