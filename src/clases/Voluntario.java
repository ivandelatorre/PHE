package clases;

public class Voluntario extends Persona {
    private String email;
    private String telefono;
    private boolean autoriza_com;
    private boolean autoriza_gdpd;

    public Voluntario(String email, String telefono, boolean autoriza_com, boolean autoriza_gdpd) {
        this.email = email;
        this.telefono = telefono;
        this.autoriza_com = autoriza_com;
        this.autoriza_gdpd = autoriza_gdpd;
    }

    public Voluntario(String nombre, String apellidos, String fecha_nac, String email, String telefono, boolean autoriza_com, boolean autoriza_gdpd) {
        super(nombre, apellidos, fecha_nac);
        this.email = email;
        this.telefono = telefono;
        this.autoriza_com = autoriza_com;
        this.autoriza_gdpd = autoriza_gdpd;
    }

    public Voluntario(int cod, String nombre, String apellidos, String fecha_nac, String email, String telefono, boolean autoriza_com, boolean autoriza_gdpd) {
        super(cod, nombre, apellidos, fecha_nac);
        this.email = email;
        this.telefono = telefono;
        this.autoriza_com = autoriza_com;
        this.autoriza_gdpd = autoriza_gdpd;
    }

    public Voluntario(int cod, String nombre, String apellidos, String fecha_nac, String email, String telefono) {
        super(cod, nombre, apellidos, fecha_nac);
        this.email = email;
        this.telefono = telefono;
    }

    public Voluntario(String nombre, String apellidos, String fecha_nac, String email, String telefono) {
        super(nombre, apellidos, fecha_nac);
        this.email = email;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isAutoriza_com() {
        return autoriza_com;
    }

    public void setAutoriza_com(boolean autoriza_com) {
        this.autoriza_com = autoriza_com;
    }

    public boolean isAutoriza_gdpd() {
        return autoriza_gdpd;
    }

    public void setAutoriza_gdpd(boolean autoriza_gdpd) {
        this.autoriza_gdpd = autoriza_gdpd;
    }
}
