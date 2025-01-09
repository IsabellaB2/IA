/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IA_CS.models;

/**
 *
 * @author I
 */
public class User {

    private int ID;
    private String username;
    private String password;
    private int type;

    public User ( int ID , String username , String password , int type ) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getID () {
        return ID;
    }

    public void setID ( int ID ) {
        this.ID = ID;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public int getType () {
        return type;
    }

    public void setType ( int type ) {
        this.type = type;
    }
    
    
    
}
