import java.util.Date;

public class Transaction {

    /* The amount of this transaction*/
	private double amount;

    /* The date and time of this transaction*/
	private Date timestamp;

    /* A memo for this transaction*/
	private String memo;
	
    /* The account in which the transaction was performed*/
	private Account inAccount;
	
}
