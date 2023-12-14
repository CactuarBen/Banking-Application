import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        //initialise Scanner
        Scanner scan = new Scanner(System.in);

        //initialise Bank
        Bank theBank = new Bank("Bank of Prague");

        //add a user, which also creates a savings account
        Client newClient = theBank.addClient("Sam", "Johnson", "1234");

        //add a checking account for newClient
        Account newAccount = new Account("Checking", newClient, theBank);
        newClient.addAccount(newAccount);
        theBank.addAccount(newAccount);

        Client currentClient;
        while (true){
            //stay in the login prompt until successful login
            currentClient = ATM.mainMenuPrompt(theBank, scan);

            //stay in main menu until the client quits
            ATM.printUserMenu(currentClient, scan);
        }
    }

    /**
     * Print the ATM's login menu
     * @param theBank   the Bank object whose accounts to use
     * @param scan      the Scanner object to use for user input
     * @return          the authenticated User object
     */
    public static Client mainMenuPrompt(Bank theBank, Scanner scan){
        //initialise
        String clientID;
        String pin;
        Client authClient;

        //prompt the user for ID/pin combo until a correct one is reached
        do {
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID:");
            clientID = scan.nextLine();
            System.out.print("Enter pin: ");
            pin = scan.nextLine();

            //try to get the user object corresponding to the ID and pin combo
            authClient = theBank.clientLogin(clientID, pin);
            if (authClient == null){
                System.out.println("Incorrect user ID/pin, try again ");
            }
        } while(authClient == null);// continue looping until successful login

        return authClient;
    }

    public static void printUserMenu(Client theClient, Scanner scan){

    }
}
