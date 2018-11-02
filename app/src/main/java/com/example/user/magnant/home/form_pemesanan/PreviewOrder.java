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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;
import com.example.user.magnant.controlling.ControlFragment;
import com.example.user.magnant.home.DetailModel;
import com.example.user.magnant.home.dokter_pribadi.DokterModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PreviewOrder extends Fragment {
    private static  final  String TAG = "previeworder";
    TextView tv_namaPasien, tv_namaDokter,tv_alamatPasien, tv_alamatKlinik,
            tv_harga, tv_lamaPemesanan, tv_TotalBayar;
    Button btn_lanjut_pembayaran;
    DetailModel detailModel;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pemesanan");

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
//        Intent i = getActivity().getIntent();
//        String nama_dokter = i.getStringExtra ( "nama");
//        String exp_dokter = i.getStringExtra("exp");
//        int pasien = i.getIntExtra("pasien",0);
//        double harga = i.getDoubleExtra("harga",0);
//        Log.d(TAG, "onCreateView: "+harga);


        btn_lanjut_pembayaran = view.findViewById(R.id.btn_toPesanPay);

        tv_namaPasien = view.findViewById(R.id.tv_nama_pasien);
        tv_namaDokter = view.findViewById(R.id.tv_nama_dokter_preview);
        tv_alamatPasien = view.findViewById(R.id.tv_alamat_preview);
        tv_alamatKlinik = view.findViewById(R.id.tv_alamat_klinik_preview);
        tv_harga = view.findViewById(R.id.tv_harga_dokter_preview);
        tv_lamaPemesanan = view.findViewById(R.id.tv_lama_preview);
        tv_TotalBayar = view.findViewById(R.id.tv_harga_total_dokter_preview);

        //setup layout
        btn_lanjut_pembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_namaDokter.equals("") && tv_alamatPasien.equals("")&& tv_namaPasien.equals("") && tv_lamaPemesanan.equals("")){
                    Toast.makeText(v.getContext(), "Data belum lengkap ", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(getActivity(), PembayaranActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });

        return view;
    }


    protected void displayReceivedData(DetailModel detailModel)
    {
        Intent i = getActivity().getIntent();
        String nama_dokter = i.getStringExtra ( "nama");
//        String exp_dokter = i.getStringExtra("exp");
//        int pasien = i.getIntExtra("pasien",0);
        double harga = i.getDoubleExtra("harga",0);
        String klinik = i.getStringExtra("alamat_klinik");
        double total_bayar = harga*detailModel.getLamaPesan();

        tv_namaPasien.setText(detailModel.getNama());
        tv_alamatPasien.setText(detailModel.getAlamat());
        tv_lamaPemesanan.setText(String.valueOf(detailModel.getLamaPesan()));
        tv_namaDokter.setText(nama_dokter);
        tv_harga.setText(String.valueOf(harga));
        tv_alamatKlinik.setText(klinik);
        tv_TotalBayar.setText(String.format("%.2f", total_bayar));

        PemesananModel pemesananPush = new PemesananModel(detailModel.getNama(),detailModel.getAlamat(),detailModel.getLamaPesan(),nama_dokter,klinik,harga,total_bayar);
        myRef.push().setValue(pemesananPush);
        Toast.makeText(getContext(), "Data telah ditambahkan ", Toast.LENGTH_SHORT).show();
    }


}
