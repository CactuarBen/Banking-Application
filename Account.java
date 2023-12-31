import java.util.ArrayList;

public class Account {

    /**
     * The name of the account.
     */
    private String name;
    /**
     * The type of the account
     */
    private String type;
    /**
     * The account ID number
     */
    private String uuid;
    /**
     * The User object that owns this account
     */
    private Client holder;
    /**
     * The list of transactions for this account
     */
    private ArrayList<Transaction> transactions;

    /**
     * Create a new Account
     * @param name      the name of the account
     * @param holder    the User object that holds this account
     * @param theBank   the bank that issues the account
     */

    public Account(String name, Client holder, Bank theBank){
        //set the account name and holder
        this.name = name;
        this.holder = holder;

        //get new account UUID
        this.uuid = theBank.getNewAccountUUID();

        //initialise the transactions
        this.transactions = new ArrayList<Transaction>();
    }

    /**
     * Get the account ID
     * @return  the uuid
     */
    public String getUUID(){
        return this.uuid;
    }


}
