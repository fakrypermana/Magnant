package com.example.user.magnant.emergency;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.magnant.R;

import java.util.List;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.ViewHolder> {
    private Context context;
    private List<EmergencyItem> listE;

    public EmergencyAdapter(Context context, List<EmergencyItem> listE) {
        this.context = context;
        this.listE = listE;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_list_emergency, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        EmergencyItem listItem = listE.get(i);
        viewHolder.tvHead.setText(listItem.getHead());
        viewHolder.tvDesc.setText(listItem.getDesc());

        //TODO: Click feature in here
    }

    @Override
    public int getItemCount() {
        return listE.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHead, tvDesc;
        public CardView cvEmergency;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHead = itemView.findViewById(R.id.textViewHead);
            tvDesc = itemView.findViewById(R.id.textViewDesc);
            cvEmergency = itemView.findViewById(R.id.rv_emergency);
        }
    }
}
