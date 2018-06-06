package com.example.monim.splashaccountnavigationdrawerwithroomorm;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.entitys.User;

public interface ICallBack {

    void replaceLoginFragment();

    void replaceRegistrationFragment();

    void login(String email,String password);

    void registration(User user);
}
