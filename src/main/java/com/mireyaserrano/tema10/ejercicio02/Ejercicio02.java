package com.mireyaserrano.tema10.ejercicio02;

import com.mireyaserrano.tema10.ejercicio01.Punto;
import java.util.ArrayList;

public class Ejercicio02 {
    public static void main(String[] args){
        ArrayList<Punto> puntos = new ArrayList<>();
        puntos.add(new Punto());
        puntos.add(new Punto(2, 0));
        puntos.add(new Punto(2, 2));
        puntos.add(new Punto(0, 2));

        Poligono poligono = new Poligono(puntos);
        System.out.println(poligono);
        System.out.println(poligono.perimetro());
        poligono.traslada(4, -3);
        System.out.println(poligono);
    }
}
