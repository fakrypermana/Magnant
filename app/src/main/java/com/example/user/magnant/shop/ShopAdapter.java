package com.example.user.magnant.shop;

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
import com.example.user.magnant.home.dokter_pribadi.DokterPribadiAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context mContext;
    private List<ObatModel> listObat= new ArrayList<>();

    public ShopAdapter(Context mContext, List<ObatModel> listObat) {
        this.mContext = mContext;
        this.listObat = listObat;
    }

    @Override
    public int getItemCount() {
        return listObat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama,tv_harga;
        ImageView iv_obat;
        CardView cv_obat;
        Button btn_pesan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama_obat);
            tv_harga = itemView.findViewById(R.id.tv_harga_obat);
            iv_obat = itemView.findViewById(R.id.iv_obat);
            cv_obat = itemView.findViewById(R.id.cv_obat);
            btn_pesan = itemView.findViewById(R.id.btn_pesan_obat);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_shop, viewGroup, false);
        return new ShopAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv_nama.setText(listObat.get(i).getNama());
        viewHolder.tv_harga.setText(String.valueOf(listObat.get(i).getHarga()));
    }


}
