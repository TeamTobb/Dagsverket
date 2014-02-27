import java.util.*;

class User {
	ArrayList<String> usernames;
	public User() {
		this.usernames = getUsernames();
	}

	// Used to display usernames in GUI
	private ArrayList<String> getUsernames() {
		ArrayList<String> users = new ArrayList<String>();

		// connect to database -> Fetch all usernames and return them

		return users;

	}

	// Used in GUI to create a new user and add to database
	public boolean createNewUser(String username) {
		return false;
	}


}