import java.util.Date;

public class Transaction {

    /**
     * the amount of this transaction
     */
    private double amount;
    /**
     * the time and date for this transaction
     */
    private Date timestamp;
    /**
     * a memo for this transaction
     */
    private String memo;
    /**
     * the account where the transaction was performed
     */
    private Account inAccount;

    /**
     * Create a new transaction
     * @param amount        the amount transacted
     * @param inAccount     the account the transaction belongs to
     */
    public Transaction(double amount, Account inAccount){

        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    /**
     * Create a new transaction
     * @param amount    the amount transacted
     * @param memo      the memo for the transaction
     * @param inAccount the account the transaction belongs to
     */
    public Transaction(double amount, String memo, Account inAccount){

        //call the two-arguments constructor first
        this(amount, inAccount);

        //set the memo
        this.memo = memo;
    }
}
