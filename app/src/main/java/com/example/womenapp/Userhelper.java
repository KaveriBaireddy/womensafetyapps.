package com.example.womenapp;

public class Userhelper {
    String user,number,place,email,pass;
    public Userhelper()
    {
    }
    public Userhelper(String user, String number, String place, String email, String pass)
    {
        this.user=user;
        this.number=number;
        this.place=place;
        this.email=email;
        this.pass=pass;
    }
    public String getUser()
    {
        return user;
    }
    public void setUser(String user)
    {
        this.user=user;
    }
    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number=number;
    }
    public String getPlace()
    {
        return place;
    }
    public void setPlace(String place)
    {
        this.place=place;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getPass()
    {
        return pass;
    }
    public void setPass(String pass)
    {
        this.pass=pass;
    }
}
