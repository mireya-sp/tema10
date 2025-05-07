package com.mireyaserrano.tema10.ejericio07;

import java.util.Random;
import java.util.UUID;

public class Aleatorios {
    private static Random random = new Random();

    public static String codigoCajaFuerte(){
        UUID codigo = UUID.randomUUID();
        return codigo.toString();
    }

    public static int numLoteria(int asientosTotales){
        return random.nextInt(1,asientosTotales+1);
    }
}
