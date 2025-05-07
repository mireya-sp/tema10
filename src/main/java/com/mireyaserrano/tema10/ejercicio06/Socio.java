package com.mireyaserrano.tema10.ejercicio06;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Socio {
    private String nif;
    private String nombre;
    private LocalDate fechaNac;
    private String poblacion;
    private List<Integer> recargos;

    public Socio(String nif, String nombre, LocalDate fechaNac, String poblacion) {
        if (!isMayorEdad(fechaNac)){
            return;
        }
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.poblacion = poblacion;
        recargos = new ArrayList<>();
    }

    private boolean isMayorEdad(LocalDate fechaNac){
        if (Period.between(fechaNac, LocalDate.now()).getYears() < 18){
            return false;
        }
        return true;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public List<Integer> getRecargos() {
        return recargos;
    }

    public void setRecargos(List<Integer> recargos) {
        this.recargos = recargos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(nif, socio.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nif);
    }
}
