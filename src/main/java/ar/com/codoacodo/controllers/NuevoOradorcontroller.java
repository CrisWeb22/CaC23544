package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.repository.MySqlOradorRepository;
import ar.com.codoacodo.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/orador")
public class NuevoOradorcontroller extends HttpServlet {
	
	private OradorRepository repository = new MySqlOradorRepository();
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		//response.addHeader("Access-Control-Allow-Origin", "*");
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
		
		//Usandp jackson2 convierto de String a objeto java
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		OradorRequest oradorRequest = mapper.readValue(json, OradorRequest.class);
		
		//Creacion del orador con los parametros
		Orador nuevo = new Orador (
				oradorRequest.getNombre(),
				oradorRequest.getApellido(),
				oradorRequest.getEmail(),
				oradorRequest.getTema(),
				LocalDate.now()
		);
		
		repository.save(nuevo);
		
		//Respuesta al front, paso inverso
		String jsonParaEnviar = mapper.writeValueAsString(nuevo);
		
		response.getWriter().print(jsonParaEnviar);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Orador> listado = this.repository.findAll();
		
		//Conversion de objeto java a Json para el front
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		String jsonParaEnviar = mapper.writeValueAsString(listado);
		
		response.getWriter().print(jsonParaEnviar);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		OradorRepository repository = new MySqlOradorRepository();
		
		repository.delete(Long.parseLong(id));
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
		
		//Usandp jackson2 convierto de String a objeto java
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		OradorRequest oradorRequest = mapper.readValue(json, OradorRequest.class);
		
		Orador orador = this.repository.getById(Long.parseLong(id));
		
		orador.setApellido(oradorRequest.getApellido());
		orador.setNombre(oradorRequest.getNombre());
		orador.setMail(oradorRequest.getEmail());
		orador.setTema(oradorRequest.getTema());
		
		this.repository.update(orador);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
