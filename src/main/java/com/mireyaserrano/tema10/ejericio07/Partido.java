package com.mireyaserrano.tema10.ejericio07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Partido {
    private int count = 0;

    private int idPartido;
    private TipoPartido tipoPartido;
    private LocalDate fechaPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private Estadio estadio;

    public Partido(TipoPartido tipoPartido, LocalDate fechaPartido, String equipoLocal, String equipoVisitante) {
        this.idPartido = ++count;
        this.tipoPartido = tipoPartido;
        this.fechaPartido = fechaPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estadio = new Estadio();
    }

    public int getIdPartido() {
        return idPartido;
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

    /**
     * Metodo que encuentra los asientos ocupados del partido
     * @return El arrayList con los asientos que ya están ocupados
     */
    public ArrayList<Asiento> ocupados(){
        ArrayList<Asiento> asientosArray = new ArrayList<>();
        for (Zona zona : estadio.getZonas()) {
            for (Fila fila : zona.getFilas()) {
                for (Asiento asiento : fila.getAsientos()) {
                    if (asiento.isOcupado()) {
                        asientosArray.add(asiento);
                    }
                }
            }
        }
        return asientosArray;
    }

    /**
     * Metodo que encuentra los asientos libres del partido
     * @return EL arrayList con los asientos libres
     */
    public ArrayList<Asiento> libres(){
        ArrayList<Asiento> asientosArray = new ArrayList<>();
        for (Zona zona : estadio.getZonas()) {
            for (Fila fila : zona.getFilas()) {
                for (Asiento asiento : fila.getAsientos()) {
                    if (!asiento.isOcupado()) {
                        asientosArray.add(asiento);
                    }
                }
            }
        }
        return asientosArray;
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
                "idPartido=" + idPartido +
                ", tipoPartido=" + tipoPartido +
                ", fechaPartido=" + fechaPartido +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisitante='" + equipoVisitante + '\'' +
                ", estadio=" + estadio +
                '}';
    }
}
