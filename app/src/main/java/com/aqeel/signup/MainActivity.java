package com.aqeel.signup;

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
     EditText fName,lName,email,password;
    private Button  signUp_btn,login_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fName=findViewById(R.id.f_name_ET);
        lName=findViewById(R.id.L_name_ET);
        email=findViewById(R.id.Email_box);
        password=findViewById(R.id.Password_box);
        signUp_btn=findViewById(R.id.btn_id);
        login_Btn=findViewById(R.id.Login_btn_id);


        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences= getSharedPreferences("MyAppPref",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("first name",fName.getText().toString());
                edit.putString("Last name",lName.getText().toString());
                edit.putString("email",email.getText().toString());
                edit.putString("password",password.getText().toString());
                edit.apply();
                Toast.makeText(MainActivity.this,"Data saved "+fName.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences= getSharedPreferences("MyAppPref",MODE_PRIVATE);
        String first_Name= sharedPreferences.getString("first name","");
        String last_Name= sharedPreferences.getString("Last name","");
        String e_mail= sharedPreferences.getString("email","");
        String pswd= sharedPreferences.getString("password","");

      fName.setText(first_Name);
      lName.setText(last_Name);
      email.setText(e_mail);
      password.setText(pswd);
    }


}