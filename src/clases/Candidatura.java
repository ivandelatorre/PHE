package clases;

public class Candidatura {
    private int cod_candidato;
    private int cod_campanna;
    private String cabeza_lista;
    private int posicion;

    public Candidatura(int cod_candidato, int cod_campanna, String cabeza_lista, int posicion) {
        this.cod_candidato = cod_candidato;
        this.cod_campanna = cod_campanna;
        this.cabeza_lista = cabeza_lista;
        this.posicion = posicion;
    }

    public Candidatura() {
    }

    public int getCod_candidato() {
        return cod_candidato;
    }

    public void setCod_candidato(int cod_candidato) {
        this.cod_candidato = cod_candidato;
    }

    public int getCod_campanna() {
        return cod_campanna;
    }

    public void setCod_campanna(int cod_campanna) {
        this.cod_campanna = cod_campanna;
    }

    public String getCabeza_lista() {
        return cabeza_lista;
    }

    public void setCabeza_lista(String cabeza_lista) {
        this.cabeza_lista = cabeza_lista;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
