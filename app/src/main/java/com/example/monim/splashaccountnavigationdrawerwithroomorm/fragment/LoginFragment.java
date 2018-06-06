package com.example.monim.splashaccountnavigationdrawerwithroomorm.fragment;

import android.annotation.SuppressLint;
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

public class LoginFragment extends Fragment {


    TextView mTvCreateAccount;
    EditText mEdtEmail;
    EditText mEdtPassword;
    Button mBtnLogin;
    @SuppressLint("ValidFragment")
    private LoginFragment()
    {

    }

    static ICallBack mCallback;
    public static LoginFragment newInstant(ICallBack callback)
    {
        mCallback = callback;
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_login, viewGroup, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mTvCreateAccount = view.findViewById(R.id.tv_create_account);
        mTvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.replaceRegistrationFragment();
            }
        });

        mEdtEmail = view.findViewById(R.id.edt_email);
        mEdtPassword = view.findViewById(R.id.edt_password);
        mBtnLogin = view.findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.login(mEdtEmail.getText().toString(),mEdtPassword.getText().toString());
            }
        });
    }


}
