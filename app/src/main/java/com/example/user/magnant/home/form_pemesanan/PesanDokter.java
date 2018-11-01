package com.example.user.magnant.home.form_pemesanan;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.user.magnant.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class PesanDokter extends Fragment {

    private Toolbar toolbar;
    private EditText edtNamaPasieb, edtAlamat,edtLamaPesan;
    Button btnNextToPreview;
    private static final String TAG = PesanDokter.class.getSimpleName();

    public PesanDokter() {
        // Required empty public constructor
    }

    public static PesanDokter newInstance(int page, String title) {
        PesanDokter fragmentPesan = new PesanDokter();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentPesan.setArguments(args);
        return fragmentPesan;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_pesan_dokter, container, false);


        edtAlamat = view.findViewById(R.id.edt_alamat_pasien);
        edtNamaPasieb = view.findViewById(R.id.edt_nama_pasien);
        edtLamaPesan = view.findViewById(R.id.edt_lama_pesanan);

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
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //btn next

        return view;
    }

}
