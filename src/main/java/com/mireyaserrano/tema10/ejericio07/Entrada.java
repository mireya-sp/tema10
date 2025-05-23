package com.mireyaserrano.tema10.ejericio07;

import java.util.Objects;

public abstract class Entrada {
    private int id = 0;

    private int numEntrada;
    private int precio;
    private Partido partido;
    private Zona zona;
    private Fila fila;
    private Asiento numAsiento;

    public Entrada(Partido partido, Zona zona, Fila fila, Asiento numAsiento, int precioBase) {
        this.numEntrada = ++id;
        this.precio = precioPartido(precioBase);
        this.partido = partido;
        this.zona = zona;
        this.fila = fila;
        this.numAsiento = numAsiento;
    }

    public int getNumEntrada() {
        return numEntrada;
    }

    public int getPrecio() {
        return precio;
    }

    public Partido getPartido() {
        return partido;
    }

    public Zona getZona() {
        return zona;
    }

    public Fila getFila() {
        return fila;
    }

    public Asiento getNumAsiento() {
        return numAsiento;
    }

    public void vendida(){
        numAsiento.setOcupado(true);
    }

    /**
     * Calcula el precio del partido según la afluencia de éste
     * @param precioBase El precio base de la entrada
     * @return el precio del partido según la afluencia del partido
     */
    private int precioPartido(int precioBase){
        int precioFinal = 0;
        switch (Objects.requireNonNull(partido).getTipoPartido()){
            case BAJA_AFLUENCIA -> {precioFinal = (precioBase * 75) / 100;}
            case MEDIA_AFLUENCIA -> {precioFinal = precioBase;}
            case ALTA_AFLUENCIA -> {precioFinal = (precioBase * 130) / 100;}
        }
        return precioFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return numEntrada == entrada.numEntrada;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numEntrada);
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "numEntrada=" + numEntrada +
                ", precio=" + precio +
                ", partido=" + partido +
                ", zona=" + zona +
                ", fila=" + fila +
                ", numAsiento=" + numAsiento +
                '}';
    }
}
