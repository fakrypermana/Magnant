package com.example.user.magnant.emergency;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.magnant.ClickListener;
import com.example.user.magnant.R;

import java.lang.ref.WeakReference;
import java.util.List;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.ViewHolder> {
    private List<EmergencyItem> listE;
    private WeakReference<ClickListener> listenerWeakRef;
    private ClickListener listener;

    public EmergencyAdapter(List<EmergencyItem> listE, ClickListener listener) {
        this.listE = listE;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_list_emergency, viewGroup, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        EmergencyItem listItem = listE.get(i);
        viewHolder.tvHead.setText(listItem.getHead());
        viewHolder.tvDesc.setText(listItem.getDesc());

    }

    @Override
    public int getItemCount() {
        return listE.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvHead, tvDesc;
        public CardView cvEmergency;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            listenerWeakRef = new WeakReference<>(clickListener);

            tvHead = itemView.findViewById(R.id.textViewHead);
            tvDesc = itemView.findViewById(R.id.textViewDesc);
            cvEmergency = itemView.findViewById(R.id.cv_emergence);

            cvEmergency.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listenerWeakRef.get().onPositionClicked(getAdapterPosition());
        }
    }
}
