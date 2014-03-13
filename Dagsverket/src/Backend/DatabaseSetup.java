/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;
import java.sql.*;

/**
 *
 * @author Jorgen
 */
public class DatabaseSetup {
    public static Connection connect() {
        Connection conn_new = null;
        try {
            String databasenavn = "jdbc:derby://localhost:1527/Dagsverket;user=root;password=root"; // no username / pw
            conn_new  = DriverManager.getConnection(databasenavn);
        } catch (Exception e) {
            System.out.println("DatabaseSetup Feil 1: " + e);
            System.exit(0); // ?? gjor noe annet...?
        }
        return conn_new;
    }

    public static void endConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("DatabaseSetup Feil 2: " + e);
        }
    }
    
}
