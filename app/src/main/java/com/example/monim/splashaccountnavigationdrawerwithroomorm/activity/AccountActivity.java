package com.example.monim.splashaccountnavigationdrawerwithroomorm.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.ICallBack;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.R;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.AppDatabase;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.entitys.User;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.fragment.LoginFragment;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.fragment.RegistrationFragment;

public class AccountActivity extends AppCompatActivity implements ICallBack {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        db = AppDatabase.newInstant(getApplicationContext());
        replaceLoginFragment();

    }

    private void initFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void replaceLoginFragment() {
        initFragment(LoginFragment.newInstant(this));
    }

    @Override
    public void replaceRegistrationFragment() {
        initFragment(RegistrationFragment.newInstant(this));
    }

    @Override
    public void login(String email, String password) {
        boolean isLogin = db.userDao().checkLogin(email, password);
    }

    @Override
    public void registration(User user) {
        db.userDao().insert(user);
    }


}
