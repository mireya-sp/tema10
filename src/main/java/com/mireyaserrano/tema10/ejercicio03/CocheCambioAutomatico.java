package com.mireyaserrano.tema10.ejercicio03;

public class CocheCambioAutomatico extends Coche{

    public CocheCambioAutomatico(String matricula, int[] marchas) {
        super(matricula, marchas);
    }

    public void acelerar(int valor){
        if (valor < 1){
            return;
        }
        int[] marchas = getMarchas();
        int velNueva = getVelActual() + valor;
        int aux = 0;
        for (int i = 0; i < marchas.length; i++) {
            if (velNueva > aux && velNueva <= marchas[i+1]){
                setMarchaActual(i);
            }
            aux = marchas[i];
        }
        setVelActual(velNueva);
    }

    public void frenar(int valor){
        if (valor < 1){
            return;
        }
        int[] marchas = getMarchas();
        if (getVelActual() - valor < marchas[getMarchaActual() - 1]){
            setMarchaActual(getMarchaActual() - 1);
            setVelActual(getVelActual() - valor);
        }else{
            setVelActual(getVelActual() - valor);
        }
    }
}
