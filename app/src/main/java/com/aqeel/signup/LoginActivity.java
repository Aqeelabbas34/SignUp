package com.aqeel.signup;

import android.app.Dialog;
import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

     EditText enteredEmail,enteredPassword;
     Button loginBtn,signUpBtn;
     sharedPref sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);
        enteredEmail=findViewById(R.id.Email_ET);
        enteredPassword=findViewById(R.id.Password_ET);
        signUpBtn=findViewById(R.id.SignUP_btn_id);
        loginBtn=findViewById(R.id.login_btn_id);
        sharedPreference=new sharedPref(this);
        Handler handler=new Handler();

        loginBtn.setOnClickListener(view -> {

            ModelUser modelUser=  sharedPreference.getData();
            String email=modelUser.email;
            String password=modelUser.password;
            userAuth(email,password);



        });

    }
    void userAuth(String email, String password) {
        String mail = enteredEmail.getText().toString();
        String pass = enteredPassword.getText().toString();

        if (mail.equals(email) && pass.equals(password)) {
            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
            startActivity(intent);
        } else if (mail.equals(email) && !pass.equals(password)) {
            enteredPassword.setError("wrong password");
        } else if (!mail.equals(email) && pass.equals(password)) {
            enteredEmail.setError("wrong email");
        } else {
            Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

}