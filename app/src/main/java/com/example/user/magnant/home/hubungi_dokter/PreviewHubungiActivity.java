package com.example.user.magnant.home.hubungi_dokter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;
import com.example.user.magnant.controlling.konseling.messaging.KonselingMessageActivity;

public class PreviewHubungiActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btn_konfirmasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_hubungi);

        //setup view
        toolbar = findViewById(R.id.toolbar_prev_hubungi_dokter);
        btn_konfirmasi = findViewById(R.id.btn_konfirmasi_bayar);

        //setuplayout
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KonselingMessageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(PreviewHubungiActivity.this, HubungiDokterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
