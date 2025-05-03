package com.mireyaserrano.tema10.ejercicio03;

import java.util.Arrays;

public abstract class Coche {
    private final String matricula;
    private int velActual;
    private int marchaActual;
    private final int[] marchas;

    public Coche(String matricula, int[] marchas) {
        this.matricula = matricula;
        velActual = 0;
        marchaActual = 0;
        this.marchas = marchas;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getVelActual() {
        return velActual;
    }

    public void setVelActual(int velActual) {
        this.velActual = velActual;
    }

    public int getMarchaActual() {
        return marchaActual;
    }

    public void setMarchaActual(int marchaActual) {
        this.marchaActual = marchaActual;
    }

    public int[] getMarchas() {
        return marchas;
    }

    private void acelerar(int valor){

    }

    private void frenar(int valor){

    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velActual=" + velActual +
                ", marchaActual=" + marchaActual +
                ", marchas=" + Arrays.toString(marchas) +
                '}';
    }

    protected void cambiarMarcha(int marchaACambiar){
        marchaActual = marchaACambiar;
    }
}
