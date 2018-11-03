package com.example.user.magnant.home.hubungi_dokter;

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
import android.widget.Toast;

import com.example.user.magnant.ClickListener;
import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HubungiDokterActivity extends AppCompatActivity {

    private static final String TAG = "fakuy";

    private RecyclerView recyclerView;
    private List<HubungiModel> dokterList = new ArrayList<>();
    private HubungiDokterAdapter mAdapter ;
    private Toolbar toolbar;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi_dokter);

        progressbar = findViewById(R.id.progress_bar_hubungilist);
        progressbar.setVisibility(View.VISIBLE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("hubungi_dokter");

//        final HubungiModel dokterPush = new HubungiModel("Dr.Agus Putra","3 tahun", 21,75000,"Jln. Telekomunikasi");
//
//        myRef.push().setValue(dokterPush);


        recyclerView = findViewById(R.id.rv_hubungi_dokter);

        mAdapter = new HubungiDokterAdapter(dokterList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                //DokterModel dokter = dokterList.get(position);
                Intent intent = new Intent(getApplicationContext(),PreviewHubungiActivity.class);
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

        toolbar = findViewById(R.id.toolbar_hubungi_dokter);
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
                    HubungiModel dokterModel = adSnapshot.getValue(HubungiModel.class);
                    dokterList.add(adSnapshot.getValue(HubungiModel.class));
                }
                mAdapter.notifyDataSetChanged();
                progressbar.setVisibility(View.GONE);
                Log.d(TAG, "no of records of the search is "+dokterList.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(),"Periksa koneksi internet anda!",Toast.LENGTH_LONG).show();
                progressbar.setVisibility(View.GONE);
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(HubungiDokterActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
