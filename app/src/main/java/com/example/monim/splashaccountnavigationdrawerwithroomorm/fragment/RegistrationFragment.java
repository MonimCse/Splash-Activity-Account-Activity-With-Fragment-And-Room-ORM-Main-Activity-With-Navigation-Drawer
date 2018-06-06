package com.example.monim.splashaccountnavigationdrawerwithroomorm.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.ICallBack;
import com.example.monim.splashaccountnavigationdrawerwithroomorm.R;

public class RegistrationFragment extends Fragment {

    TextView mTvLoginAccount;

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
        mTvLoginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.replaceLoginFragment();
            }
        });
    }



}
