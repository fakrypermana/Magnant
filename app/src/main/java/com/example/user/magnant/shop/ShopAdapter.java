package com.example.user.magnant.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        ImageButton btn_tambah;
        ImageButton btn_kurang;
        LinearLayout ly_buy;
        LinearLayout ly_sum;
        TextView ed_jum_obat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama_obat);
            tv_harga = itemView.findViewById(R.id.tv_harga_obat);
            iv_obat = itemView.findViewById(R.id.iv_obat);
            cv_obat = itemView.findViewById(R.id.cv_obat);
            btn_pesan = itemView.findViewById(R.id.btn_pesan_obat);
            btn_tambah = itemView.findViewById(R.id.btn_pesan_tambah);
            btn_kurang = itemView.findViewById(R.id.btn_pesan_kurang);
            ly_sum = itemView.findViewById(R.id.ly_sum);
            ly_buy = itemView.findViewById(R.id.ly_buy);
            ed_jum_obat = itemView.findViewById(R.id.jum_obat);
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.tv_nama.setText(listObat.get(i).getNama());
        viewHolder.tv_harga.setText(String.valueOf(listObat.get(i).getHarga()));
        viewHolder.btn_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.ly_buy.setVisibility(View.GONE);
                viewHolder.ly_sum.setVisibility(View.VISIBLE);
                viewHolder.ed_jum_obat.setText("1");
            }
        });
        viewHolder.btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.ed_jum_obat.getText().toString().equals("1")){
                    viewHolder.ly_sum.setVisibility(View.GONE);
                    viewHolder.ly_buy.setVisibility(View.VISIBLE);
                    viewHolder.ed_jum_obat.setText("0");
                }else{
                    viewHolder.ed_jum_obat.setText(String.valueOf(Integer.parseInt(viewHolder.ed_jum_obat.getText().toString().trim())-1));
                }
            }
        });
        viewHolder.btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.ed_jum_obat.setText(String.valueOf(Integer.parseInt(viewHolder.ed_jum_obat.getText().toString().trim())+1));
            }
        });


    }


}
