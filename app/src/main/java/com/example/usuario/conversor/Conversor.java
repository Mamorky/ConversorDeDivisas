package com.example.usuario.conversor;

/**
 * Created by mamorky on 29/09/17.
 */

public class Conversor {

    public double getDolares() {
        return dolares;
    }

    public void setDolares(double dolares) {
        this.dolares = dolares;
    }

    public double getEuros() {
        return euros;
    }

    public void setEuros(double euros) {
        this.euros = euros;
    }

    public enum TipoCambio {
        euroDolar,
        dolarEuro
    };

    private static final double CAMBIO = 0.84636;
    private double dolares;
    private double euros;

    public Conversor(double cantidad,TipoCambio tipo){
        if(tipo.equals(TipoCambio.dolarEuro)){
            setDolares(cantidad);
            setEuros((double)(Math.round(cantidad/CAMBIO*100d)/100d));
        }
        if(tipo.equals(TipoCambio.euroDolar)){
            setEuros(cantidad);
            setDolares((double)(Math.round(cantidad*CAMBIO*100d)/100d));
        }
    }
}
