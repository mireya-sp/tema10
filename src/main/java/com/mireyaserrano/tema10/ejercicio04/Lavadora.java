package com.mireyaserrano.tema10.ejercicio04;

public class Lavadora extends Electrodomestico{
    private final int CARGA_DEFAULT = 5;

    private final int carga;

    public Lavadora(){
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(int precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(int precioBase, String color, char letraConsumo, double peso, int carga) {
        super(precioBase, color, letraConsumo, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    protected int precioFinal(){
        int precioFinal = super.precioFinal();
        if (carga > 30){
            precioFinal += 50;
        }
        return precioFinal;
    }
}
