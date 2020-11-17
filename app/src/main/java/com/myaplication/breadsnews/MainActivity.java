package com.myaplication.breadsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.myaplication.breadsnews.alarm.AlarmActivity;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView mPengetahuan;
    private MaterialCardView mProfil;
    private MaterialCardView mAlarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mPengetahuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListBatikActivity.class));
            }
        });

        mProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            }
        });

        mAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AlarmActivity.class));
            }
        });
    }

    private void initView() {
        mPengetahuan = (MaterialCardView) findViewById(R.id.cv_pengetahuan);
        mProfil = (MaterialCardView) findViewById(R.id.cv_profil);
        mAlarm= (MaterialCardView) findViewById(R.id.cv_alarm);
    }

}