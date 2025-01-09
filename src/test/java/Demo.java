/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kyrka
 */

import com.IA_CS.config.Settings;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author stefz
 */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
    private static final String url = "jdbc:sqlite:" + Settings.USER_PATH + "/.IA_CS/config/config.db";

    public static void main(String[] args) {
        testDb();
    }

    public static void testDb() {
        // Path to the database file
        String dbPath = Settings.USER_PATH + "/.IA_CS/config/config.db";

        // Debugging: Log the paths
        System.out.println("USER_PATH: " + Settings.USER_PATH);
        System.out.println("Checking database file path: " + dbPath);

        // Check if the file exists
        File dbFile = new File(dbPath);
        if (dbFile.exists()) {
            System.out.println("File exists: " + dbFile.getAbsolutePath());
            System.out.println("Is readable: " + dbFile.canRead());
            System.out.println("Is writable: " + dbFile.canWrite());
        } else {
            System.err.println("Database file does not exist at: " + dbPath);
            return;  // Exit the method if the file is missing
        }

        // Test the connection
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection to SQLite database established successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the SQLite database: " + e.getMessage());
        }
    }
}
