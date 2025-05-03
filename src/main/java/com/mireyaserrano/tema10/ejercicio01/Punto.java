package com.mireyaserrano.tema10.ejercicio01;

public class Punto {
    private double x;
    private double y;

    public Punto (double x, double y){
        this.x = x;
        this.y = y;
    }

    public Punto (){
        x = 0;
        y = 0;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto punto){
        double distanciaEntreX = punto.getX() - x;
        double distanciaEntreY = punto.getY() - y;
        return Math.sqrt((distanciaEntreX * distanciaEntreX) + (distanciaEntreY * distanciaEntreY));
    }

    @Override
    public String toString(){
        return "Punto = (" + x + "," + y + ")";
    }
}
