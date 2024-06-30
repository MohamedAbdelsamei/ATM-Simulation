package it.isa.progetto;
import java.util.Scanner;
public class App {
    
    public static void main(String[] args) {

        ATM manager = new ATM();
        manager.addUser("1122", "1122", 1000.0);
        manager.addUser("3344", "3344", 2000.0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("-- Welcome to the ATM --");
        System.out.print("username: ");
        String enteredUsername = scanner.nextLine();
        
        System.out.print("Password: ");
        String enteredPin = scanner.nextLine();

        if(manager.authenticate(enteredUsername, enteredPin)){
            boolean exit = false;
            while (!exit) {
                // Display the ATM menu
                System.out.println("Please select an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();

                // Process the user's choice
                switch (choice) {
                    case 1:
                        System.out.println("Enter the amount to deposit:");
                        double importDeposit = scanner.nextDouble();
                        manager.deposit(importDeposit);
                        manager.another_operation();
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw:");
                        double importwithdraw = scanner.nextDouble();
                        manager.withdraw(importwithdraw);
                        manager.another_operation();
                        break;
                    case 3:
                        System.out.println("Available balance:" + manager.getInitialAmount());
                        manager.another_operation();
                        break;
                    case 4:
                        System.out.println("Exiting.. ,Thank you!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }            

            }
        }
    }    
}   