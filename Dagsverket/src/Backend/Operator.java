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

public class Operator {
    // ERROR MESSAGES
    public static int NO_CONTRACTOR = 1;
    public static int NO_CONTACT_INFO = 2;
    public static int NO_SUBJECT = 3;

    // Object variables
    private String name;

    public Operator(String name) {
            this.name = name;
    }

    public String getName() {
    	return this.name;
    }

    public ArrayList<Integer> createEvent(String contractor, String[] employees, int phone, String mail, String address, int postnr, String postplace, String responsible, String date, String subject, String description, String status) {
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
       System.out.println(op.createEvent("test123", null, 123, null, null, 444, null, null, null, "hai", null, null));
       // test for create event
    }
	
}
