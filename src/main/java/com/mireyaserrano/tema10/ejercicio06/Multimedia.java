package com.mireyaserrano.tema10.ejercicio06;

import java.util.Objects;

public class Multimedia {
    private String titulo;
    private String autor;
    private Formato formato;
    private int anyo;

    public Multimedia(String titulo, String autor, Formato formato, int anyo) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", formato=" + formato +
                ", anyo=" + anyo +
                '}';
    }
}
