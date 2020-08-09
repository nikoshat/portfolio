import java.util.ArrayList;
import java.util.Random;

public class Bank {

	private String name;
	
	private ArrayList<User> users;
	
	private ArrayList<Account> accounts;
	
	/**
	 * Generate a new universally unique ID for a user.
	 * @return the uuid 
	 */
	public String getNewUserUUID() {
	  //initialization method's variables
	    String uuid;
	    Random rng = new Random();
	    int len = 6;
	    boolean nonUnique;
	    
	    //keep looping until we get a unique ID for the user
	    do {
		//generate the number
		uuid="";
		for (int c = 0; c < len; c++) {
		    uuid += ((Integer)rng.nextInt(10)).toString();
		}
	    nonUnique = false;
	    for (User u : this.users) {
		if (uuid.compareTo(u.getUUID()) == 0) {
		    nonUnique = true;
		    break;
		}
	    }
	    } while (nonUnique);
	
	    return uuid;
	}
	
	
	/**
	 * Generate a new universally unique ID for an account.
	 * @return the uuid
	 */
	public String getNewAccountUUID() {
	    //initialization method's variables
	    String uuid;
	    Random rng = new Random();
	    int len = 10;
	    boolean nonUnique;
	    
	    //keep looping until we get a unique ID for the user
	    do {
		//generate the number
		uuid="";
		for (int c = 0; c < len; c++) {
		    uuid += ((Integer)rng.nextInt(10)).toString();
		}
	    nonUnique = false;
	    for (Account a : this.accounts) {
		if (uuid.compareTo(a.getUUID()) == 0) {
		    nonUnique = true;
		    break;
		}
	    }
	    } while (nonUnique);
	
	    return uuid;
	}
	
	/**
	 * Add an account
	 * @param anAcct the account to add
	 */
	public void addAccount(Account anAcct) {
	    this.accounts.add(anAcct);
	}
	
	

	/**
	 * Create a new user of the bank
	 * @param firstName the user's first name
	 * @param lastName  the users' last name
	 * @param pin the user's pin
	 * @return the new User object
	 */
	public User addUser(String firstName, String lastName, String pin) {
	    //create a new User object and add it to the list of users
	    User newUser = new User(firstName,lastName,pin, this);
	    this.users.add(newUser);
	    
	    //create a savings account for the user and add to User and Bank
	    //accounts list 
	    Account newAccount = new Account ("Savings", newUser, this);
	    //add to holder and bank lists - we are adding the same account in each list
	    newUser.addAccount(newAccount);
	    this.accounts.add(newAccount);
	    
	    return newUser;
	}
	

}
