package com.mireyaserrano.tema10.ejercicio06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Multimedia> multimedia = new ArrayList<>();
    private static ArrayList<Socio> socios = new ArrayList<>();
    private static ArrayList<Alquiler> alquileres = new ArrayList<>();

    private static void menuPrincipal(){
        System.out.println("1. Altas...\n2. Alquilar multimedia a socio\n3. Devolver multimedia\n4. Listados...\n0. Salir");
    }

    private static void menuAltas(){
        System.out.println("1. Alta de una nueva Película\n" +
                "2. Alta de un nuevo Videojuego\n" +
                "3. Alta de un nuevo socio\n0. Volver al menú principal");
    }

    private static void menuListados(){
        System.out.println("1. Listado de todos los objetos multimedia\n" +
                "2. Listado de todas las películas ordenadas por título\n" +
                "3. Listado de todos los videojuegos ordenados por año\n" +
                "4. Listado del histórico de alquileres de un socio ordenados por fecha de alquiler\n" +
                "5. Listado de los alquileres actuales de un socio\n" +
                "6. Listado de los socios con recargos pendientes\n0. Volver al menú principal");
    }

    private static void formatos(){
        System.out.println("1. CD\n2. DVD\n3. BLUE-RAY\n4.ARCHIVO");
    }

    public static void main(String[] args){
        int opcion;
        do{
            menuPrincipal();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> opcionAltas();
                case 2 -> alquilar();
                case 3 -> devolver();
                case 4 -> opcionListados();
                default -> System.out.println("Por favor introduzca una opcion válida");
            }
        }while(opcion != 0);
    }

    private static void opcionAltas(){
        int opcion;
        do {
            menuAltas();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Saliendo al menú principal...");
                case 1 -> altaPelicula();
                case 2 -> altaVideojuego();
                case 3 -> altaSocio();
                default -> System.out.println("Por favor introduzca una opcion válida");
            }
        }while(opcion != 0);
    }

    private static void altaPelicula(){
        String titulo;
        String autor;
        Formato formato = Formato.CD;
        int anyo = 0;
        double duracion = 1;
        String actorPrincipal;
        String actrizPrincipal;
        boolean validado;

        do {
            System.out.println("Titulo película: ");
            titulo = scanner.nextLine();
            validado = titulo.length() > 2;
            if (!validado) {
                System.out.println("El título debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println("Autor: ");
            autor = scanner.nextLine();
            validado = autor.length() > 2;
            if (!validado) {
                System.out.println("El autor debe tener almenos 2 caracteres");
            }
        } while (!validado);

        int aux = 0;
        for (Multimedia value : multimedia){
            if (value.equals(new Pelicula(titulo, autor, null, anyo, duracion, null, null))){
                System.out.println("La pelicula ya existe");
                aux = 1;
            }
        }

        if (aux == 0) {
            int opcionFormato = 0;
            do {
                formatos();
                opcionFormato = Integer.parseInt(scanner.nextLine());
                switch (opcionFormato) {
                    case 1 -> formato = Formato.CD;
                    case 2 -> formato = Formato.DVD;
                    case 3 -> formato = Formato.BLU_RAY;
                    case 4 -> formato = Formato.ARCHIVO;
                    default -> System.out.println("Por favor introduzca una opción válida");
                }
                validado = opcionFormato == 1 || opcionFormato == 2 || opcionFormato == 3 || opcionFormato == 4;
            } while (!validado);

            do {
                System.out.println("Año de publicación: ");
                anyo = Integer.parseInt(scanner.nextLine());
                validado = anyo > 1895 && anyo < (LocalDate.now().getYear() + 1);
                if (!validado) {
                    System.out.println("Año no válido");
                }
            } while (validado);

            do {
                System.out.println("Duracion de la película: ej.(1,5)h");
                duracion = Double.parseDouble(scanner.nextLine());
                validado = duracion >= 1 && duracion < 15;
                if (!validado) {
                    System.out.println("La duración mínima para considerarse película es de 1 hora y no acepto peliculas de 15 horas o más.");
                }
            } while (!validado);

            do {
                System.out.println("Nombre y apellidos del actor principal: ");
                actorPrincipal = scanner.nextLine();
                validado = actorPrincipal.length() > 2;
                if (!validado) {
                    System.out.println("El actor principal debe tener almenos 2 caracteres");
                }
            } while (!validado);

            do {
                System.out.println("Nombre y apellidos de la actriz principal: ");
                actrizPrincipal = scanner.nextLine();
                validado = actrizPrincipal.length() > 2;
                if (!validado) {
                    System.out.println("El actor principal debe tener almenos 2 caracteres");
                }
            } while (!validado);

            Pelicula peli = new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
            multimedia.add(peli);
        }

    }

    private static void altaVideojuego(){
        String titulo;
        String autor;
        Formato formato = Formato.CD;
        int anyo = 0;
        String plataforma;
        boolean validado;

        do {
            System.out.println("Titulo videojuego: ");
            titulo = scanner.nextLine();
            validado = titulo.length() > 2;
            if (!validado) {
                System.out.println("El título debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println("Autor: ");
            autor = scanner.nextLine();
            validado = autor.length() > 2;
            if (!validado) {
                System.out.println("El autor debe tener almenos 2 caracteres");
            }
        } while (!validado);

        int aux = 0;
        for (Multimedia value : multimedia){
            if (value.equals(new Videojuego(titulo, autor, null, anyo, null))){
                System.out.println("La pelicula ya existe");
                aux = 1;
            }
        }

        if (aux == 0) {
            int opcionFormato = 0;
            do {
                formatos();
                opcionFormato = Integer.parseInt(scanner.nextLine());
                switch (opcionFormato) {
                    case 1 -> formato = Formato.CD;
                    case 2 -> formato = Formato.DVD;
                    case 3 -> formato = Formato.BLU_RAY;
                    case 4 -> formato = Formato.ARCHIVO;
                    default -> System.out.println("Por favor introduzca una opción válida");
                }
                validado = opcionFormato == 1 || opcionFormato == 2 || opcionFormato == 3 || opcionFormato == 4;
            } while (!validado);

            do {
                System.out.println("Año de publicación: ");
                anyo = Integer.parseInt(scanner.nextLine());
                validado = anyo > 1895 && anyo < (LocalDate.now().getYear() + 1);
                if (!validado) {
                    System.out.println("Año no válido");
                }
            } while (validado);

            do {
                System.out.println("Plataforma del videojuego: ");
                plataforma = scanner.nextLine();
                validado = plataforma.length() > 2;
                if (!validado) {
                    System.out.println("La plataforma debe tener almenos 2 caracteres");
                }
            } while (!validado);

            Videojuego juego = new Videojuego(titulo, autor, formato, anyo, plataforma);
            multimedia.add(juego);
        }
    }

    private static void altaSocio(){
        String nif;
        String nombre;
        String fechaNacimientoString;
        LocalDate fechaNac = LocalDate.now();
        String poblacion;
        boolean validado = false;

        do {
            System.out.println("Introduce el NIF del socio: ");
            nif = scanner.nextLine();
            if (nif.length() == 9) {
                for (int i = 0; i < nif.length(); i++) {
                    if (Character.isDigit(nif.charAt(i)) && i < nif.length() - 1) {
                        validado = true;
                    } else if (Character.isLetter(nif.charAt(i)) && i != nif.length() - 1) {
                        validado = false;
                    }
                }
            }
            if (!validado) {
                System.out.println("El NIF debe tener 8 números seguido de una letra mayusculas");
            }
        } while (!validado);

        int aux = 0;
        for (Socio value : socios){
            if (value.equals(new Socio(nif, null, null, null))){
                System.out.println("El socio ya existe.");
                aux = 1;
            }
        }

        if (aux == 0) {
            do {
                System.out.println("Nombre del socio: ");
                nombre = scanner.nextLine();
                validado = nombre.length() > 2;
                if (!validado) {
                    System.out.println("El nombre debe tener almenos 2 caracteres");
                }
            } while (!validado);

            do {
                System.out.println("Fecha nacimiento (dd-mm-yyyy): ");
                fechaNacimientoString = scanner.nextLine();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                try {
                    fechaNac = LocalDate.parse(fechaNacimientoString, dateTimeFormatter);
                    validado = true;
                } catch (DateTimeParseException dtpe) {
                    validado = false;
                    System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd-mm-yyyy).");
                }
            } while (!validado);

            do {
                System.out.println("Población: ");
                poblacion = scanner.nextLine();
                validado = poblacion.length() > 2;
                if (!validado) {
                    System.out.println("La población debe tener almenos 2 caracteres");
                }
            } while (!validado);

            Socio socio = new Socio(nif, nombre, fechaNac, poblacion);
            socios.add(socio);
        }
    }



    private static void alquilar(){
        String nif;
        String titulo;
        String autor;
        LocalDate fechaAlquiler = LocalDate.now();
        boolean validado = false;

        do {
            System.out.println("Introduce el NIF del socio: ");
            nif = scanner.nextLine();
            if (nif.length() == 9) {
                for (int i = 0; i < nif.length(); i++) {
                    if (Character.isDigit(nif.charAt(i)) && i < nif.length() - 1) {
                        validado = true;
                    } else if (Character.isLetter(nif.charAt(i)) && i != nif.length() - 1) {
                        validado = false;
                    }
                }
            }
            if (!validado) {
                System.out.println("El NIF debe tener 8 números seguido de una letra mayusculas");
            }
        } while (!validado);

        do {
            System.out.println("Titulo de la multimedia a alquilar: ");
            titulo = scanner.nextLine();
            validado = titulo.length() > 2;
            if (!validado) {
                System.out.println("El título debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println("Autor de la multimeda a alquilar: ");
            autor = scanner.nextLine();
            validado = autor.length() > 2;
            if (!validado) {
                System.out.println("El autor debe tener almenos 2 caracteres");
            }
        } while (!validado);

        int indiceSocio = -1;
        int indiceMultiedia = -1;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getNif().equals(nif)){
                indiceSocio = i;
            }
        }

        if (indiceSocio != -1){
            for (int i = 0; i < multimedia.size(); i++) {
                if (multimedia.get(i).getTitulo().equals(titulo) && multimedia.get(i).getAutor().equals(autor)){
                    indiceMultiedia = i;
                }
            }

            if (indiceMultiedia != -1){
                // Aquí deberia recorrer el array de Alquileres para ver si la multimedia esta alquilada en el momento y mirar que el socio no tenga recargos pendientes
                alquileres.add(new Alquiler(multimedia.get(indiceMultiedia), socios.get(indiceSocio), fechaAlquiler));
            }else {
                System.out.println("No existe una multimedia con este Titulo y Autor");
            }
        }else {
            System.out.println("No existe un socio con este NIF.");
        }

    }

    private static void devolver(){
        String nif;
        String titulo;
        String autor;
        String fechaAlquilerString;
        LocalDate fechaAlquiler = null;
        boolean validado = false;

        do {
            System.out.println("Introduce el NIF del socio: ");
            nif = scanner.nextLine();
            if (nif.length() == 9) {
                for (int i = 0; i < nif.length(); i++) {
                    if (Character.isDigit(nif.charAt(i)) && i < nif.length() - 1) {
                        validado = true;
                    } else if (Character.isLetter(nif.charAt(i)) && i != nif.length() - 1) {
                        validado = false;
                    }
                }
            }
            if (!validado) {
                System.out.println("El NIF debe tener 8 números seguido de una letra mayusculas");
            }
        } while (!validado);

        do {
            System.out.println("Titulo de la multimedia a devolver: ");
            titulo = scanner.nextLine();
            validado = titulo.length() > 2;
            if (!validado) {
                System.out.println("El título debe tener almenos 2 caracteres");
            }
        } while (!validado);

        do {
            System.out.println("Autor de la multimeda a devolver: ");
            autor = scanner.nextLine();
            validado = autor.length() > 2;
            if (!validado) {
                System.out.println("El autor debe tener almenos 2 caracteres");
            }
        } while (!validado);

        int indiceSocio = -1;
        int indiceMultiedia = -1;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getNif().equals(nif)){
                indiceSocio = i;
            }
        }

        if (indiceSocio != -1){
            for (int i = 0; i < multimedia.size(); i++) {
                if (multimedia.get(i).getTitulo().equals(titulo) && multimedia.get(i).getAutor().equals(autor)){
                    indiceMultiedia = i;
                }
            }

            if (indiceMultiedia != -1){
                do {
                    System.out.println("Fecha de alquiler (dd-mm-yyyy): ");
                    fechaAlquilerString = scanner.nextLine();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    try {
                        fechaAlquiler = LocalDate.parse(fechaAlquilerString, dateTimeFormatter);
                        validado = true;
                    } catch (DateTimeParseException dtpe) {
                        validado = false;
                        System.out.println("El formato de la fecha de alquiler no es válido. Recuerde (dd-mm-yyyy).");
                    }
                } while (!validado);
                int indiceAlquiler = -1;
                for (int i = 0; i < alquileres.size(); i++){
                    if (alquileres.get(i).equals(new Alquiler(multimedia.get(indiceMultiedia), socios.get(indiceSocio), fechaAlquiler))){
                        indiceAlquiler = i;
                    }
                }

                if (indiceAlquiler != -1){
                    alquileres.get(indiceAlquiler).setDevuelto(true);
                }

            }else {
                System.out.println("No existe una multimedia con este Titulo y Autor");
            }
        }else {
            System.out.println("No existe un socio con este NIF.");
        }
    }

    public static void opcionListados(){
        int opcion = 0;
        do {
            menuListados();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 0 -> System.out.println("Volviendo al menu prinipal...");
                case 1 ->{
                    System.out.println(multimedia.toString());
                }
                case 2 ->{}
                case 3 ->{}
                case 4 ->{}
                case 5 ->{}
                case 6 ->{}
                default -> System.out.println("Por favor introduzca una opcion válida");
            }
        }while (opcion != 0);
    }
}
