/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.IA_CS.isatest;

import com.IA_CS.database.DBUtil;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme;
import com.github.sarxos.webcam.Webcam;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cameras extends javax.swing.JFrame {

    private LocalDateTime motionStartTime = null;
    private LocalDateTime motionEndTime = null;

    /**
     * Creates new form IA_CS_JFrame
     */
    public Cameras () {
        initComponents ();
        cameraPanel = new CameraPanel ( webcamSelector , webcamView , 512 , 303 );
        camPanel.add ( cameraPanel );
        webcamView.setIcon ( new javax.swing.ImageIcon ( getClass ().getResource ( "/Icons/webcam-256.png" ) ) );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        camPanel = new javax.swing.JPanel();
        webcamView = new javax.swing.JLabel();
        toggleButton = new javax.swing.JButton();
        Webcam[] webcams = Webcam.getWebcams().toArray(new Webcam[0]);
        webcamSelector = new JComboBox<>(webcams);
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMonitoring = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        camPanel.setBackground(new java.awt.Color(40, 40, 40));

        webcamView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout camPanelLayout = new javax.swing.GroupLayout(camPanel);
        camPanel.setLayout(camPanelLayout);
        camPanelLayout.setHorizontalGroup(
            camPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(webcamView, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        camPanelLayout.setVerticalGroup(
            camPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(webcamView, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        toggleButton.setText("Start");
        toggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleButtonActionPerformed(evt);
            }
        });

        /*
        webcamSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        */

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(webcamSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toggleButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(camPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(camPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(webcamSelector)
                    .addComponent(toggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Camera", jPanel1);

        taMonitoring.setColumns(20);
        taMonitoring.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        taMonitoring.setRows(5);
        taMonitoring.setEnabled(false);
        jScrollPane1.setViewportView(taMonitoring);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Event Monitoring", jPanel6);

        jMenu2.setText("File");

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setText("Exit ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit ( 0 );
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void toggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleButtonActionPerformed

        Thread cameraThread = new Thread ( () -> {
            try {
                if ( !cameraPanel.getCameraState () ) {
                    // Start the camera
                    webcamView.setVisible ( true );
                    cameraPanel.toggleWebcam ();
                    webcamView.setText ( "" );
                    toggleButton.setText ( "Stop Camera" );
                    startLoggingProcessWithMotion ();
                }
                else {
                    // Stop the camera and motion detection
                    toggleButton.setText ( "Start Camera" );
                    stopMotionDetection = true;
                    if ( detector != null ) {
                        detector.stop ();
                    }
                    //ensure that the thread responsible for polling stops correctly.
                    if ( motionDetectionThread != null ) {
                        motionDetectionThread.interrupt ();
                    }
                    cameraPanel.stopCamera ();
                    cameraPanel.setCameraState ( false );
                    webcamView.setIcon ( new javax.swing.ImageIcon ( getClass ().getResource ( "/Icons/webcam-256.png" ) ) );
                }
            }
            catch ( NullPointerException e ) {
                JOptionPane.showMessageDialog ( null , "Ops.. Today is my dayoff..... " , "Ops..." , JOptionPane.ERROR_MESSAGE );
            }
        } );
        cameraThread.start ();

    }//GEN-LAST:event_toggleButtonActionPerformed

    private synchronized void startLoggingProcessWithMotion () {
        // Stop any existing motion detector
        if ( detector != null ) {
            detector.stop ();
        }

        stopMotionDetection = false; // Reset stop flag

        Webcam webcam = cameraPanel.getSelectedWebcam ();
        if ( webcam == null ) {
            System.out.println ( "No webcam detected. Please ensure a webcam is connected." );
            return;
        }

        detector = new WebcamMotionDetector ( webcam );
        detector.setInterval ( 1000 ); // Check for motion every 0.6 second

        detector.addMotionListener ( new WebcamMotionListener () {
            @Override
            public void motionDetected ( WebcamMotionEvent wme ) {
                synchronized (Cameras.this) {
                    if ( motionStartTime == null ) {
                        motionStartTime = LocalDateTime.now ();
                        System.out.println ( "Motion started at: " + motionStartTime );
                        taMonitoring.append ( "Motion started at: " + motionStartTime + "\n" );
                    }
                }
            }
        } );

        motionDetectionThread = new Thread ( () -> {
            while ( !stopMotionDetection ) {
                synchronized (Cameras.this) {
                    if ( !detector.isMotion () && motionStartTime != null ) {
                        motionEndTime = LocalDateTime.now ();
                        System.out.println ( "Motion stopped at: " + motionEndTime );
                        taMonitoring.append ( "Motion stopped at: " + motionEndTime + "\n" );
                        handleMotionEvent ();
                        motionStartTime = null; // Reset for next motion detection
                    }
                }

            }
        } );

        motionDetectionThread.start ();
        detector.start ();
        System.out.println ( "Motion detector started." );
    }

    private synchronized void handleMotionEvent () {
        DBUtil db = new DBUtil (); // Database utility instance

        // Ensure both start and end times are set
        if ( motionStartTime != null && motionEndTime != null ) {
            Duration duration = Duration.between ( motionStartTime , motionEndTime ); // Calculate duration
            long minutes = duration.toMinutes (); // Get minutes
            long seconds = duration.toSeconds () % 60; // Get remaining seconds

            // Format start and end times as strings
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss" );
            String startTimeString = motionStartTime.format ( formatter );
            String endTimeString = motionEndTime.format ( formatter );

            // Format duration as a string
            String durationString;
            if ( minutes > 0 ) {
                durationString = minutes + "m" + seconds + "s";
            }
            else {
                durationString = seconds + "s";
            }

            // Print and log the motion duration
            System.out.println ( "Motion duration: " + durationString );
            taMonitoring.append ( "Motion duration: " + durationString + "\n" );

            try {
                // Create event in the database
                if ( minutes > 0 ) {
                    db.createEvent ( startTimeString , endTimeString , durationString );
                    taMonitoring.append ( "Event in DB created\n" );
                }
            }
            catch ( SQLException ex ) {
                Logger.getLogger ( Cameras.class.getName () ).log ( Level.SEVERE , null , ex );
            }
            catch ( ClassNotFoundException ex ) {
                Logger.getLogger ( Cameras.class.getName () ).log ( Level.SEVERE , null , ex );
            }
        }
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Login ().setVisible ( true );
        this.dispose ();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main ( String args[] ) {
        FlatNightOwlIJTheme.setup ();

        java.awt.EventQueue.invokeLater ( new Runnable () {
            public void run () {
                new Cameras ().setVisible ( true );
            }
        } );
    }
    private CameraPanel cameraPanel;

    private WebcamMotionDetector detector;
    private Thread motionDetectionThread;
    private boolean stopMotionDetection = false;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel camPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea taMonitoring;
    private javax.swing.JButton toggleButton;
    private javax.swing.JComboBox<Webcam> webcamSelector;
    private javax.swing.JLabel webcamView;
    // End of variables declaration//GEN-END:variables
}