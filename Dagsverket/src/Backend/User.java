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

import java.util.*;

public class User {
    private String[] usernames;

    public User() {
        this.usernames = updateUsernames();
    }

    private String[] updateUsernames() {
    	// ArrayList<String> temp = new ArrayList<String>();
    	String[] temp = {"Borgar", "Bjørn", "Thomas", "Jørgen"};
    	return temp;
    }

    public String[] getUsernames() {
    	return this.usernames;
    }

    public boolean createUser(String nyBruker) {
    	String[] nyTabell = new String[this.usernames.length+1];
        for(int i = 0; i<this.usernames.length; i++){
            nyTabell[i] = usernames[i];
        }
        nyTabell[nyTabell.length-1] = nyBruker;
        this.usernames = nyTabell;

        // ADD TO DATEBAES

        // updateUsernames();

        return true;
    }
}
