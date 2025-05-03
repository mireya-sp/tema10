package com.mireyaserrano.tema10.ejercicio04;

import java.util.ArrayList;

public class Ejercicio04 {
    private static ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>(10);

    public static void main(String[] args){
        electrodomesticos.add(new Lavadora(250, "Negro", 'c', 58, 15));
        electrodomesticos.add(new Television(120, "Gris", 'a', 4, 38, false));
        electrodomesticos.add(new Lavadora(600, "Blanco", 'a', 50, 45));
        electrodomesticos.add(new Television(700, "Azul", 'd', 6, 60, true));

        int importeTeles = 0;
        int importeLavadoras = 0;
        int importeTotal = 0;
        for (int i = 0; i < electrodomesticos.size(); i++) {
            System.out.println(electrodomesticos.get(i).precioFinal());
            importeTotal += electrodomesticos.get(i).precioFinal();
            if (electrodomesticos.get(i) instanceof Lavadora){
                importeLavadoras += electrodomesticos.get(i).precioFinal();
            }else {
                importeTeles += electrodomesticos.get(i).precioFinal();
            }
        }

        System.out.println("Importe Lavadoras: " + importeLavadoras);
        System.out.println("Importe Televisores: " + importeTeles);
        System.out.println("Total: " + importeTotal);
    }
}
