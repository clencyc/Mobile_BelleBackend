package com.home.nature.repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.home.nature.Adapter;
import com.home.nature.dao.PaymentDAO;
import com.home.nature.db.NatureDatabase;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.entity.UserEntity;

import java.util.List;

public class PaymentRepo {
    private PaymentDAO paymentDAO;
    private LiveData<List<PaymentEntity>> allPayments;

    public PaymentRepo(Application application){
        NatureDatabase database = NatureDatabase.getInstance(application);
        paymentDAO = database.paymentDAO();
        allPayments = paymentDAO.getAllPayments();
    }

    public LiveData<List<PaymentEntity>> getAllPayments(){
        return allPayments;
    }

    public void insert(PaymentEntity payment){
        NatureDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                paymentDAO.insert(payment);
            }
        });
    }

    public void update(PaymentEntity payment){
        Log.e("PaymentRepo", "Updating payment: " + payment.toString());
        NatureDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                paymentDAO.update(payment);
            }
        });
    }

    public void delete(PaymentEntity payment){
        NatureDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                paymentDAO.delete(payment);
            }
        });
    }
}
