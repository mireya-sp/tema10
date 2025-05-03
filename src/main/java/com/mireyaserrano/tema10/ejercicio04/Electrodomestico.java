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
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(letraConsumo);
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
        letra = Character.toUpperCase(letra);
        if (letra == ' '){return CONSUMO_DEFAULT;}
        ConsumoEnergetico[] valores = ConsumoEnergetico.values();
        for (int i = 0; i < ConsumoEnergetico.values().length; i++){
            if (letra == valores[i].toString().charAt(0)){
                return valores[i];
            }
        }
        return CONSUMO_DEFAULT;
    }

    //Hacer trim antes de pasar el String
    private Color comprobarColor(String color){
        color = color.toUpperCase().trim();
        if (color == null || color.equals("")){
            return COLOR_DEFAULT;
        }
        Color[] colores = Color.values();
        for (int i = 0; i < Color.values().length; i++) {
            if (color.equals(colores[i].toString())){
                return colores[i];
            }
        }
        return COLOR_DEFAULT;
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
