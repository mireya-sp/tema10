package com.mireyaserrano.tema10.ejericio07;

import java.util.Random;
import java.util.UUID;

public class Aleatorios {
    private static Random random = new Random();

    /**
     * metodo que crea una secuencia alfanumérica random para la caja fuerte de la zona VIP
     * @return el codigo alfanumérico
     */
    public static String codigoCajaFuerte(){
        UUID codigo = UUID.randomUUID();
        return codigo.toString();
    }

    /**
     * Metodo que crea el número de lotería
     * @param asientosTotales El número de asientos que tiene el estadio
     * @return el número para la lotería del descanso
     */
    public static int numLoteria(int asientosTotales){
        return random.nextInt(1,asientosTotales+1);
    }
}
