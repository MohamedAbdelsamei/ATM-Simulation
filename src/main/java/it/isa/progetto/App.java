package it.isa.progetto;

import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{

    private static String username = "133844";
    private static String pin = "1155";
    private static double saldo = 2000.5;

    public static boolean autentication(String username ,String pin) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto nell'ATM");
        System.out.print( "username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print( "Please enter Pin: ");
        String enteredPin = scanner.nextLine();
        
        if (enteredUsername.equals(username) && enteredPin.equals(pin)) {
            System.out.println("Autenticazione con successo. Benvenuto, " + enteredUsername + "!");
            sleepsecond(1);
            return true ;
        } else {
            System.out.println("Autenticazione fallita. usename o pin non validi si prega di riprovare.");
            sleepsecond(1);
            return false ;
        }
    }

    public static void sleepsecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deposito(double importo) {
        if (importo > 0) {
            saldo += importo;
            System.out.println("Deposito effettuato con successo.");
            System.out.println("Nuovo saldo: " + saldo);
        } else {
            System.out.println("Importo non valido per il deposito.");
        }
        sleepsecond(1);
        altra_operazione();
    }

    public static void prelievo(double importo) {
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
            System.out.println("Prelievo effettuato con successo.");
            System.out.println("Nuovo saldo: " + saldo);
        } else {
            System.out.println("Importo non valido per il prelievo o saldo insufficiente.");
        }
        sleepsecond(1);
        altra_operazione();
    }

    public static void altra_operazione() {
        System.out.println("Vuoi selezionare un'altra opzione? (sì-no)");
        Scanner scanner = new Scanner(System.in);
        String risposta = scanner.next();
        if (risposta.equalsIgnoreCase("no")) {
            System.out.println("Uscita dall'ATM. Grazie!");
            System.exit(0); 
        }
        
    }

    
    public static void main( String[] args )
    {
 
        boolean exit = false;
        while (!exit && autentication(username,pin)) {
            // Display the ATM menu

            System.out.println("1. Deposito");
            System.out.println("2. Prelievo");
            System.out.println("3. Consulta Saldo");
            System.out.println("4. Esci");
            System.out.print("Per favore seleziona un'opzione: ");

            // Read user input
            Scanner scanner = new Scanner(System.in);
            int scelta = scanner.nextInt();

            // Processa la scelta dell'utente
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci l'importo da depositare: ");
                    double importoDeposito = scanner.nextDouble();
                    deposito(importoDeposito);
                    break;
                case 2:
                    System.out.print("Inserisci l'importo da prelevare: ");
                    double importoPrelievo = scanner.nextDouble();
                    prelievo(importoPrelievo);
                    break;
                case 3:
                    System.out.println("Saldo disponibile: " + saldo);
                    altra_operazione();    
                    break;
                case 4:
                    System.out.println("Uscita dall'ATM. Grazie!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opzione non valida. Per favore riprova.");
                    break;
            }
        }
    }
}