package com.aqeel.signup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
 LottieAnimationView lottieAnimationView;
 Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
       lottieAnimationView=findViewById(R.id.splash_animID);
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               startActivity(new Intent(SplashActivity.this,MainActivity.class));
           }
       },4000);

    }
}