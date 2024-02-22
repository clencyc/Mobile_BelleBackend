package com.home.nature;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.home.nature.entity.PaymentEntity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdpterVH>{
    private List<PaymentEntity> paymentList;

//    public Adapter(List<PaymentEntity> paymentList) {
//        this.paymentList = paymentList;
//    }
    public void setPaymentList(List<PaymentEntity> paymentList) {
        this.paymentList = paymentList;
        notifyDataSetChanged(); // Notify RecyclerView that data has changed
    }

    public Adapter() {
    }

    @NonNull
    @Override
    public AdpterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdpterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdpterVH holder, int position) {
        PaymentEntity item = paymentList.get(position);
        String message= "";
        String amount = "";
        String nameInitials = String.format("%s%s", item.getFirstName().toUpperCase().charAt(0), item.getLastName().toUpperCase().charAt(0));
        if(item.getTransactionType().equals('S')){
            holder.userName.setBackgroundResource(R.drawable.sent_name_initials_bg);
            message = String.format("Payment To %s %s", item.getFirstName(), item.getLastName());
            amount  = String.format("-$%.2f", item.getAmount());
        }else if(item.getTransactionType().equals('R')){
            holder.userName.setBackgroundResource(R.drawable.received_name_initials_bg);
            message = String.format("Payment From %s %s", item.getFirstName(), item.getLastName());
            amount  = String.format("+$%.2f", item.getAmount());
        }

        holder.userName.setText(nameInitials);
        holder.message.setText(message);
        holder.amount.setText(amount);
    }

    @Override
    public int getItemCount() {
        return paymentList != null ? paymentList.size() : 0;
//        return paymentList.size();
    }

    public static class AdpterVH extends RecyclerView.ViewHolder{
        TextView userName, message, amount;
        public AdpterVH(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.item_name_intials);
            message = itemView.findViewById(R.id.item_pay_desc);
            amount = itemView.findViewById(R.id.item_pay_amount);
        }
    }
}
