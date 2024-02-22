package com.home.nature.admin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.home.nature.R;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.repo.PaymentRepo;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdpterAVH> {
    private List<PaymentEntity> allPayments;
    private Context mContext;

    public void setPaymentList(List<PaymentEntity> paymentList) {
        this.allPayments = paymentList;
        notifyDataSetChanged(); // Notify RecyclerView that data has changed
    }

    public Adapter(Context c) {
        this.mContext = c;
    }

    @NonNull
    @Override
    public AdpterAVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdpterAVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trans_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdpterAVH holder, int position) {
        PaymentEntity item = allPayments.get(position);

        String message= "";
        String amount = "";
        String nameInitials = String.format("%s%s", item.getFirstName().toUpperCase().charAt(0), item.getLastName().toUpperCase().charAt(0));
        if(item.getTransactionType().equals('S')){
            holder.nameInitials.setBackgroundResource(R.drawable.sent_name_initials_bg);
            message = String.format("Payment To %s %s", item.getFirstName(), item.getLastName());
            amount  = String.format("-$%.2f", item.getAmount());
        }else if(item.getTransactionType().equals('R')){
            holder.nameInitials.setBackgroundResource(R.drawable.received_name_initials_bg);
            message = String.format("Payment From %s %s", item.getFirstName(), item.getLastName());
            amount  = String.format("+$%.2f", item.getAmount());
        }

        holder.nameInitials.setText(nameInitials);
        holder.desc.setText(message);
        holder.amount.setText(amount);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UpdateTrans.class);
                intent.putExtra("payment", item);
                view.getContext().startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePayment(item);
                Toast.makeText(mContext, "Payment deleted.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deletePayment(PaymentEntity payment){
        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentRepo repo = new PaymentRepo(((Activity) mContext).getApplication());
                repo.delete(payment);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return allPayments != null ? allPayments.size() : 0;
        //return allPayments.size();
    }

    public class AdpterAVH extends RecyclerView.ViewHolder{
         TextView nameInitials, desc, amount;
         ImageView edit, delete;
         public AdpterAVH(@NonNull View itemView) {
             super(itemView);

             nameInitials = itemView.findViewById(R.id.trans_intials);
             desc = itemView.findViewById(R.id.trans_desc);
             amount = itemView.findViewById(R.id.trans_amount);
             edit = itemView.findViewById(R.id.trans_edit);
             delete = itemView.findViewById(R.id.trans_delete);
         }
     }

}
