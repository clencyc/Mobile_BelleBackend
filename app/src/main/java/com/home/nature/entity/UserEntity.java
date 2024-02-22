package com.home.nature.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int userID;

    @NonNull
    @ColumnInfo(name = "firstname")
    private String firstName;

    @NonNull
    @ColumnInfo(name = "lastname")
    private String lastName;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "accountType")
    private Character accountType;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    public UserEntity(@NonNull String firstName, @NonNull String lastName, @NonNull String email, Character accountType, @NonNull String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountType = accountType;
        this.password = password;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public Character getAccountType() {
        return accountType;
    }

    public void setAccountType(Character accountType) {
        this.accountType = accountType;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
