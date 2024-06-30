package it.isa.progetto;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ATM {

    //Use a Collection:
    //Store instances of UserAccount in a HashMap where the key is the username and the value is the UserAccount instance. This allows efficient lookups by username.
    private Map<String, UserAccount> accounts = new HashMap<>();
    private UserAccount currentUser;

    // implemented for test purpose 
    public void setCurrentUser(UserAccount account) {
        this.currentUser = account;
    }

    public UserAccount getCurrentUser() {
    return currentUser;
    }


    // Method to add a new user to the accounts map
    public void addUser(String username, String password, double initialAmount) {
        UserAccount account = new UserAccount(username, password, initialAmount);
        accounts.put(username, account);
    }

    // Pause the program for a specified number of seconds
    public static void sleepSecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Authenticate a user by their username and password
    public boolean authenticate(String username, String password) {
        
        UserAccount account = accounts.get(username);
        if (account != null && account.getPassword().equals(password)) {
            System.out.println("Authentication successfully. Welcome, " + username + "!");
           sleepSecond(1);
            currentUser = account;
            return true;
        } else {
            System.out.println("Failed authentication. Invalid username or pin please try again.");
          sleepSecond(1);
            return false;
        }
    }

   // Deposit an amount into the current user's account
    public void deposit(double importo) {
        if (importo > 0) {
            currentUser.setInitialAmount(currentUser.getInitialAmount() + importo);
            System.out.println("Deposit done successfully.");
            System.out.println("New balance: " + currentUser.getInitialAmount());
        } else {
            System.out.println("Invalid amount for deposit.");
        }
        sleepSecond(1);        
    }


  // Withdraw an amount from the current user's account
    public void withdraw(double importo) {
        if (importo > 0 && importo <= currentUser.getInitialAmount()) {
            currentUser.setInitialAmount(currentUser.getInitialAmount() - importo);
            System.out.println("Withdraw done successfully.");
            System.out.println("New balance: " + currentUser.getInitialAmount());
        } else {
            System.out.println("Invalid amount for withdrawal or insufficient balance.");
        }
        sleepSecond(1);        
    }
    
    // Get the current balance of the authenticated user
    public double getInitialAmount() {
        return currentUser.getInitialAmount();
    }

    // Ask the user if they want to perform another operation
    public static void another_operation() {
    System.out.println("Do you want to select another option? (N -> to exit)");
    Scanner scanner = new Scanner(System.in);
    String risposta = scanner.next();
        if (risposta.equalsIgnoreCase("N")) {
            System.out.println("Exiting.. ,Thank you!");
            System.exit(0);
        }
    }    

}