package clases;

import java.sql.Date;
import java.sql.Time;

public class Evento {
    private int cod_evento;
    private String descripcion;
    private String ubicacion;
    private Date dia;
    private Time hora;
    private String nombre;
    private int cod_campanna;
    private String municipio;

    public Evento() {
    }

    public Evento(int cod_evento, String descripcion, String ubicacion, Date dia, Time hora, String nombre, int cod_campanna, String municipio) {
        this.cod_evento = cod_evento;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.dia = dia;
        this.hora = hora;
        this.nombre = nombre;
        this.cod_campanna = cod_campanna;
        this.municipio = municipio;
    }

    public int getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(int cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCod_campanna() {
        return cod_campanna;
    }

    public void setCod_campanna(int cod_campanna) {
        this.cod_campanna = cod_campanna;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
