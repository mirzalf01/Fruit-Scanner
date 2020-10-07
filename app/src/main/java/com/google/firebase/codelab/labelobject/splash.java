package com.google.firebase.codelab.labelobject;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    private int waktu_loading=1500;

    //2000=2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(splash.this, menu.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}
