package com.example.kholoud.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    Button subLogin;
    Animation frombutton, fromtop;
    Button subRegister;
    ImageView image;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        image = (ImageView) findViewById(R.id.Move_man);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromright);
        image.setAnimation(fromtop);

        progressBar = (ProgressBar) findViewById(R.id.progresspar);

        progressBar.setMax(100);
        progressBar.setProgress(0);
        final Thread thread = new Thread() {


            @Override
            public void run() {
                try {
                    for (int i=0;i<100;i++)
                    {
                        progressBar.setProgress(i);
                        sleep(20);
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
thread.start();

    }
}