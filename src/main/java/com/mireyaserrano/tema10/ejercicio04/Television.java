package com.mireyaserrano.tema10.ejercicio04;

public class Television extends Electrodomestico{
    private final double RESOULUCION_DEFAULT = 20;
    private final boolean SMARTTV_DEFAULT = false;

    private final double resolucion;
    private final boolean smartTV;

    public Television() {
        this.resolucion = RESOULUCION_DEFAULT;
        this.smartTV = SMARTTV_DEFAULT;
    }

    public Television(int precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOULUCION_DEFAULT;
        this.smartTV = SMARTTV_DEFAULT;
    }

    public Television(int precioBase, String color, char letraConsumo, double peso, double resolucion, boolean smartTV) {
        super(precioBase, color, letraConsumo, peso);
        this.resolucion = resolucion;
        this.smartTV = smartTV;
    }

    public double getResolucion() {
        return resolucion;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    @Override
    protected int precioFinal() {
        int precioFinal = super.precioFinal();
        if (resolucion > 40){
            precioFinal += (precioFinal * 30) / 100;
        }
        if (smartTV){
            precioFinal += 50;
        }
        return precioFinal;
    }
}
