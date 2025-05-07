package com.mireyaserrano.tema10.ejericio07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Entrada> entradas = new ArrayList<>();
    private static ArrayList<Partido> partidos = new ArrayList<>();
    
    private static Scanner scanner = new Scanner(System.in);

    private static void menu(){
        System.out.println("1. Nuevo partido\n" +
                "2. Gestión de entradas\n" +
                "0. Salir");
    }

    private static void menuGestionEntradas(){
        System.out.println("1. Venta de entradas\n" +
                "2. Devolver una entrada\n" +
                "3. Listado de localidades ocupadas\n" +
                "4. Listado de localidades libres\n" +
                "5. Mostrar recaudación del partido\n" +
                "0. Volver al menú principal");
    }

    public static void main(String[] args){
        int opcion = 0;
        do{
            menu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> nuevoPartido();
                case 2 -> gestionEntradas();
                default -> System.out.println("Por favor introduzca una opción válida.");
            }
        }while(opcion != 0);
    }

    private static void nuevoPartido(){
        TipoPartido tipoPartido = null;
        String fechaPartidoString;
        LocalDate fechaPartido = null;
        String equipoLocal;
        String equipoVisitante;
        boolean validado;
        int opcionTipoPartido;
        do {
            tiposPartidos();
            opcionTipoPartido = Integer.parseInt(scanner.nextLine());
            switch (opcionTipoPartido){
                case 1 -> tipoPartido = TipoPartido.BAJA_AFLUENCIA;
                case 2 -> tipoPartido = TipoPartido.MEDIA_AFLUENCIA;
                case 3 -> tipoPartido = TipoPartido.ALTA_AFLUENCIA;
                default -> System.out.println("Por favor introduzca una opción válida.");
            }
            validado = opcionTipoPartido == 1 || opcionTipoPartido == 2 || opcionTipoPartido == 3;
        }while (!validado);
        do {
            System.out.println("Fecha del partido (dd-mm-yyyy): ");
            fechaPartidoString = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                fechaPartido = LocalDate.parse(fechaPartidoString, dateTimeFormatter);
                validado = true;
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha del partido no es válido. Recuerde (dd-mm-yyyy).");
            }
        } while (!validado);
        do {
            System.out.println("Equipo local: ");
            equipoLocal = scanner.nextLine();
            validado = equipoLocal.length() > 2;
            if (!validado) {
                System.out.println("El equipo local debe tener almenos 2 caracteres");
            }
        } while (!validado);
        do {
            System.out.println("Equipo visitante: ");
            equipoVisitante = scanner.nextLine();
            validado = equipoVisitante.length() > 2;
            if (!validado) {
                System.out.println("El equipo visitante debe tener almenos 2 caracteres");
            }
        } while (!validado);
        boolean existe = false;
        for (Partido value : partidos){
            if (value.equals(new Partido(tipoPartido, fechaPartido, equipoLocal, equipoVisitante))){
                System.out.println("Este partido ya existe.");
                existe = true;
            }
        }
        if (!existe){
            partidos.add(new Partido(tipoPartido, fechaPartido, equipoLocal, equipoVisitante));
        }
    }

    private static void gestionEntradas(){
        int opcion;
        do{
            menuGestionEntradas();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> venta();
                case 2 -> devolucion();
                case 3 -> ocupadas(1);
                case 4 -> libres();
                case 5 -> recaudacion();
                default -> System.out.println("Por favor introduzca una opción válida.");
            }
        }while(opcion != 0);
    }

    private static void tiposPartidos(){
        System.out.println("1. Baja Afluencia\n2. Media Afluencia\n3. Alta Afluencia");
    }

    private static void venta(){

    }

    private static void devolucion(){

    }

    private static void ocupadas(int indicePartido){
        for (int i = 0; i < partidos.get(indicePartido).getEstadio().getZonas().length; i++) {
            for (int j = 0; j < partidos.get(indicePartido).getEstadio().getZonas()[i].getFilas().length; j++) {
                for (int k = 0; k < partidos.get(indicePartido).getEstadio().getZonas()[i].getFilas()[j].getAsientos().length; k++) {
                    if (partidos.get(indicePartido).getEstadio().getZonas()[i].getFilas()[j].getAsientos()[k].isOcupado()){
                        System.out.println(partidos.get(indicePartido).getEstadio().getZonas()[i].getFilas()[j].getAsientos()[k].toString());
                    }
                }
            }
        }
    }

    private static void libres(){
        Zona[] zonas;
        Fila[] filas;
        Asiento[] asientos;
        for (int i = 0; i < partidos.size(); i++) {
            zonas = partidos.get(i).getEstadio().getZonas();
            for (int j = 0; j < zonas.length; j++) {
                filas = zonas[j].getFilas();
                for (int k = 0; k < filas.length; k++) {
                    asientos = filas[k].getAsientos();
                    for (int l = 0; l < asientos.length; l++) {
                        if (!asientos[l].isOcupado()){
                            System.out.println(asientos[l].toString());
                        }
                    }
                }
            }
        }
    }

    private static void recaudacion(){

    }
}
