package com.mireyaserrano.tema10.ejercicio04;

public enum Color {
    BLANCO("Color Blanco"),
    NEGRO("Color Negro"),
    ROJO("Color Rojo"),
    AZUL("Color Azul"),
    GRIS("Color Gris");

    private String texto;

    Color(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
