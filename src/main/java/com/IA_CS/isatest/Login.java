/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.IA_CS.isatest;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme;
import com.IA_CS.database.DBConnection;
import com.IA_CS.database.DBUtil;
import com.IA_CS.manager.FolderManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author I
 */
public class Login extends javax.swing.JFrame {

    FolderManager fm = new FolderManager ();

    /**
     * Creates new form IA_CS_login
     */
    public Login () {
        initComponents ();
        fm.createCoreFilesAndDirectories ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(tfUsername))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfPassword)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DBUtil db = new DBUtil ();
        String username = tfUsername.getText ();
        char[] passwordChar = tfPassword.getPassword ();
        String password = new String ( passwordChar );
        System.out.println ( username + " " + password );// debug output
        
        if (username.isEmpty()){
                JOptionPane.showMessageDialog(this, "ops...wrong ");
                return;
            }
            
        if (password.isEmpty()){
                JOptionPane.showMessageDialog(this, "ops...wrong username ");
        return;    
        }
            
            
        if (username.isEmpty() & password.isEmpty()){
                JOptionPane.showMessageDialog(this, "ops...wrong username and/or ");
        return;    
        }
        
        try {
                    
                       
            int userId = db.getUserIDByLoginCredentials ( username , password );

            if ( db.isAdmin ( userId ) == 0 ) {
                Cameras camWin = new Cameras ();
                camWin.setVisible ( true );
                this.dispose ();
            }
                              
            if ( db.isAdmin ( userId ) == 1 ) {
                Administration adminWin = new Administration ();
                adminWin.setVisible ( true );
                this.dispose ();
            }
                       
            
            if  ( userId  == -1 ) {
                JOptionPane.showMessageDialog(this, "ops...wrong username and/or password");
            }

        }
        catch ( SQLException ex ) {
            Logger.getLogger (Login.class.getName () ).log ( Level.SEVERE , null , ex );
        }
        catch ( ClassNotFoundException ex ) {
            Logger.getLogger (Login.class.getName () ).log ( Level.SEVERE , null , ex );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main ( String args[] ) {
        FlatNightOwlIJTheme.setup ();
        java.awt.EventQueue.invokeLater (new Runnable () {
            public void run () {
                new Login ().setVisible ( true );
            }
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
