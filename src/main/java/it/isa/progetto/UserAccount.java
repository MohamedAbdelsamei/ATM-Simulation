package it.isa.progetto;

/* Define a Custom Class:
Create a class, for example, UserAccount, with fields for the username, password, and initial amount */

public class UserAccount {
    private String username;
    private String password;
    private double initialAmount;

    public UserAccount(String username, String password, double initialAmount) {
        this.username = username;
        this.password = password;
        this.initialAmount = initialAmount;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(double initialAmount) {
        this.initialAmount = initialAmount;
    }
}

