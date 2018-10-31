package com.example.user.magnant.home.dokter_pribadi;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.magnant.R;
import com.example.user.magnant.ClickListener;


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DokterPribadiAdapter extends RecyclerView.Adapter<DokterPribadiAdapter.ViewHolder> {
    private List<DokterModel> listDokter = new ArrayList<>();
    private ClickListener listener;


    public DokterPribadiAdapter(List<DokterModel> listDokter, ClickListener listener) {
        this.listDokter = listDokter;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView tv_nama,tv_pengalaman,tv_pasien,tv_harga;
        private ImageView iv_dokter;
        private CardView cv_dokter;
        private Button btn_pesan,btn_view_more;
        private WeakReference<ClickListener> listenerRef;

        public ViewHolder(@NonNull View itemView,ClickListener listener) {
            super(itemView);

            listenerRef = new WeakReference<>(listener);
            tv_nama = itemView.findViewById(R.id.tv_nama_dokter);
            tv_pengalaman = itemView.findViewById(R.id.tv_pengalaman);
            tv_pasien = itemView.findViewById(R.id.tv_pasien_tertangani_dokter_pribadi);
            tv_harga = itemView.findViewById(R.id.tv_harga_dokter_pribadi);
            iv_dokter = itemView.findViewById(R.id.iv_dokter_pribadi);
            cv_dokter = itemView.findViewById(R.id.cv_dokter_pribadi);

            btn_pesan = itemView.findViewById(R.id.btn_pesan_dokter_pribadi);
            btn_view_more = itemView.findViewById(R.id.btn_view_more_dokter_pribadi);

            btn_pesan.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == btn_pesan.getId()) {
                Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }

            listenerRef.get().onPositionClicked(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {

            return false;
        }
    }

    @NonNull
    @Override
    public DokterPribadiAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_dokter_pribadi, viewGroup, false);
        return new ViewHolder(view,listener);

    }

    @Override
    public void onBindViewHolder(DokterPribadiAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_nama.setText(listDokter.get(i).getNama());
        viewHolder.tv_pengalaman.setText(listDokter.get(i).getExp());
        viewHolder.tv_pasien.setText(String.valueOf(listDokter.get(i).getPasien()));
        viewHolder.tv_harga.setText(String.valueOf(listDokter.get(i).getHarga()));

    }

    @Override
    public int getItemCount() {
        return listDokter.size();
    }


}
