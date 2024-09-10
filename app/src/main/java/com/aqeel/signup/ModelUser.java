package com.aqeel.signup;

public class ModelUser {
    String firstName,lastName,email,password;
    public ModelUser(String f_name,String l_name,String mail,String pass)
    {
        this.firstName=f_name;
        this.lastName=l_name;
        this.email=mail;
        this.password=pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
