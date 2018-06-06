package com.example.monim.splashaccountnavigationdrawerwithroomorm.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.dao.UserDao;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.entitys.User;

@Database(entities ={User.class},version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();

    public static AppDatabase newInstant(Context context)
    {
        return Room.databaseBuilder(context,AppDatabase.class,"user_db").allowMainThreadQueries().build();
    }
}
