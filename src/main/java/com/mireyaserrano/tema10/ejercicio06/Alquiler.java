package com.mireyaserrano.tema10.ejercicio06;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Alquiler {
    private final int DIAS_MAX = 3;

    private Multimedia objetoAlquilado;
    private Socio socio;
    private int precioBase;
    private final LocalDate fehcaAlquiler;
    private boolean devuelto;

    public Alquiler(Multimedia objetoAlquilado, Socio socio, LocalDate fehcaAlquiler) {
        this.objetoAlquilado = objetoAlquilado;
        this.socio = socio;
        this.precioBase = precioBase();
        this.fehcaAlquiler = fehcaAlquiler;
        this.devuelto = false;
    }

    public Multimedia getObjetoAlquilado() {
        return objetoAlquilado;
    }

    public Socio getSocio() {
        return socio;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public LocalDate getFehcaAlquiler() {
        return fehcaAlquiler;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        int recargo = 0;
        if (devuelto){
            int dias = Period.between(fehcaAlquiler, LocalDate.now()).getDays();
            int diasRetraso;
            if (dias > DIAS_MAX){
                diasRetraso = DIAS_MAX - dias;
                recargo = 2*diasRetraso;
            }
            List<Integer> recargosSocio = socio.getRecargos();
            recargosSocio.add(recargo);
            socio.setRecargos(recargosSocio);
        }
    }

    private int precioBase(){
        if ( (objetoAlquilado instanceof Pelicula && objetoAlquilado.getAnyo() < 2012) || (objetoAlquilado instanceof Videojuego && objetoAlquilado.getAnyo() < 2010)){
          return 3;
        }
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alquiler alquiler = (Alquiler) o;
        return Objects.equals(objetoAlquilado, alquiler.objetoAlquilado) && Objects.equals(socio, alquiler.socio) && Objects.equals(fehcaAlquiler, alquiler.fehcaAlquiler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objetoAlquilado, socio, fehcaAlquiler);
    }
}
