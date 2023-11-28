package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class Orador {
	//atributos
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

	//otra forma de POLIMORFISMO: SOBRESCRITURA, metodo que existe en una clase base (java.lang.Orador)
	//pero que su hijo (Orador) lo cambia
	@Override //segun carlos no es necesario
	public String toString() {
		return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema="
				+ tema + ", fechaAlta=" + fechaAlta + "]";
	}
	
	//cambiar un metodo ToString() de la clase Object
	
	
	
	
	
	
	
	
}
