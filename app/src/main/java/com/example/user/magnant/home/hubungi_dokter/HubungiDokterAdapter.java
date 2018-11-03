package com.example.user.magnant.home.hubungi_dokter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.magnant.ClickListener;
import com.example.user.magnant.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class HubungiDokterAdapter extends RecyclerView.Adapter<HubungiDokterAdapter.ViewHolder> {
    private List<HubungiModel> listDokter = new ArrayList<>();
    private ClickListener listener;


    public HubungiDokterAdapter(List<HubungiModel> listDokter, ClickListener listener) {
        this.listDokter = listDokter;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView tv_nama,tv_pengalaman,tv_pasien,tv_harga;
        private ImageView iv_dokter;
        private CardView cv_dokter;
        private Button btn_pesan,btn_view_more;
        private WeakReference<ClickListener> listenerRef;

        public ViewHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);

            listenerRef = new WeakReference<>(listener);
            tv_nama = itemView.findViewById(R.id.tv_nama_hubungi);
            tv_pengalaman = itemView.findViewById(R.id.tv_pengalaman_hubungi_dokter);
            tv_pasien = itemView.findViewById(R.id.tv_pasien_tertangani_hubungi_dokter);
            tv_harga = itemView.findViewById(R.id.tv_harga_hubungi_dokter);
            iv_dokter = itemView.findViewById(R.id.iv_hubungi_dokter);
            cv_dokter = itemView.findViewById(R.id.cv_hubungi_dokter);

            btn_pesan = itemView.findViewById(R.id.btn_pesan_dokter_pribadi);
            btn_view_more = itemView.findViewById(R.id.btn_view_more_dokter_pribadi);

            btn_pesan.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listenerRef.get().onPositionClicked(getAdapterPosition());

        }

        @Override
        public boolean onLongClick(View v) {

            return false;
        }
    }

    @NonNull
    @Override
    public HubungiDokterAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_hubungi_dokter, viewGroup, false);
        return new ViewHolder(view,listener);

    }

    @Override
    public void onBindViewHolder(HubungiDokterAdapter.ViewHolder viewHolder, int i) {
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
