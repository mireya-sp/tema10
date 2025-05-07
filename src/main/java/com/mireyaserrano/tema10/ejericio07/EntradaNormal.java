package com.mireyaserrano.tema10.ejericio07;

public class EntradaNormal extends Entrada{
    private int numLoteria;

    public EntradaNormal(int precio, Partido partido, Zona zona, Fila fila, Asiento numAsiento, int numAsientosTotal, int precioBase) {
        super(partido, zona, fila, numAsiento, precioBase);
        this.numLoteria = Aleatorios.numLoteria(numAsientosTotal);
    }

    public int getNumLoteria() {
        return numLoteria;
    }

    @Override
    public String toString() {
        return "EntradaNormal{" +
                "numLoteria=" + numLoteria +
                '}';
    }
}
