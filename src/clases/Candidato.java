package clases;

import java.sql.Date;

public class Candidato extends Persona {
     private String lugar_nac;
     private String municipio;
     private String provincia;
     private String autonomia;

    public Candidato() {

    }

    public Candidato(String lugar_nac, String municipio, String provincia, String autonomia) {
        this.lugar_nac = lugar_nac;
        this.municipio = municipio;
        this.provincia = provincia;
        this.autonomia = autonomia;
    }

    public Candidato(int cod, String nombre, String apellidos, String fecha_nac, String lugar_nac, String municipio, String provincia, String autonomia) {
        super(cod, nombre, apellidos, fecha_nac);
        this.lugar_nac = lugar_nac;
        this.municipio = municipio;
        this.provincia = provincia;
        this.autonomia = autonomia;
    }

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }
}