package com.dgaps.android.brasizecalculator2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setVisibility(View.VISIBLE);
        Thread background = new Thread() {
            public void run() {

                try {
                    sleep(1500);
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();

                } catch (Exception e) {

                }
            }
        };

        background.start();

    }


}
