package com.example.user.magnant.home.dokter_pribadi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.magnant.R;

import java.util.ArrayList;
import java.util.List;

public class DokterPribadiAdapter extends RecyclerView.Adapter<DokterPribadiAdapter.ViewHolder> {
    private Context context;
    private List<DokterModel> listDokter = new ArrayList<>();

    public DokterPribadiAdapter(Context context, List<DokterModel> listDokter) {
        this.context = context;
        this.listDokter = listDokter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama,tv_pengalaman,tv_pasien,tv_harga;
        ImageView iv_dokter;
        CardView cv_dokter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama_dokter);
            tv_pengalaman = itemView.findViewById(R.id.tv_pengalaman);
            tv_pasien = itemView.findViewById(R.id.tv_pasien_tertangani_dokter_pribadi);
            tv_harga = itemView.findViewById(R.id.tv_harga_dokter_pribadi);
            iv_dokter = itemView.findViewById(R.id.iv_dokter_pribadi);
            cv_dokter = itemView.findViewById(R.id.cv_dokter_pribadi);
        }
    }

    @NonNull
    @Override
    public DokterPribadiAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_dokter_pribadi, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
