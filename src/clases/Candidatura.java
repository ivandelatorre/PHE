package clases;

public class Candidatura {
    private int cod_candidato;
    private int cod_campanna;
    private boolean cabeza_lista;
    private int posicion;

    public Candidatura(int anInt, int rsInt, String string, int i) {
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

    public boolean isCabeza_lista() {
        return cabeza_lista;
    }

    public void setCabeza_lista(boolean cabeza_lista) {
        this.cabeza_lista = cabeza_lista;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
