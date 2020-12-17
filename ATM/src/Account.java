import java.util.ArrayList;


public class Account {

    /* The name of the account*/
	private String name;

    /* The account ID number*/
	private String uuid;
	
    /* The User object that owns this account*/
	private User holder;
	
    /* The list of transactions for this account*/
	private ArrayList<Transaction> transactions;
	
     public Account(String name, User holder, Bank theBank) {
    		
    		//set the account name and holder
    		this.name = name;
    		this.holder = holder;
    		
    		//get new account UUID
    		this.uuid = theBank.getNewAccountUUID();
    		
    		//initialize transactions
    		this.transactions = new ArrayList<Transaction>();  		
  		
    	}
    
     /**
      * Get the account ID
      * @return the uuid
      */
     public String getUUID() {
         return this.uuid;     
     }
 
 
}
