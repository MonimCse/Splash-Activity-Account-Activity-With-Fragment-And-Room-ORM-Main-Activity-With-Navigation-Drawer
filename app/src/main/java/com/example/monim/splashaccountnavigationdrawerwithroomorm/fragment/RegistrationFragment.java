package com.example.monim.splashaccountnavigationdrawerwithroomorm.fragment;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.ICallBack;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.R;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.AppDatabase;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.db.entitys.User;

import java.util.List;

public class RegistrationFragment extends Fragment {

    TextView mTvLoginAccount;
    Button mBtnRegistration;

    EditText mEdtName;
    EditText mEdtEmail;
    EditText mEdtPassword;
    EditText mEdtPhone;
    User user = new User();

    @SuppressLint("ValidFragment")
    private RegistrationFragment()
    {

    }

    static ICallBack mCallback;
    public static RegistrationFragment newInstant(ICallBack callback)
    {
        mCallback = callback;
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.fragment_registration,viewGroup,false);
        init(view);
        return view;
    }
    private void init(View view)
    {
        mTvLoginAccount = view.findViewById(R.id.tv_login_account);
        mBtnRegistration = view.findViewById(R.id.btn_registration);

        mEdtEmail = view.findViewById(R.id.edt_email);
        mEdtName = view.findViewById(R.id.edt_name);
        mEdtPassword = view.findViewById(R.id.edt_password);
        mEdtPhone = view.findViewById(R.id.edt_phone);

        mTvLoginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.replaceLoginFragment();
            }
        });
        mBtnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setPhoneNo(mEdtPhone.getText().toString());
                user.setEmail(mEdtEmail.getText().toString());
                user.setName(mEdtName.getText().toString());
                user.setPassword(mEdtPassword.getText().toString());
                mCallback.registration(user);
            }
        });

        AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();





    }



}
