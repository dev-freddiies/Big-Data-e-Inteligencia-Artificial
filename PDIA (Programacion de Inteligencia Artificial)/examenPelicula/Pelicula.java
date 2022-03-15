package examenPelicula;

public class Pelicula {

	/*
	# Matricula: String
	# Marca: String
	# Tarifa: doble
	# Color: String
	# Disponible: booleano
	# kilometrajeTotal: int
	
	-- getter
	-- setter
	-- void recorre(int km)
	*/

	
	
	
	
	//  --- --- --- --- --- --- VARIABLES DE LA CLASE --- --- --- --- --- ---  //	
	
	public String titulo;
	public String director;
	public int ejemplares;
	public int prestadas;

	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	
	
	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

		Pelicula () {
	
			
		}
		
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
		
		
		
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	Pelicula (String titulo, String director, int ejemplares, int prestadas) {
		
		this.titulo = titulo;
		this.director = director;
		this.ejemplares = ejemplares;
		this.prestadas = prestadas;

		
	}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
	// --- --- --- --- --- --- --- GETTER Y SETTER --- --- --- --- --- --- --- //
		
	public String getTitulo(String titulo) {
		
		return titulo;
		
	}
	public void setTitulo(String titulo) {
		
		this.titulo = titulo;
		
	}
	
	// --- ---
	
	public String getDirector(String director) {
	
		return director;
		
	}
	public void setDirector(String director) {
	
		this.director = director;
		
	}
	
	// --- ---
	
	public int getEjemplares(int ejemplares) {
		
		return ejemplares;
		
	}
	public void setEjemplares(int ejemplares) {
	
		this.ejemplares = ejemplares;
		
	}
	
	

	public int getPrestadas(int prestadas) {
		
		return prestadas;
		
	}
	public void setPrestadas(int prestadas) {
	
		this.prestadas = prestadas;
		
	}
	

	// --- ---
	
	
	public boolean prestamo() {
		
		boolean prestado = true;
		
		if ((prestadas < ejemplares)) {
			
			prestadas++;
			
		} else {
			
			prestado = false;
			
		}
		
		return prestado;
		
	}

	
	
	public boolean devolucion() {
		
		boolean devuelto = true;
		
		if ((prestadas == 0)) {
			
			devuelto = false;
			
		} else {
			
			prestadas--;
			
		}
		
		return devuelto;
		
	}
	
	
	public String toString() {
		
		return "El titulo de la pelicula es: " + titulo + " el autor de la obra es: " + director + " ejemplares vendidos: " + ejemplares + " numero de peliculas prestadas: " + prestadas;
	
	}
	
	
	
	
	
	
	
	
///////////	
}