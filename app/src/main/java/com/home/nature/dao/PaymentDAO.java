package com.home.nature.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.home.nature.entity.PaymentEntity;

import java.util.List;

@Dao
public interface PaymentDAO {
    @Insert
    void insert(PaymentEntity payment);

    @Update
    void update(PaymentEntity payment);

    @Delete
    void delete(PaymentEntity payment);

    @Query("SELECT * FROM `transaction`")
    LiveData<List<PaymentEntity>> getAllPayments();
}
