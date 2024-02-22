package com.home.nature.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.home.nature.dao.PaymentDAO;
import com.home.nature.dao.UserDAO;
import com.home.nature.entity.PaymentEntity;
import com.home.nature.entity.UserEntity;
import com.home.nature.util.DateLongConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserEntity.class, PaymentEntity.class}, version = 1)
@TypeConverters({DateLongConverter.class})
public abstract class NatureDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract PaymentDAO paymentDAO();

    private static volatile NatureDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized NatureDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        NatureDatabase.class, "nature_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
