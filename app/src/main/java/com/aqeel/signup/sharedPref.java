package com.aqeel.signup;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public  class sharedPref {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    public Gson gson;

    public sharedPref(Context context)
    {
        sharedPreferences = context.getSharedPreferences("MyAppPref",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        gson =new Gson();
    }
    public void  saveData(ModelUser model)
    {
       /* editor.putString("First Name",model.getFirstName());
        editor.putString("Last Name",model.getLastName());
        editor.putString("Email", model.getEmail());
        editor.putString("Password",model.getPassword());*/
        String userJson=gson.toJson(model);
        editor.putString("user",userJson);
        editor.apply();
    }
    public  ModelUser getData()

    {
       /* String fName=sharedPreferences.getString("First Name","");
        String lName=sharedPreferences.getString("Last Name","");
        String mail=sharedPreferences.getString("Email","");
        String pass=sharedPreferences.getString("Password","");

        return new ModelUser (fName,lName,mail,pass);*/
        String userJson = sharedPreferences.getString("user","");
        if(userJson!=null)
        {
           return gson.fromJson(userJson,ModelUser.class);
        }
        return null;

    }
    public void clearData()

    {
        editor.remove("user");
        editor.apply();
    }

}
