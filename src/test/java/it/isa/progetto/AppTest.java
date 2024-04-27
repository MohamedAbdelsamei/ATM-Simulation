package it.isa.progetto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;

@RunWith(JUnitQuickcheck.class)
public class AppTest 
{
    
    private ATM atm = new ATM();

    @Disabled
    @Test
    public void testDeposit() {
        atm.deposito(500);
        assertEquals(2500.5, atm.getSaldo());
    }


    @Property(trials = 10)
    public void Testdeposito2(double amount) {
        if (amount > 0) {
            double initialSaldo = atm.getSaldo();
            atm.deposito(amount);
            assertEquals(initialSaldo + amount, atm.getSaldo());
        }
    }

    @Property(trials = 10)
    public void testprelievo(double amount) {
        double initialBalance = atm.getSaldo();
        if (amount <= initialBalance) {
            atm.prelievo(amount);
            assertTrue(atm.getSaldo() == initialBalance - amount);
        }
    }

}
