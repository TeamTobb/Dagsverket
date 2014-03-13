// package Backend;

// bugg in java?

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author borgarlie
 */

import java.util.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Operator {
    // ERROR MESSAGES
    public static int NO_CONTRACTOR = 1;
    public static int NO_CONTACT_INFO = 2;
    public static int NO_SUBJECT = 3;
    
    // Object variables
    private String name;
    private Connection conn;

    public Operator(String name) {
            this.name = name;
            this.conn = connect();
    }
    public void addEmployee(String firstName, String lastName){
        PreparedStatement sqlStatement = null;
        try{
            sqlStatement = this.conn.prepareStatement("insert into employees values (DEFAULT, ?, ?, null, null)");
            sqlStatement.setString(1, firstName);
            sqlStatement.setString(2, lastName);
            sqlStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("feil i addEmployee");
        }
        finally{
            if(sqlStatement != null){
                try{
                    sqlStatement.close();
                }
                catch(SQLException a){
                    System.out.println("feil i close addEmployee");
                }
            }
        }
    }
    
    public void updateEmployeeListLeft(JTable tabell){
        try{
        Statement setning = this.conn.createStatement();
        String SQL = "select * from employees";
        ResultSet rs = setning.executeQuery(SQL);
        String firstName = "";
        String lastName = ""; 
        String lastRegDate = "";
        DefaultTableModel model = (DefaultTableModel) tabell.getModel();
        model.setRowCount(0);
        while(rs.next()){
            firstName = rs.getString("firstName");
            lastName= rs.getString("lastName");
            lastRegDate = rs.getString("lastRegDate");
            model.insertRow(tabell.getRowCount(), new Object[] {firstName, lastName, lastRegDate});
        }   
        }catch(Exception e){
            System.out.println("feil i update venstre liste");
        }
    }
    
    public void fyllTabellTest(JTable tabell){
        try{
        Statement setning = this.conn.createStatement();
        String SQL = "select * from events";
        ResultSet rs = setning.executeQuery(SQL);
        int id = 0;
        String contractor = ""; 
        int tlf = 0;
        String topic = "";
        
        DefaultTableModel model = (DefaultTableModel) tabell.getModel();
        while(rs.next()){ 
            id = rs.getInt("event_id");
            contractor= rs.getString("contractor");
            tlf = rs.getInt("phone");
            topic = rs.getString("subject");
            model.insertRow(tabell.getRowCount(), new Object[] {id, contractor, tlf, topic});
        }   
        }catch(Exception e){
            System.out.println("feil.");
        }
    }
    
    public void fyllTabell(JTable tabell){
        DefaultTableModel model = (DefaultTableModel) tabell.getModel();
        String[] testData = {"DATA", "DATA", "DATA", "DATA", "DATA"};
        for(int i = 0; i<15; i++){
            model.addRow(testData);   
            System.out.println("JORGEN");
        }
    }

    private Connection connect() {
        Connection conn_new = null;
        try {
            String databasenavn = "jdbc:derby://localhost:1527/Dagsverket;user=root;password=root"; // no username / pw
            conn_new  = DriverManager.getConnection(databasenavn);
        } catch (Exception e) {
            System.out.println("Feil 1: " + e);
            System.exit(0); // ?? gjor noe annet...?
        }
        return conn_new;
    }

    public void endConnection() {
        // end connection
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Feil 2: " + e);
        }
    }

    public String getName() {
    	return this.name;
    }
    
    // public void createEventTest(String contractor, int phone, String mail, String address, int postnr, String postplace, String responsible, String checkup_date, String tid, String subject, String description, String status){
    //     String hoho = "INSERT INTO events VALUES(DEFAULT, '"+contractor + 
    //                             "', "+ phone + ", '" + mail + "', '" + address + "', "+postnr+", '"+
    //                             postplace + "', '" + responsible + "', '" + checkup_date + "', '" + tid +
    //                             "', '" + subject + "', '" + description + "', '"+ status + "')";
    //   try{
    //       PreparedStatement sqlStatement = this.conn.prepareStatement("insert into events values(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    //       sqlStatement.setString(1, contractor);
    //       sqlStatement.setInt(2, phone);
    //       sqlStatement.setString(3, mail);
    //       sqlStatement.setString(4, address);
    //       sqlStatement.setInt(5, postnr);
    //       sqlStatement.setString(6, postplace);
    //       sqlStatement.setString(7, responsible);
    //       sqlStatement.setString(8, checkup_date);
    //       sqlStatement.setString(9, tid);
    //       sqlStatement.setString(10, subject);
    //       sqlStatement.setString(11, description);
    //       sqlStatement.setString(12, status);
    //       sqlStatement.executeUpdate();       
    //   }
    //   catch(SQLException e){
    //         System.out.println("feil createStatement");
    //   }     
    // }
    
    // ADD a DATE, JAVA DATE -- how to add to SQL?
    public ArrayList<Integer> createEvent(String contractor, String[] employees, int phone, String mail, String address, int postnr, String postplace, String responsible, String checkup_date, String date, String time, String subject, String description, String status) {
        // date & time is not string. ??

    	// Check and verify every parameter
        // add errors to arraylist
        ArrayList<Integer> errors = new ArrayList<Integer>();

        // important: contractor, phone / mail, subject

    	if(contractor == null || contractor.trim().equals("")) {
    		errors.add(NO_CONTRACTOR);
    	}
        if(mail == null || mail.trim().equals("") && phone <= 0) {
            errors.add(NO_CONTACT_INFO);
        }
        if(subject == null || subject.trim().equals("")) {
            errors.add(NO_SUBJECT);
        }

        if(errors == null || errors.size() == 0) {
            // updateDatabase();
            PreparedStatement sqlStatement = null;
            try {
                sqlStatement = this.conn.prepareStatement("insert into events values(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                sqlStatement.setString(1, contractor);
                sqlStatement.setInt(2, phone);
                sqlStatement.setString(3, mail);
                sqlStatement.setString(4, address);
                sqlStatement.setInt(5, postnr);
                sqlStatement.setString(6, postplace);
                sqlStatement.setString(7, responsible);
                sqlStatement.setString(8, checkup_date);
                sqlStatement.setString(9, time);
                sqlStatement.setString(10, subject);
                sqlStatement.setString(11, description);
                sqlStatement.setString(12, status);
                sqlStatement.executeUpdate(); 
            } catch (SQLException e) {
                System.out.println("Feil 2: " + e);
                // add to errors /4?
            } finally {
                try {
                    if (sqlStatement != null) {
                        sqlStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Feil 3: " + e);
                }
            } // finally

            return null;
            // if null on client, move on to next.
        }

    	return errors;
        // if errors are returned, handle them on client.
    }

    // kalender osv i annen klasse.

    public static void main(String[] args) {
        // System.out.println("test");
       Operator op = new Operator("Gunnar");
       System.out.println(op.createEvent("test123", null, 123, null, null, 444, null, null, null, null, null, null, null, null));
       // test for create event
    }
	
}
