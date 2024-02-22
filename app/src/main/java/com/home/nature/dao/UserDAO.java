package com.home.nature.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.home.nature.entity.UserEntity;
import com.home.nature.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    UserEntity login(String email, String password);

    @Insert
    void insert(UserEntity user);

    @Update
    void update(UserEntity user);

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM user WHERE accountType = 'A'")
    UserEntity getAdminUser();

    @Query("SELECT * FROM user WHERE accountType = 'A'")
    LiveData<List<UserEntity>> getAllAdmins();

    @Query("SELECT * FROM user WHERE accountType = 'U'")
    LiveData<List<UserEntity>> getAllUsers();

}
