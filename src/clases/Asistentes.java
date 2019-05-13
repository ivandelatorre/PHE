package clases;

public class Asistentes {
    private int cod_voluntario;
    private int cod_evento;

    public Asistentes() {
    }

    public Asistentes(int cod_voluntario, int cod_evento) {
        this.cod_voluntario = cod_voluntario;
        this.cod_evento = cod_evento;
    }

    public int getCod_voluntario() {
        return cod_voluntario;
    }

    public void setCod_voluntario(int cod_voluntario) {
        this.cod_voluntario = cod_voluntario;
    }

    public int getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(int cod_evento) {
        this.cod_evento = cod_evento;
    }

    @Override
    public String toString() {
        return "Asistentes{" +
                "cod_voluntario=" + cod_voluntario +
                ", cod_evento=" + cod_evento +
                '}';
    }
}