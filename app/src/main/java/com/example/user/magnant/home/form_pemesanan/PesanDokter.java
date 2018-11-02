package com.example.user.magnant.home.form_pemesanan;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.user.magnant.R;
import com.example.user.magnant.home.DetailModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class PesanDokter extends Fragment {

    private Toolbar toolbar;
    private EditText edtNamaPasien, edtAlamat,edtLamaPesan;
    Button btnAddDataDiri;
    private static final String TAG = PesanDokter.class.getSimpleName();

    //send data fragment to fragment
    SendData SD;

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


        btnAddDataDiri = view.findViewById(R.id.btn_addDataDiri);
        edtAlamat = view.findViewById(R.id.edt_alamat_pasien);
        edtNamaPasien = view.findViewById(R.id.edt_nama_pasien);
        edtLamaPesan = view.findViewById(R.id.edt_lama_pesanan);

        //adddata
        btnAddDataDiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailModel detailModel = new DetailModel(edtNamaPasien.getText().toString().trim(),
                        edtAlamat.getText().toString().trim(),Integer.parseInt(edtLamaPesan.getText().toString().trim()));
                SD.sendData(detailModel);


            }
        });

        edtLamaPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        //btn next

        return view;
    }

    private void show() {
        final Dialog d = new Dialog(getActivity());
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button b1 = d.findViewById(R.id.buttonSet);
        Button b2 = d.findViewById(R.id.buttonCancel);
        final NumberPicker np = d.findViewById(R.id.numberPickerBulan);
        np.setMaxValue(10);
        np.setMinValue(1);
        np.setWrapSelectorWheel(false);
//        np.setOnValueChangedListener();
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                edtLamaPesan.setText(String.valueOf(np.getValue()));
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }

    interface SendData {
        void sendData(DetailModel detail);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SD = (SendData) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

}
