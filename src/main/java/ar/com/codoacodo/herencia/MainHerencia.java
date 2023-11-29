package ar.com.codoacodo.herencia;

public class MainHerencia {

	public static void main(String[] args) {
		
		Articulo a1 = new Articulo("tituloUno", 15.2f, "www.url/imagen.png");
		a1.setAutor("Kobencius");
		//System.out.println(a1);
		
		
		Musica m1 = new Musica("Las locas aventuras de Koba", 52.45f, "urldemuisca/lop.png");
		m1.setAutor("KobeTheDog");
		String [] temas = new String[] {"t1", "t2", "t3"};
		m1.setTemas(temas);
		//System.out.println(m1);
		
		
		Articulo p1 = new Pelicula("hola", 10.3f, "wwwurl/peli");
		//System.out.println(p1);
		Pelicula peli = (Pelicula)p1; //down casting
		peli.setFormato("BLUE RAY");
		peli.setProductora("Warner");
		p1.setAutor("autor de la pelicula");
		//System.out.println(p1);
		//GC: Garbage Collector
		
		//vector para guardar las instancias
		Articulo[] resultados = new Articulo[3];
		resultados[0] = a1;
		resultados[1] = m1;
		resultados[2] = p1;
		
		for(Articulo aux : resultados) {
			System.out.println(aux);
		}
	}

}
