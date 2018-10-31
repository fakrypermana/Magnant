package com.example.user.magnant.home.dokter_pribadi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Button btn_pesan,btn_view_more;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama_dokter);
            tv_pengalaman = itemView.findViewById(R.id.tv_pengalaman);
            tv_pasien = itemView.findViewById(R.id.tv_pasien_tertangani_dokter_pribadi);
            tv_harga = itemView.findViewById(R.id.tv_harga_dokter_pribadi);
            iv_dokter = itemView.findViewById(R.id.iv_dokter_pribadi);
            cv_dokter = itemView.findViewById(R.id.cv_dokter_pribadi);
            btn_pesan = itemView.findViewById(R.id.btn_pesan_dokter_pribadi);
            btn_view_more = itemView.findViewById(R.id.btn_view_more_dokter_pribadi);
        }
    }

    @NonNull
    @Override
    public DokterPribadiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_dokter_pribadi, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DokterPribadiAdapter.ViewHolder viewHolder, int i) {
        /*viewHolder.tv_nama.setText("dfsdgasdg");
        viewHolder.tv_pengalaman.setText("gfdgsdgdfg");
        viewHolder.tv_pasien.setText(String.valueOf("gfdgsdfgdsf"));
        viewHolder.tv_harga.setText(String.valueOf("gdsfgdsfg"));
*/
        viewHolder.tv_nama.setText(listDokter.get(i).getNama());
        viewHolder.tv_pengalaman.setText(listDokter.get(i).getExp());
        viewHolder.tv_pasien.setText(String.valueOf(listDokter.get(i).getPasien()));
        viewHolder.tv_harga.setText(String.valueOf(listDokter.get(i).getHarga()));

        //btn listener
        viewHolder.btn_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.btn_view_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listDokter.size();
    }


}
