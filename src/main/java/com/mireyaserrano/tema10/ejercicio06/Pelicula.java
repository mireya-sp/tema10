package com.mireyaserrano.tema10.ejercicio06;

public class Pelicula extends Multimedia{
    private double duracion;
    private String actorPrincipal;
    private String actrizPrincipal;

    public Pelicula(String titulo, String autor, Formato formato, int anyo, double duracion, String actorPrincipal, String actrizPrincipal) {
        super(titulo, autor, formato, anyo);
        this.duracion = duracion;
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + super.getTitulo() + '\'' +
                ", autor='" + super.getAutor() + '\'' +
                ", formato=" + super.getFormato() +
                ", anyo=" + super.getAnyo() +
                ", duracion=" + duracion +
                ", actorPrincipal='" + actorPrincipal + '\'' +
                ", actrizPrincipal='" + actrizPrincipal +
                '}';
    }
}
