package com.mireyaserrano.tema10.ejercicio04;

public abstract class Electrodomestico {
    //Config por defecto
    private final Color COLOR_DEFAULT = Color.BLANCO;
    private final ConsumoEnergetico CONSUMO_DEFAULT = ConsumoEnergetico.F;
    private final int PRECIO_DEFAULT = 100;
    private final double PESO_DEFAULT = 5;
    //------------------


    protected int precioBase;
    protected Color color;
    protected final ConsumoEnergetico consumoEnergetico;
    protected final double peso;


    //Constructor default
    public Electrodomestico(){
        this.precioBase = PRECIO_DEFAULT;
        this.color = COLOR_DEFAULT;
        this.consumoEnergetico = CONSUMO_DEFAULT;
        this.peso = PESO_DEFAULT;
    }

    //Constructor precio y peso
    public Electrodomestico(int precioBase, double peso){
        this.precioBase = precioBase;
        this.color = COLOR_DEFAULT;
        this.consumoEnergetico = CONSUMO_DEFAULT;
        this.peso = peso;
    }

    //Constructor completo
    public Electrodomestico(int precioBase, String color, char letraConsumo, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color.trim().toLowerCase());
        this.consumoEnergetico = comprobarConsumoEnergetico(Character.toUpperCase(letraConsumo));
        this.peso = peso;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public Color getColor() {
        return color;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    //Requiere trim en el scanner y castearlo de String a char
    private ConsumoEnergetico comprobarConsumoEnergetico(char letra){
        switch (letra){
            case 'A' -> {return ConsumoEnergetico.A;}
            case 'B' -> {return ConsumoEnergetico.B;}
            case 'C' -> {return ConsumoEnergetico.C;}
            case 'D' -> {return ConsumoEnergetico.D;}
            case 'E' -> {return ConsumoEnergetico.E;}
            case 'F' -> {return ConsumoEnergetico.F;}
            default -> {return CONSUMO_DEFAULT;}
        }
    }

    //Hacer trim antes de pasar el String
    private Color comprobarColor(String color){
        switch(color){
            case "blanco" -> {return Color.BLANCO;}
            case "negro" -> {return Color.NEGRO;}
            case "rojo" -> {return Color.ROJO;}
            case "azul" -> {return Color.AZUL;}
            case "gris" -> {return Color.GRIS;}
            default -> {return Color.BLANCO;}
        }
    }

    protected int precioFinal(){
        int precioFinal = precioBase;
        switch (consumoEnergetico){
            case A -> precioFinal += 100;
            case B -> precioFinal += 80;
            case C -> precioFinal += 60;
            case D -> precioFinal += 50;
            case E -> precioFinal += 30;
            case F -> precioFinal += 10;
        }

        if (peso >= 0 && peso <= 19){
            precioFinal += 10;
        } else if (peso >= 20 && peso <= 49) {
            precioFinal += 50;
        } else if (peso >= 50 && peso <= 79) {
            precioFinal += 80;
        } else if (peso > 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }
}
