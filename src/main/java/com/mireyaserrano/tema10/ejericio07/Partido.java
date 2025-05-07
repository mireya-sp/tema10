package com.mireyaserrano.tema10.ejericio07;

import java.time.LocalDate;
import java.util.Objects;

public class Partido {
    private TipoPartido tipoPartido;
    private LocalDate fechaPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private Estadio estadio;

    public Partido(TipoPartido tipoPartido, LocalDate fechaPartido, String equipoLocal, String equipoVisitante) {
        this.tipoPartido = tipoPartido;
        this.fechaPartido = fechaPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estadio = new Estadio();
    }

    public TipoPartido getTipoPartido() {
        return tipoPartido;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(fechaPartido, partido.fechaPartido) && Objects.equals(equipoLocal, partido.equipoLocal) && Objects.equals(equipoVisitante, partido.equipoVisitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaPartido, equipoLocal, equipoVisitante);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "tipoPartido=" + tipoPartido +
                ", fechaPartido=" + fechaPartido +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisitante='" + equipoVisitante + '\'' +
                ", estadio=" + estadio +
                '}';
    }
}
