package dev.personal;

public class Account {
    protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Account(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
    }

    public float getSaldo() {
        return saldo;
    }



    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }



    public int getNumConsignaciones() {
        return numConsignaciones;
    }



    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }



    public int getNumRetiros() {
        return numRetiros;
    }



    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }



    public float getTasaAnual() {
        return tasaAnual;
    }



    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }



    public float getComisionMensual() {
        return comisionMensual;
    }



    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }



    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numConsignaciones++;
        }
    }

    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        }
    }

    public void calcularInteres() {
        float interesMensual = (tasaAnual / 12) / 100 * saldo;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }

    public String imprimir() {
        return String.format("Saldo: %.2f, Número de Consignaciones: %d, Número de Retiros: %d, Comisión Mensual: %.2f", 
                saldo, numConsignaciones, numRetiros, comisionMensual);
    }

}
