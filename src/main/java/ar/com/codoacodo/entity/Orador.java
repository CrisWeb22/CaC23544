package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class Orador {
	//atributos - encapsulamiento
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private String tema;
	private LocalDate fechaAlta;
	
	//constructores EN ESTOS CONSTRUCUTORES VEMOS SOBRECARGA (DENTRO DE LA MISMA CLASE ES).
	//usar cuando envio un objeto a la BD
	public Orador(String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		init(nombre, apellido, mail, tema, fechaAlta);
	}
	//alt+shift+S

	public Orador(Long id, String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		this.id = id;
		init(nombre, apellido, mail, tema, fechaAlta);
	}
	
	private void init(String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
		this.fechaAlta = fechaAlta;
	}

	//cambiar un metodo ToString() de la clase Object
	//otra forma de POLIMORFISMO: SOBRESCRITURA, metodo que existe en una clase base (java.lang.Orador)
	//pero que su hijo (Orador) lo cambia
	@Override //segun carlos no es necesario
	public String toString() {
		return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema="
				+ tema + ", fechaAlta=" + fechaAlta + "]";
	}

	//getters/setters
	public Long getId() {
		return id;
	}

	
	/*
	public void setId(Long id) {
		this.id = id;
	}
	*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null) {
			this.nombre = nombre;
		}else {
			this.nombre = "N/D";
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
