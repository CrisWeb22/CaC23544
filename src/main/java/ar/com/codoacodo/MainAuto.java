package ar.com.codoacodo;

public class MainAuto {
	
	public static void main(String[] args) {
		//instanciar un objeto de la clase Auto
		Auto clio = new Auto("Renault",
				"Clio",
				"azul",
				2020,
				3f);
		
		clio.encender();
		clio.acelerar();
		clio.frenar();
		clio.frenar();
	}

}
