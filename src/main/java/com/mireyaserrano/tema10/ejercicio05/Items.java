package com.mireyaserrano.tema10.ejercicio05;

import java.util.Objects;

public abstract class Items {
    private final String nombre;
    protected int cantMax;

    public Items(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return cantMax == items.cantMax && Objects.equals(nombre, items.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantMax);
    }
}
