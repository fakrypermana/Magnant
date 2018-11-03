package com.example.user.magnant.controlling.konseling;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class KonselingRVAdapter extends RecyclerView.Adapter<KonselingRVAdapter.ViewHolder>  {
    private List<KonselingModel> listKonseling ;
    private ClickListener listener;

    public KonselingRVAdapter(List<KonselingModel> listKonseling, ClickListener listener) {
        this.listKonseling = listKonseling;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        private TextView tv_nama_sesi,tv_tgl_sesi,tv_dokter_sesi,tv_isi_sesi;
        private ImageView iv_sesi;
        private CardView cv_konseling;
        private WeakReference<ClickListener> listenerRef;

        public ViewHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);

            listenerRef = new WeakReference<>(listener);
            tv_nama_sesi = itemView.findViewById(R.id.tv_sesi_konseling);
            tv_dokter_sesi = itemView.findViewById(R.id.tv_dokter_konseling);
            tv_tgl_sesi = itemView.findViewById(R.id.tv_tanggal_konseling);
            cv_konseling = itemView.findViewById(R.id.cv_sesi_konseling);

            cv_konseling.setOnClickListener(this);
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
    public KonselingRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_sesi_konseling, viewGroup, false);
        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull KonselingRVAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_nama_sesi.setText(listKonseling.get(i).getNama_konseling());
        viewHolder.tv_dokter_sesi.setText(listKonseling.get(i).getNama_dokter());
        viewHolder.tv_tgl_sesi.setText("2 November 2018");

    }

    @Override
    public int getItemCount() {
        return listKonseling.size();
    }


}
