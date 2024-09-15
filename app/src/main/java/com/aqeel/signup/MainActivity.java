package com.aqeel.signup;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
     EditText fNameET,lNameET,emailET,passwordET;
     Button  signUp_btn,login_Btn;
     sharedPref sharedPref;
     LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fNameET=findViewById(R.id.f_name_ET);
        lNameET=findViewById(R.id.L_name_ET);
        emailET=findViewById(R.id.Email_box);
        passwordET=findViewById(R.id.Password_box);
        signUp_btn=findViewById(R.id.btn_id);
        login_Btn=findViewById(R.id.Login_btn_id);

        Handler handler=new Handler();

        sharedPref =new sharedPref(this);
        signUp_btn.setOnClickListener(view -> {
            Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.animation_view);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
            String f_name= fNameET.getText().toString();
            String l_name=lNameET.getText().toString();
            String mail=emailET.getText().toString();
            String password= passwordET.getText().toString();
            ModelUser modelUser=new ModelUser(f_name,l_name,mail,password);
            sharedPref.saveData(modelUser);
            handler.postDelayed(() -> {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"Data saved"  ,Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            },3000);


        });
       login_Btn.setOnClickListener(view -> {
           Dialog dialog=new Dialog(MainActivity.this);
           dialog.setContentView(R.layout.animation_view);
           dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
           setVisible(true);
           dialog.show();
           handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   dialog.dismiss();
                   Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                   startActivity(intent);



               }
           },2000);

       });



    }

    @Override
    protected void onResume() {
        super.onResume();
        ModelUser modelUser=sharedPref.getData();
        if(modelUser!=null)
        {
            fNameET.setText(modelUser.getFirstName());
            lNameET.setText(modelUser.getLastName());
            emailET.setText(modelUser.getEmail());
            passwordET.setText(modelUser.getPassword());
        }
    }



}