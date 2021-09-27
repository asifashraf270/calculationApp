package com.bitlogicsolution;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView imageView;
    Animation anim;
    Animation text;
    TextView textView;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView = findViewById(R.id.textView);

        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                imageView = findViewById(R.id.imageView);
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashanimation);
                anim.reset();
                imageView.startAnimation(anim);
                text = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.righttoleft);
                text.reset();
                textView.startAnimation(text);
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        };
        thread.start();


    }
}
