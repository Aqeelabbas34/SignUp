package com.aqeel.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     EditText fNameET,lNameET,emailET,passwordET;
     Button  signUp_btn,login_Btn;
     sharedPref sharedPref;
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

        sharedPref =new sharedPref(this);
        signUp_btn.setOnClickListener(view -> {
            String f_name= fNameET.getText().toString();
            String l_name=lNameET.getText().toString();
            String mail=emailET.getText().toString();
            String password= passwordET.getText().toString();
            ModelUser modelUser=new ModelUser(f_name,l_name,mail,password);
            sharedPref.saveData(modelUser);
            Toast.makeText(MainActivity.this,"Data saved"  ,Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        });
       login_Btn.setOnClickListener(view -> {

           Intent intent =new Intent(MainActivity.this,LoginActivity.class);
           startActivity(intent);
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