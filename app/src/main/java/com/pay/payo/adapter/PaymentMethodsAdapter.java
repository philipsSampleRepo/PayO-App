package com.pay.payo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pay.payo.R;
import com.pay.payo.model.ApplicableItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentMethodsAdapter extends RecyclerView.Adapter
        <PaymentMethodsAdapter.PaymentViewHolder> {
    private final static String TAG = PaymentMethodsAdapter.class.getSimpleName();
    private List<ApplicableItem> applicableItems = new ArrayList<>();
    private OnItemClickedListener listener;

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,
                false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        ApplicableItem applicableItem = applicableItems.get(position);
        if (applicableItem != null) {
            holder.tv_networkName.setText(applicableItem.getLabel());
            Glide.with(holder.imageView.getContext())
                    .load(applicableItem.getLinks().getLogo())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return applicableItems.size();
    }

    public class PaymentViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_networkName;
        private ImageView imageView;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_networkName = itemView.findViewById(R.id.tv_network_name);
            imageView = itemView.findViewById(R.id.imgview_cardart);
            setOnClickListener(itemView);
        }

        private void setOnClickListener(View view) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Item clicked...");
                    int itemPosition = getAdapterPosition();
                    if (listener != null && RecyclerView.NO_POSITION != itemPosition) {
                        listener.onItemClicked(applicableItems.get(itemPosition));
                    }
                }
            });
        }
    }

    public interface OnItemClickedListener {
        void onItemClicked(ApplicableItem applicableItem);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        listener = onItemClickedListener;
    }

    public void setPaymentMethods(List<ApplicableItem> items) {
        applicableItems = items;
        notifyDataSetChanged();
    }
}
