package com.mireyaserrano.tema10.ejercicio03;

public class CocheCambioManual extends Coche{

    public CocheCambioManual(String matricula, int[] marchas) {
        super(matricula, marchas);
    }

    @Override
    public void cambiarMarcha(int marchaACambiar){
        if (marchaACambiar < 0){
            return;
        }
        int[] vel = getMarchas();
        for (int i = 0; i < vel.length; i++){
            if (marchaACambiar-1 == i){
                setVelActual(vel[i]);
            }
        }
        setMarchaActual(marchaACambiar);
    }
}
