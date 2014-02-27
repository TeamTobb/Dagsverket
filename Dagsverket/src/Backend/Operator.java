package Backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author borgarlie
 */

public class Operator {
    private String name;

    public Operator(String name) {
            this.name = name;
    }

    public String getName() {
    	return this.name;
    }

    public boolean createEvent(String contractor, String[] employees) {
    	// Check and verify every parameter
    	if(contractor != null) {
    		return true;
    	}

    	// updateDatabase();

    	return true;

    }

    // kalender osv i annen klasse.
	
}
