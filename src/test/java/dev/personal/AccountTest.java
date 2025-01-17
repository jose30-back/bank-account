package dev.personal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    private Account account ;

     @BeforeEach
    void setUp() {
        account = new Account(5000, 12); // saldo inicial 5000, tasa anual 12%
    }

    @Test
    void testCalcularInteres() {

        account.calcularInteres();
        assertEquals(5050, account.saldo, 0.01);
    }

    @Test
    void testConsignar() {
        account.consignar(2000);
        assertEquals(7000, account.saldo);
        assertEquals(1, account.numConsignaciones);
    }

    @Test
    void testExtractoMensual() {
        account.comisionMensual = 100;
        account.extractoMensual();
        assertEquals(4949, account.saldo, 0.01);
    }

    @Test
    void testRetirar() {
        account.retirar(3000);
        assertEquals(2000, account.saldo);
        assertEquals(1, account.numRetiros);
    }
}
