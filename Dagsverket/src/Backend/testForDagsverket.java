// test for Dagsverket - Klasser

class Users {
	// liste med brukere
}

class User {
	// register bruker, osv..
}

class Cases {
	ArrayList<Case> test = new ArrayList<Case>();

	public Cases(int max) {
		Resultset abc = getCasesFromDatabase(max);
		while(abc.next()) {
			Case newCase = new Case(
				rs.getInt("phone");
            	rs.getString("employer");
            	rs.getString("address");
            	rs.getInt("postnr");
            	rs.getString("postplace");
				)
			this.test.add(newCase);
		}
	}

	public Resultset getCasesFromDatabase(int max) {
		// hent all data fra database
		// MAX angir hvor mange du vil hente
	}

	public ArrayList<Case> getCases() {
		return this.test;
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