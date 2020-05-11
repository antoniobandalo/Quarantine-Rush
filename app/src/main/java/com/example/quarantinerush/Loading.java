package com.example.quarantinerush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Loading extends AppCompatActivity {

    private static int SPLASH_SCREEN_INT = 3000;

    private ProgressBar mProgressBar;

    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(new Runnable(){

            public void run(){
                Intent homeIntent = new Intent(Loading.this, Introduction.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_SCREEN_INT);

        mProgressBar = (ProgressBar) findViewById(R.id.loadingBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(30);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }
}
