/**
 * _________ _______  _______  _______   _________ _______  ______   ______  
 * \__   __/(  ____ \(  ___  )(       )  \__   __/(  ___  )(  ___ \ (  ___ \ 
 *    ) (   | (    \/| (   ) || () () |     ) (   | (   ) || (   ) )| (   ) )
 *    | |   | (__    | (___) || || || |     | |   | |   | || (__/ / | (__/ / 
 *    | |   |  __)   |  ___  || |(_)| |     | |   | |   | ||  __ (  |  __ (  
 *    | |   | (      | (   ) || |   | |     | |   | |   | || (  \ \ | (  \ \ 
 *    | |   | (____/\| )   ( || )   ( |     | |   | (___) || )___) )| )___) )
 *    )_(   (_______/|/     \||/     \|     )_(   (_______)|/ \___/ |/ \___/ 
 */

package Backend;

/**
 *
 * @author borgarlie
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class User {
    private String[] usernames = null;
    private Connection conn;
    public User() {
        this.usernames = updateUsernames();
        this.conn = DatabaseSetup.connect();
    }
    
    public int usernameLength(){
        int length = 0;
        Statement command = null;
        try{
            command = DatabaseSetup.connect().createStatement();
            String resultSize = "SELECT COUNT(*) FROM users";
            ResultSet userSize = command.executeQuery(resultSize);
            while(userSize.next()){
                length = userSize.getInt(1);
            }
        }catch(SQLException e){
            System.out.println("feil i teller" + e);
        }     
        return length;
    }

    public String[] updateUsernames() {
        String select = "SELECT * FROM users";
        Statement command = null;
        String[] temp = null;   
        int counter = 0;
        ArrayList<String> liste = new ArrayList<String>();
        try{
            command = DatabaseSetup.connect().createStatement();
            ResultSet rs = command.executeQuery(select);
            temp = new String[usernameLength()]; 
            while(rs.next()){
                liste.add(rs.getString("username"));
                temp[counter] = rs.getString("username");  
                counter++;   
            }

       }catch(Exception e){
            System.out.println("feil.");
            e.printStackTrace();
       }  
        return temp;
    }

    public String[] getUsernames() {
    	return this.usernames;
    }

    public boolean createUser(String newUser) {
        newUser = newUser.trim();
        Statement command = null;
       try{
          command = this.conn.createStatement();
           command.executeUpdate("INSERT INTO users VALUES(DEFAULT, '" + newUser + "')");
       }
       catch(SQLException e){
           System.out.println("feil i ny user create " + e);
       }
       finally{
           try{
               command.close();               
           }
           catch(SQLException a){
               System.out.println("feil i command close " + a);
           }
       }
       return true;
    }
}
