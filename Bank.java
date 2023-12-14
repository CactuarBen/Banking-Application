import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<Client> clients;

    private ArrayList<Account> accounts;

    /**
     * Create a new Bank object with empty list of clients and accounts
     * @param name  the name of the bank
     */
    public Bank(String name){

        this.name = name;
        this.clients = new ArrayList<Client>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Generate a new universally unique ID for a user
     * @return  the UUID
     */
    public String getNewUserUUID(){
        //initialisation
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for (int i = 0; i < len; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();

            }
            // check to make sure it is unique
            nonUnique = false;
            for (Client c : this.clients){
                if (uuid.compareTo(c.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }

    /**
     * Generate a new universally unique ID for an account
     * @return  the uuid
     */
    public String getNewAccountUUID(){
        //initialisation
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for (int i = 0; i < len; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();

            }
            // check to make sure it is unique
            nonUnique = false;
            for (Account a : this.accounts){
                if (uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }

    /**
     * Add an account
     * @param anAcct    the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

//    /**
//     * Return the client's UUID
//     * @return  the uuid
//     */
//    public String getUUID(){
//        return this.uuid;
//    }

    /**
     * Create a new user of the bank
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param pin       the user's pin
     * @return          the new User object
     */
    public Client addClient(String firstName, String lastName, String pin){

        //create a new Client object and add it to our list
        Client newClient = new Client(firstName, lastName, pin, this);
        this.clients.add(newClient);

        //create a savings account
        Account newAccount = new Account("Savings", newClient, this);

        //add the savings account to the User and Bank
        newClient.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newClient;
    }

    /**
     * Get the Client object associated with the specific userID and pin, if
     * they are valid and exist
     * @param clientID    the UUID of the client to log in
     * @param pin       the pin of the client
     * @return          the Client object, if the login is successful, null, not
     */
    public Client clientLogin(String clientID, String pin){

        //search through the users
        for (Client c : this.clients){

            //check user ID if is correct
            if (c.getUUID().compareTo(clientID) == 0 && c.validatePin(pin)) {
                return c;
            }
        }
        //if we haven't found a user or have an incorrect pin
        return null;
    }

    public String getName(){
        return this.name;
    }


}
