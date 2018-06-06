package com.example.monim.splashaccountnavigationdrawerwithroomorm.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.entitys.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from User where email=:email and password=:password")
    boolean checkLogin(String email,String password);

    @Insert
    void insert(User user);

    @Query("Select * from user")
    List<User> getAllUser();

    @Delete
    void delete(User user);
}
