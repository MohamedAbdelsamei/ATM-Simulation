package it.isa.progetto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    
    private ATM atm = new ATM();

    @Test
    public void testDeposit() {
        atm.deposito(500);
        assertEquals(2500.5, atm.getSaldo());
    }

}
