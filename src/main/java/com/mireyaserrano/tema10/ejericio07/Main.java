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

    /**
     * menu principal
     */
    private static void menu(){
        System.out.println("1. Nuevo partido\n" +
                "2. Gestión de entradas\n" +
                "0. Salir");
    }


    /**
     * submenu para la gestion de entradas
     */
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

    /**
     * Metodo para crear objetos partido
     */
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

    /**
     * Opcion de gestion de entradas
     */
    private static void gestionEntradas(){
        int opcion;
        do{
            int idPartido;
            boolean validar;
            do {
                System.out.println(partidos);
                System.out.println("Introduce la id del partido.");
                idPartido = Integer.parseInt(scanner.nextLine());
                validar = idPartido > 0 && idPartido < partidos.size();
                if (!validar){
                    System.out.println("Introduce la id de un partido válido");
                }
            }while (!validar);
            int indicePartido = idPartido - 1;
            menuGestionEntradas();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> System.out.println("Venta");
                case 2 -> devolucion();
                case 3 -> System.out.println(partidos.get(indicePartido).ocupados());
                case 4 -> System.out.println(partidos.get(indicePartido).libres());
                case 5 -> System.out.printf("El dinero acumulado por la venta de entradas es %d", recaudacion());
                default -> System.out.println("Por favor introduzca una opción válida.");
            }
        }while(opcion != 0);
    }

    /**
     * menu de tipos de partidos para escoger fácil
     */
    private static void tiposPartidos(){
        System.out.println("1. Baja Afluencia\n2. Media Afluencia\n3. Alta Afluencia");
    }

    /**
     * devolucion de entrada, busca la entrada con el id introducido y la elimina del arraylist de entradas
     */
    private static void devolucion(){
        System.out.println("Introduce el número identificador de la entrada");
        int id = Integer.parseInt(scanner.nextLine());
        for (Entrada entrada : entradas){
            if (entrada.getNumEntrada() == id){
                entradas.remove(entrada);
            }
        }
    }

    /**
     * Recorre el arraylis de la estradas sumando el precio
     * @return La recaudación total del partido
     */
    private static int recaudacion(){
        int precio = 0;
        for (Entrada entrada : entradas) {
            precio += entrada.getPrecio();
        }
        return precio;
    }
}
