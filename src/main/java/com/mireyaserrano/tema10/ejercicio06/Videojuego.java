package com.mireyaserrano.tema10.ejercicio06;

public class Videojuego extends Multimedia{
    private String plataforma;

    public Videojuego(String titulo, String autor, Formato formato, int anyo, String plataforma) {
        super(titulo, autor, formato, anyo);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "plataforma='" + plataforma + '\'' +
                '}';
    }
}
