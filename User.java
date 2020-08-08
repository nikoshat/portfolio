import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    /* The first name of the user*/
	private String firstName;
	
	/* The last name of the user*/
	private String lastName;
	
	/* The ID number of the user*/
	private String uuid;
	
	/* The MD5 hash of the user's pin number*/
	private byte[] pinHash;
	
	/* The list of accounts for this user*/
	private ArrayList<Account> accounts; 
	
	/**
	 * Create a new user
	 * @param firstName the user's first name
	 * @param lastName the user's last name
	 * @param pin the user's account pin number
	 * @param theBank the Bank object that the user is a customer of 
	 */
	public User(String firstName, String lastName, String pin, Bank theBank) {
		
		//set user's name
		this.firstName = firstName;
		this.lastName = lastName;
		
		//store the pin's MD5 hash, instead of the original value, for security reasons
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException ");
			e.printStackTrace();
			System.exit(1);
		}
		
		//get a new, unique universal ID for the user
		this.uuid = theBank.getNewUserUUID();
		
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		//print log message
		System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
		
	}
	
}
