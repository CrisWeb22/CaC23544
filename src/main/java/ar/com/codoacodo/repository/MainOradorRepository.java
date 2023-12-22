package ar.com.codoacodo.repository;

import java.time.LocalDate;
import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {

	public static void main(String[] args) {
		
		OradorRepository repository = new MySqlOradorRepository();
		
		Orador cristian =repository.getById(1L);
		
		cristian.setNombre("Cristiancito");
		cristian.setTema("privatizaciones");
		
		repository.update(cristian);
		
		
		System.out.println(repository.findAll());

	}

}
