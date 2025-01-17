package dev.personal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
   
    private CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount(5000, 12); // saldo inicial 5000, tasa anual 12%
    }

    @Test
    void testRetiroSinSobregiro() {
        account.retirar(3000);
        assertEquals(2000, account.getSaldo(), "El saldo debería ser 2000 después de un retiro dentro del límite del saldo");
        assertEquals(1, account.getNumRetiros(), "Debería haber registrado 1 retiro");
        assertEquals(0, account.getSobregiro(), "El sobregiro debería ser 0 si no se excede el saldo");
    }

    @Test
    void testRetiroConSobregiro() {
        account.retirar(7000);
        assertEquals(0, account.getSaldo(), "El saldo debería ser 0 después de un retiro que excede el saldo");
        assertEquals(2000, account.getSobregiro(), "El sobregiro debería ser 2000 por el exceso");
        assertEquals(1, account.getNumRetiros(), "Debería haber registrado 1 retiro");
    }

    @Test
    void testConsignarParaReducirSobregiro() {
        account.retirar(7000); // Sobregiro de 2000
        account.consignar(3000); // Consignar suficiente para cubrir el sobregiro y agregar saldo

        assertEquals(1000, account.getSaldo(), "El saldo debería ser 1000 después de cubrir el sobregiro y agregar saldo");
        assertEquals(0, account.getSobregiro(), "El sobregiro debería ser 0 después de cubrirlo");
    }

    @Test
    void testConsignarParcialParaSobregiro() {
        account.retirar(7000); // Sobregiro de 2000
        account.consignar(1500); // Consignar menos del sobregiro

        assertEquals(0, account.getSaldo(), "El saldo debería seguir siendo 0 ya que solo se redujo el sobregiro");
        assertEquals(500, account.getSobregiro(), "El sobregiro debería reducirse a 500 después de la consignación parcial");
    }

    @Test
    void testConsignarSinSobregiro() {
        account.consignar(2000);

        assertEquals(7000, account.getSaldo(), "El saldo debería ser 7000 después de consignar sin sobregiro");
        assertEquals(0, account.getSobregiro(), "El sobregiro debería permanecer en 0 si no existía");
    }
}
