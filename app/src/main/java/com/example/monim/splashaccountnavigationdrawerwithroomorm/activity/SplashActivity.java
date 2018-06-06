package com.example.monim.splashaccountnavigationdrawerwithroomorm.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.monim.splashaccountnavigationdrawerwithroomorm.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, AccountActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
