package com.mireyaserrano.tema10.ejercicio02;

import com.mireyaserrano.tema10.ejercicio01.Punto;

import java.util.ArrayList;
import java.util.List;

public class Poligono {
    List<Punto> puntos;

    public Poligono(ArrayList<Punto> puntos){
        this.puntos = puntos;
    }

    public void traslada(double trasX, double trasY){
        for (int i = 0; i < puntos.size(); i++) {
            puntos.get(i).setX(puntos.get(i).getX() + trasX);
            puntos.get(i).setY(puntos.get(i).getY() + trasY);
        }
    }

    public int numVertices(){
        return puntos.size();
    }

    @Override
    public String toString() {
        return "Poligono{" +
                "puntos=" + puntos +
                '}';
    }

    public double perimetro(){
        double perimetro = 0;
        for (int i = 0; i < puntos.size(); i++) {
            if (( i+1) < puntos.size()) {
                perimetro += puntos.get(i).distancia(puntos.get(i+1));
            }else{
                perimetro += puntos.get(i).distancia(puntos.get(0));
                break;
            }
        }
        return perimetro;
    }
}
