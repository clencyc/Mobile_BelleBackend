package com.home.nature.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.home.nature.dao.UserDAO;
import com.home.nature.db.NatureDatabase;
import com.home.nature.entity.UserEntity;

import java.util.List;

public class UserRepository {
    private UserDAO userDAO;
    private UserEntity loggedInUser;

    public UserRepository(Application application){
        NatureDatabase database = NatureDatabase.getInstance(application);
        userDAO = database.userDAO();

        // check if admin account exists
        UserEntity adminUser = userDAO.getAdminUser();
        if(adminUser == null){
            adminUser = new UserEntity("admin", "admin", "admin@nature.com", 'A', "qazwsx");
            insert(adminUser);
        }
    }

    public UserEntity login(String email, String password){
        loggedInUser = userDAO.login(email, password);
        return loggedInUser;
    }

    private void insert(UserEntity user){
        NatureDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.insert(user);
            }
        });
    }

    public void update(UserEntity user){
        NatureDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.update(user);
            }
        });
    }

    public void delete(UserEntity user){
        NatureDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.delete(user);
            }
        });
    }

    public LiveData<List<UserEntity>> getAllAdmins(){
        return userDAO.getAllAdmins();
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return userDAO.getAllUsers();
    }

}
