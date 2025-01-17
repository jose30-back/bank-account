package dev.personal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    
   private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(15000, 12);
    }

    @Test
    void testConsignarEnCuentaActiva() {
        account.consignar(2000);
        assertEquals(17000, account.saldo, "El saldo debería ser 17000 después de consignar en una cuenta activa");
    }

    @Test
    void testRetirarEnCuentaInactiva() {
        account.retirar(14000);
        account.retirar(1000);
        assertEquals(1000, account.saldo, "El retiro no debería permitirse si la cuenta está inactiva");
    }

    @Test
    void testExtractoMensualConRetirosExtra() {
        for (int i = 0; i < 6; i++) {
            account.retirar(100);
        }
        account.extractoMensual();
        assertEquals(2000, account.comisionMensual, "Debería aplicar comisión de 2000 por los retiros extra");
    }
}
