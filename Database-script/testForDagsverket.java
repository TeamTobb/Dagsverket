import java.util.*;
import java.sql.*;

// test for Dagsverket - Klasser

class Users {
	// liste med brukere
}

// class User {
// 	// register bruker, osv..
// }

class Cases {
	public static int NO_CONTRACTOR = 1;
    public static int NO_CONTACT_INFO = 2;
    public static int NO_SUBJECT = 3;

	ArrayList<Case> test = new ArrayList<Case>();

	public Cases(int max) {
		// TA BORT ALT DETTE
		// ResultSet abc = getCasesFromDatabase(max);
		// try {
		// 	while(abc.next()) {
		// 	Case newCase = new Case(
		// 		abc.getInt("phone"),
  //           	abc.getString("employer"),
  //           	abc.getString("address"),
  //           	abc.getInt("postnr"),
  //           	abc.getString("postplace")
		// 		);
		// 	this.test.add(newCase);
		// 	}
		// } catch(SQLException e) {
		// 	System.out.println(e);
		// }
	}

	public boolean updateCaseList(String status, int start, int end) {
		test = null;
		// UPDATE WHOLE LIST FROM DB WITH CORRECT STATUS...
		// FROM START TO END?
		return false;
	}

	// DETTE ER LURT, SLIK AT NAAR VI SKAL SE PAA DETALJER SAA KAN VI HENTE EN CASE FRA LISTEN.

	// public ResultSet getCasesFromDatabase(int max) {
	// 	// hent all data fra database
	// 	// MAX angir hvor mange du vil hente
	// 	Statement setning = this.conn.createStatement();
 //        String SQL = "select * from events";
 //        ResultSet test123 = setning.executeQuery(SQL);
 //        // DETTE SKAL EGENTLIG GJORES I DATABASE
	// 	return test123;
	// }

	public ArrayList<Case> getCases() {
		return this.test;
	}

	public ArrayList<Integer> createCase(String contractor, int phone, String subject) {
		ArrayList<Integer> errors = checkFields(contractor, phone, subject);
		if(errors == null) {
			// CREATE NEW CASE()
			// ADD TO CASES
			// CASE.INSERT_TO_DB()
			return null;
		}
		return errors;
	}

	private ArrayList<Integer> checkFields(String contractor, int phone, String subject) {
		ArrayList<Integer> errors = new ArrayList<Integer>();

        // important: contractor, phone / mail, subject

    	if(contractor == null || contractor.trim().equals("")) {
    		errors.add(NO_CONTRACTOR);
    	}
        if(phone <= 0) {
            errors.add(NO_CONTACT_INFO);
        }
        if(subject == null || subject.trim().equals("")) {
            errors.add(NO_SUBJECT);
        }
        return errors;
	}

	// OSV
}

// EMPLOYEE CLASSES ??

class Case {
	private int phone;
	private String employer;
	private String address;
	private int postnr;
	private String postplace;

	public Case(int phone, String employer, String address, int postnr, String postplace) {
		this.phone = phone;
		this.employer = employer;
		this.address = address;
		this.postnr = postnr;
		this.postplace = postplace;
	}

	public boolean INSERT_TO_DB() {
		// INSERT HERE, use DATABASE
		return false;
	}

	public boolean UPDATE_CASE_IN_DB() {
		// UPDATE HERE, use DATABASE
		return false;
	}

	// registrer case, endre case, osv.	
}

class Sales {
	// liste med salg
}

class Sale {
	// registrer salg osv...
}

class Database {
	// alt som skjer mot databasen
}