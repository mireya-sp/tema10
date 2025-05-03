package com.mireyaserrano.tema10.ejercicio03;

import java.util.Scanner;

public class Ejercicio03 {
    private static Scanner scanner = new Scanner(System.in);

    private static int[] marchas = {18, 28, 48, 70, 85};

    public static void main(String[] args){
        System.out.println("Introduce la matrícula del coche: ");
        String matricula = scanner.nextLine();
        System.out.println("El coche es de cambio automático? (s/n)");
        String automatico = scanner.nextLine();
        if (automatico.equals("s")){
            CocheCambioAutomatico coche = new CocheCambioAutomatico(matricula, marchas);
            System.out.println(coche);
            coche.acelerar(60);
            System.out.println(coche);
        }else {
            CocheCambioManual coche = new CocheCambioManual(matricula, marchas);
            System.out.println(coche);
            coche.cambiarMarcha(3);
            System.out.println(coche);
        }
    }
}
