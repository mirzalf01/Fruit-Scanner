package com.google.firebase.codelab.labelobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void launcScan(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view) {
        finish();
        System.exit(0);
    }

    public void launcMenu(View view) {
        Intent intent = new Intent(this, tentang.class);
        startActivity(intent);
    }
}
