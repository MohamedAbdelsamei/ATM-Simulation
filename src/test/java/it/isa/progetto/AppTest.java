package it.isa.progetto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.pholser.junit.quickcheck.Property;

//Specifies the use of JUnit Quickcheck as the runner for executing property-based tests.
//@RunWith(JUnitQuickcheck.class)

public class AppTest 
{ 

    
    private ATM atm_test ;
    private UserAccount account_test;

    @BeforeEach
    public void setUp() {
        atm_test = new ATM();
        account_test = new UserAccount("TEST", "2222", 1000.0);
        atm_test.setCurrentUser(account_test);
    }



    //-------------Example-based-------------
    //@Disabled
    @Test
    public void testDeposit() {

        double depositAmount = 500.0;       
        double expectedBalance = account_test.getInitialAmount() + depositAmount;

        atm_test.deposit(depositAmount);

        assertEquals(expectedBalance, account_test.getInitialAmount());
    }

    //@Disabled
    @Test
    public void testWithdraw() {
        double withdrawAmount = 500.0;
        double expectedBalance = account_test.getInitialAmount() - withdrawAmount;

        atm_test.withdraw(withdrawAmount);

        assertEquals(expectedBalance, account_test.getInitialAmount());
    }

    //------------- Proprety-based -------------
    @Disabled
    @Property(trials = 5)
    public void testWithdraw(double amount) {
        
        setUp(); //reinitializes the state correctly to avoid interference between tests.

        double initialBalance = account_test.getInitialAmount();
        if (amount <= initialBalance) {
            atm_test.withdraw(amount);
            assertEquals(initialBalance - amount, account_test.getInitialAmount());
        }
    }
    
    @Disabled
    @Property(trials = 5)
    public void testDeposit(double amount) {
        setUp(); //reinitializes the state correctly to avoid interference between tests.
        double initialBalance = account_test.getInitialAmount();
        atm_test.deposit(amount);
        assertEquals(initialBalance + amount, account_test.getInitialAmount());
    }  
    
    


    //------------- Integration-test -------------
    @Disabled
    @Test
    public void testUserFlow() {
        atm_test.addUser("TEST_FLOW", "2222",500);
        // Authenticate user
        assertTrue(atm_test.authenticate("TEST_FLOW", "2222"));

        // Deposit money
        atm_test.deposit(500);
        assertEquals(1000, atm_test.getCurrentUser().getInitialAmount());

        // Withdraw money
        atm_test.withdraw(300);
        assertEquals(700, atm_test.getCurrentUser().getInitialAmount());

        // Try to withdraw more than the balance
        atm_test.withdraw(1000);
        assertEquals(700, atm_test.getCurrentUser().getInitialAmount());
    }
}
