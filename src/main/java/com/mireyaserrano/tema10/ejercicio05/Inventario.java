package com.mireyaserrano.tema10.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Items> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "Items=" + inventario +
                '}';
    }
}
