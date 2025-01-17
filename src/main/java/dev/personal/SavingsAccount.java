package dev.personal;

public class SavingsAccount extends Account  {

    private boolean activa;

    public SavingsAccount(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
            actualizarEstado();
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            actualizarEstado();
        }
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        actualizarEstado();
    }

    private void actualizarEstado() {
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return String.format("%s, Activa: %b", super.imprimir(), activa);
    }

}
