import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Client {
        /**
         * first name of the user
         */
        private String firstName;
        /**
         * last name of the user
         */
        private String lastName;
        /**
         * the ID number of the user
         */
        private String uuid;
        /**
         * the MD5 hashcode of the user's pin number.
         */
        private byte pinHash[];
        /**
         * the list of all accounts of the user
         */
        private ArrayList<Account> accounts;

        /**
         * Create a new user
         * @param firstName     the user's first name
         * @param lastname      the user's last name
         * @param pin           the user's account pin number
         * @param theBank       the Bank object that the user is a customer of
         */

        public Client(String firstName, String lastname, String pin, Bank theBank){

                //set user's name
                this.firstName = firstName;
                this.lastName = lastname;

                //store the pin's MD5 hash, rather than the original value
                //for the security reasons
                try{
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        this.pinHash = md.digest(pin.getBytes());
                } catch (NoSuchAlgorithmException e){
                        System.err.println("Error, caught NoSuchAlgorithmException");
                        e.printStackTrace();
                        System.exit(1);
                }

                //get a new, unique universal ID for the user
                this.uuid = theBank.getNewUserUUID();

                //create an empty list of accounts
                this.accounts = new ArrayList<Account>();

                //print log message
                System.out.printf("New user %s, %s with ID %s created. \n", lastName, firstName, this.uuid);


        }

        /**
         * Add an account for the user
         * @param anAcct the account to add
         */
        public void addAccount(Account anAcct){
                this.accounts.add(anAcct);
        }

        /**
         * Get the account ID
         * @return  the uuid
         */
        public String getUUID(){
                return this.uuid;
        }

        /**
         * Check whether a given pin matches the true Client pin
         * @param pin   the pin to check
         * @return      whether the pin is valid or not
         */
        public boolean validatePin(String pin){
                try{
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
                } catch (NoSuchAlgorithmException e){
                        System.err.println("Error, caught NoSuchAlgorithmException");
                        e.printStackTrace();
                        System.exit(1);
        }
                return false;
        }

}
