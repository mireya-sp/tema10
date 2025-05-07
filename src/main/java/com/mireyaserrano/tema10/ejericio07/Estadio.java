package com.mireyaserrano.tema10.ejericio07;

import java.util.Arrays;

public class Estadio {
    private final static int CANTIDAD_ZONAS = 10;

    private final Zona[] zonas;

    public Estadio() {
        this.zonas = new Zona[CANTIDAD_ZONAS];
    }

    private void rellenarEstadio(){
        int cantidadVIP = CANTIDAD_ZONAS / 3;
        int cantidadNormal = CANTIDAD_ZONAS - cantidadVIP;
        for (int i = 0; i < cantidadNormal; i++) {
            zonas[i] = new Zona(false);
        }
        for (int i = cantidadNormal; i < CANTIDAD_ZONAS; i++) {
            zonas[i] = new Zona(true);
        }
    }

    public Estadio(Zona[] zonas) {
        this.zonas = zonas;
    }

    public Zona[] getZonas() {
        return zonas;
    }

    @Override
    public String toString() {
        return "Estadio{" +
                "zonas=" + Arrays.toString(zonas) +
                '}';
    }
}
