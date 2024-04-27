package it.isa.progetto;

import java.util.Scanner;

public class ATM {
    static double saldo = 2000.5;

    public static boolean autentication(String username, String pin) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto nell'ATM");
        System.out.print("username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Please enter Pin: ");
        String enteredPin = scanner.nextLine();

        if (enteredUsername.equals(username) && enteredPin.equals(pin)) {
            System.out.println("Autenticazione con successo. Benvenuto, " + enteredUsername + "!");
            sleepSecond(1);
            return true;
        } else {
            System.out.println("Autenticazione fallita. Username o pin non validi si prega di riprovare.");
            sleepSecond(1);
            return false;
        }
    }

    public static void sleepSecond(int seconds) {
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
        sleepSecond(1);
    }

    public static void prelievo(double importo) {
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
            System.out.println("Prelievo effettuato con successo.");
            System.out.println("Nuovo saldo: " + saldo);
        } else {
            System.out.println("Importo non valido per il prelievo o saldo insufficiente.");
        }
        sleepSecond(1);
    }

    public static void altraOperazione() {
        System.out.println("Vuoi selezionare un'altra opzione? (si-no)");
        Scanner scanner = new Scanner(System.in);
        String risposta = scanner.next();
        if (risposta.equalsIgnoreCase("no")) {
            System.out.println("Uscita dall'ATM. Grazie!");
            System.exit(0);
        }
    }
    
    public static double getSaldo() {
        return saldo;
    }
}