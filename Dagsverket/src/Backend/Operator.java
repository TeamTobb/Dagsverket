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
            //this.conn = connect();
    }
    
    public void fyllTabell(JTable tabell){
        DefaultTableModel model = (DefaultTableModel) tabell.getModel();
        String[] testData = {"DATA", "DATA", "DATA", "DATA", "DATA"};
        for(int i = 0; i<15; i++){
            model.addRow(testData);        
        }
    }

    private Connection connect() {
        // String databasedriver = "org.apache.derby.jdbc.ClientDriver";
        Connection conn_new = null;
        try {
            // Class.forName(databasedriver);
            String databasenavn = "jdbc:derby://localhost:1527/persondata;user=;password="; // no username / pw
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
    //OVERLOADING AV KONSTRUKTØR FOR Å FÅ DET TIL Å FUNKE ATM 
    public ArrayList<Integer> createEvent(String contractor, String[] employees, int phone, String mail, String address, int postnr, String postplace, String responsible, String checkup_date, String subject, String description, String status){
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
        return errors;
    }

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

            Statement setning = null;
            String insert = "INSERT INTO events VALUES(" + ");";
            // CHANGE THIS TO CORRECT VALUES....
            try {
                setning = this.conn.createStatement();
                setning.executeUpdate(insert);
            } catch (SQLException e) {
                System.out.println("Feil 2: " + e);
            } finally {
                try {
                    if (setning != null) {
                        setning.close();
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
