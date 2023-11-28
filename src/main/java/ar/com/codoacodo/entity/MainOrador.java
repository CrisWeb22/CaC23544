package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class MainOrador {

	public static void main(String[] args) {
		Orador nuevoOrador = new Orador("Cristian", "Olmedo", "email@email.com", "JAVA", LocalDate.now());
		
		System.out.println(nuevoOrador);
	}

}
