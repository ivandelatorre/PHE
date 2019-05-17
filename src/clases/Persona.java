package clases;

import java.sql.Date;

public class Persona {
	private int cod;
    private String nombre;
    private String apellidos;
    private String fecha_nac;

	public Persona() {
	}

	public Persona(int cod, String nombre, String apellidos, String fecha_nac) {
		this.cod = cod;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nac = fecha_nac;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
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

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
}
