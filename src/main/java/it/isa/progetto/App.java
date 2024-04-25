package it.isa.progetto;

import java.util.Scanner;

public class App {
    private static String username = "133844";
    private static String pin = "1155";

    public static void main(String[] args) {

        if (ATM.autentication(username, pin)) {
            boolean exit = false;
            while (!exit) {
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
                        ATM.deposito(importoDeposito);
                        ATM.altraOperazione();
                        break;
                    case 2:
                        System.out.print("Inserisci l'importo da prelevare: ");
                        double importoPrelievo = scanner.nextDouble();
                        ATM.prelievo(importoPrelievo);
                        ATM.altraOperazione();
                        break;
                    case 3:
                        System.out.println("Saldo disponibile: " + ATM.getSaldo());
                        ATM.altraOperazione();
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
}