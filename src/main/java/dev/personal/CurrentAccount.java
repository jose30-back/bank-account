package dev.personal;

public class CurrentAccount extends Account {

    private float sobregiro = 0;

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    public CurrentAccount(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                super.retirar(cantidad);
            } else {
                sobregiro += cantidad - saldo;
                saldo = 0;
                numRetiros++;
            }
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
                cantidad = 0;
            }
        }
        super.consignar(cantidad);
    }

    @Override
    public String imprimir() {
        return String.format("%s, Sobregiro: %.2f", super.imprimir(), sobregiro);
    }
}
