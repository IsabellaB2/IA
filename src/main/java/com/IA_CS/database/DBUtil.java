/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IA_CS.database;

import com.IA_CS.models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
public class DBUtil extends DBConnection {

     

    public DBUtil () {
    }


    public int isAdmin ( int ID ) throws SQLException , ClassNotFoundException {
        Statement statement = getConnection ().createStatement ();
        ResultSet resultSet = statement.executeQuery ( "SELECT type FROM Users WHERE ID = " + ID );
        int isAdmin = 3;
        while ( resultSet.next () ) {
            isAdmin = resultSet.getInt ( "type" );
        }
        closeConnection ();
        return isAdmin;
    }
    
    public void deleteUser ( int ID ) throws SQLException , ClassNotFoundException {
        String query = "DELETE FROM Users WHERE ID = " + ID ; 
        
        Statement statement = getConnection ().createStatement ();
        statement.executeUpdate ( query );

        closeConnection ();
         
    }

    public int getUserIDByLoginCredentials ( String name , String password ) throws SQLException , ClassNotFoundException {
        Statement statement = getConnection ().createStatement ();

        ResultSet resultSet = statement.executeQuery ( "SELECT ID FROM Users WHERE username = '" + name + "' AND password = '" + password + "'" );
        int id = -1;
        while ( resultSet.next () ) {
            id = resultSet.getInt ( "ID" );
        }
        closeConnection ();
        return id;
    }

    public void createEvent ( String startTime , String endTime, String duration  ) throws SQLException , ClassNotFoundException {
        String insertQuery = "INSERT INTO Events (Start, End, Duration) VALUES (?, ?, ?)";
        try ( PreparedStatement pstmt = getConnection ().prepareStatement ( insertQuery ) ) {
            pstmt.setString ( 1 , startTime );
            pstmt.setString ( 2 , endTime );
            pstmt.setString ( 3 , duration );
            pstmt.executeUpdate ();
        }
        finally {
            closeConnection ();
        }
    }
    
    
        public void createUser ( String username , String password, int type  ) throws SQLException , ClassNotFoundException {
        String insertQuery = "INSERT INTO Users (username, password, type) VALUES (?, ?, ?)";
        try ( PreparedStatement pstmt = getConnection ().prepareStatement ( insertQuery ) ) {
            pstmt.setString ( 1 , username );
            pstmt.setString ( 2 , password );
            pstmt.setInt ( 3 , type );
            pstmt.executeUpdate ();
        }
        finally {
            closeConnection ();
        }
    }
        
        public ArrayList getAllUsers () throws SQLException , ClassNotFoundException {
        Statement statement = getConnection ().createStatement ();
        ResultSet resultSet = statement.executeQuery ( "SELECT ID, username, password, type FROM Users" );

        ArrayList<User> userList = new ArrayList<User> ();
        User user;
      
        while ( resultSet.next () ) {

            user = new User ( resultSet.getInt ( "ID" ) ,
                    resultSet.getString ( "username" ) ,
                    resultSet.getString ( "password" ) ,
                    resultSet.getInt ( "type" ) );

            userList.add ( user );
        }
        closeConnection ();

        return userList;
    }
}

