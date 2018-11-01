package com.example.user.magnant.home.form_pemesanan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.magnant.R;

public class PreviewOrder extends Fragment {
    private static  final  String TAG = PreviewOrder.class.getSimpleName();
    TextView tv_namaPasien, tv_namaDokter,tv_alamatPasien, tv_alamatKlinik, tv_harga, tv_lamaPemesanan;

    public PreviewOrder() {
        // Required empty public constructor
    }

    public static PreviewOrder newInstance(int page, String title) {
        PreviewOrder fragmentPreview = new PreviewOrder();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentPreview.setArguments(args);
        return fragmentPreview;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preview_order, container, false);

        //setup view
        Intent i = getActivity().getIntent();
        String nama_dokter = i.getStringExtra ( "nama");
        String exp_dokter = i.getStringExtra("exp");
        String pasien = i.getStringExtra("pasien");
        String harga = i.getStringExtra("harga");
        tv_namaPasien = view.findViewById(R.id.tv_nama_pasien);
        tv_namaDokter = view.findViewById(R.id.tv_nama_dokter_preview);
        tv_alamatPasien = view.findViewById(R.id.tv_alamat_preview);
        tv_alamatKlinik = view.findViewById(R.id.tv_alamat_klinik_preview);
        tv_harga = view.findViewById(R.id.tv_harga_dokter_preview);
        tv_lamaPemesanan = view.findViewById(R.id.tv_lama_preview);

        //setup layout
        tv_namaPasien.setText("");
        tv_namaDokter.setText(nama_dokter);
        tv_lamaPemesanan.setText("");
        tv_harga.setText(harga);
        tv_alamatKlinik.setText("");


        // Now set this value to TextView


        return view;
    }

}
