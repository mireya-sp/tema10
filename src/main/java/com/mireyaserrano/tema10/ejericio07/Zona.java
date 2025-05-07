package com.mireyaserrano.tema10.ejericio07;

import java.util.Arrays;

public class Zona {
    private final static int CANTIDAD_FILAS = 15;

    private final Fila[] filas;
    private boolean VIP;

    public Zona(boolean VIP) {
        this.filas = new Fila[CANTIDAD_FILAS];
        this.VIP = VIP;
    }

    private void rellenarZona(){
        for (int i = 0; i < filas.length; i++) {
            filas[i] = new Fila();
        }
    }

    public Fila[] getFilas() {
        return filas;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "filas=" + Arrays.toString(filas) +
                ", VIP=" + VIP +
                '}';
    }
}
