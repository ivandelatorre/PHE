package clases;

import java.sql.Date;

<<<<<<< HEAD
public class Voluntario extends Persona {
    private int cod_voluntario;
    private String nombre;
    private String apellidos;
    private String fecha_nac;
=======
public class Voluntario {
    private int cod_voluntario;
    private String nombre;
    private String apellidos;
    private Date fecha_nac;
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
    private String email;
    private String telefono;
    private boolean autoriza_com;
    private boolean autoriza_gdpd;

<<<<<<< HEAD

    public Voluntario(int cod, String nombre, String apellidos, String fecha_nac) {
		super(cod, nombre, apellidos, fecha_nac);
	}


	public Voluntario(int cod, String nombre, String apellidos, String fecha_nac, int cod_voluntario, String nombre2,
			String apellidos2, String fecha_nac2, String email, String telefono, boolean autoriza_com,
			boolean autoriza_gdpd) {
		super(cod, nombre, apellidos, fecha_nac);
		this.cod_voluntario = cod_voluntario;
		nombre = nombre2;
		apellidos = apellidos2;
		fecha_nac = fecha_nac2;
		this.email = email;
		this.telefono = telefono;
		this.autoriza_com = autoriza_com;
		this.autoriza_gdpd = autoriza_gdpd;
	}

	
=======
    public Voluntario() {
    }

    public Voluntario(int cod_voluntario, String nombre, String apellidos, Date fecha_nac, String email, String telefono, boolean autoriza_com, boolean autoriza_gdpd) {
        this.cod_voluntario = cod_voluntario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.email = email;
        this.telefono = telefono;
        this.autoriza_com = autoriza_com;
        this.autoriza_gdpd = autoriza_gdpd;
    }
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3

    public int getCod_voluntario() {
        return cod_voluntario;
    }

    public void setCod_voluntario(int cod_voluntario) {
        this.cod_voluntario = cod_voluntario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

<<<<<<< HEAD
    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
=======
    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
        this.fecha_nac = fecha_nac;
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
