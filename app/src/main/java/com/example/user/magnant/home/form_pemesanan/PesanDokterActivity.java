package com.example.user.magnant.home.form_pemesanan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.user.magnant.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PesanDokterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText edtNamaPasieb, edtAlamat,edtLamaPesan;
    Button btnNextToPreview;
    private static final String TAG = PesanDokterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_dokter);

        toolbar = findViewById(R.id.toolbar_dokter_datadiri);
        edtAlamat = findViewById(R.id.edt_alamat_pasien);
        edtNamaPasieb = findViewById(R.id.edt_nama_pasien);
        edtLamaPesan = findViewById(R.id.edt_lama_pesanan);
        btnNextToPreview = findViewById(R.id.btn_next_topreview);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                edtLamaPesan.setText(sdf.format(myCalendar.getTime()));
                Log.d(TAG, "updateLabel: "+myCalendar.getTime());
            }

        };

        //open date picker
        edtLamaPesan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(PesanDokterActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //btn next
        btnNextToPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PreviewOrderActivity.class);
                intent.putExtra("Alamat", edtAlamat.getText().toString());
                intent.putExtra("Nama", edtNamaPasieb.getText().toString());
                intent.putExtra("Lama", edtLamaPesan.getText().toString());
                startActivity(intent);
            }
        });

    }


}
