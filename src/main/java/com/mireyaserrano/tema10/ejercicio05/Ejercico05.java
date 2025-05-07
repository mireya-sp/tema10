package com.mireyaserrano.tema10.ejercicio05;

import java.util.Scanner;

public class Ejercico05 {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventario inventario = new Inventario();

    private static void menuPrincipal(){
        System.out.println("1. Añadir al inventario\n" +
                "2. Eliminar del inventario\n" +
                "3. Mostrar inventario\n" +
                "0. Salir");
    }

    private static void opcionItems(){
        System.out.println("1. Pico\n2. Espada\n3.Piedra\n4. Madera\n5. Huevo\n6.Perla de Ender\n0. Volver al menu principal");
    }

    public static void main(String[] args){
        int opcion;
        do{
            menuPrincipal();
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> anyadirItem();
                case 2 -> eliminarItem();
                case 3 -> System.out.println(inventario);
                default -> System.out.println("Por favor seleccione una opción válida");
            }
        }while (opcion != 0);
    }

    private static void anyadirItem(){
        int opcion;
        do {
            opcionItems();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Volviendo al menú principal...");
                case 1 -> ;
                case 2 -> ;
                case 3 -> ;
                case 4 -> ;
                case 5 -> ;
                case 6 -> ;
                default -> System.out.println("Por favor seleccione una opción vália");
            }
        }while (opcion != 0);
    }

    private static void eliminarItem(){
        int opcion;
        do {
            opcionItems();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Volviendo al menú principal...");
                case 1 -> ;
                case 2 -> ;
                case 3 -> ;
                case 4 -> ;
                case 5 -> ;
                case 6 -> ;
                default -> System.out.println("Por favor seleccione una opción válida");
            }
        }while (opcion != 0);
    }

}
