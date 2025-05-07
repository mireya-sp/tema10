package com.mireyaserrano.tema10.ejericio07;

import com.mireyaserrano.tema10.ejericio07.Aleatorios;

public class EntradaVIP extends Entrada{
    private String codigoCaja;

    public EntradaVIP(Partido partido, Zona zona, Fila fila, Asiento numAsiento, int precioBase) {
        super(partido, zona, fila, numAsiento, precioBase);
        this.codigoCaja = Aleatorios.codigoCajaFuerte();
    }

    public String getCodigoCaja() {
        return codigoCaja;
    }

    @Override
    public String toString() {
        return "EntradaVIP{" +
                "codigoCaja='" + codigoCaja + '\'' +
                '}';
    }
}
