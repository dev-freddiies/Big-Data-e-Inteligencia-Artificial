package examenPelicula;

import java.util.Scanner;

public class PruebasPelicula {
	
	public static void main(String[] args) {	// Es el main del programa
		
		Pelicula pelicula1 = new Pelicula("Trainspotting", "Danny Boyle", 1, 0);
		
		
		
		
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- PELICULA 1 --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("Titulo: " + pelicula1.titulo);
				System.out.println("Director: " + pelicula1.director);
				System.out.println("Ejemplares: " + pelicula1.ejemplares);
				System.out.println("Prestadas: " + pelicula1.prestadas);
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

				
				
		Pelicula pelicula2 = new Pelicula();

		
		
				System.out.println("Introduce un titulo, por favor");
				Scanner tituloPelicula2 = new Scanner(System.in);    		
				String titulo = tituloPelicula2.nextLine();		
				
				System.out.println("Introduce el director, por favor");
				Scanner directorPelicula2 = new Scanner(System.in);    		
				String director = directorPelicula2.nextLine();				
				
				System.out.println("Introduce los ejemplares, por favor");
				Scanner ejemplaresPelicula2 = new Scanner(System.in);    		
				int ejemplares = ejemplaresPelicula2.nextInt();
				
				
		pelicula2.setTitulo(titulo);
		pelicula2.setDirector(director);
		pelicula2.setEjemplares(ejemplares);
		
				
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- PELICULA 2 --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("Titulo: " + pelicula2.titulo);
				System.out.println("Director: " + pelicula2.director);
				System.out.println("Ejemplares: " + pelicula2.ejemplares );
				System.out.println("Prestadas: " + pelicula2.prestadas);
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				
				
	if (pelicula1.prestamo()) {
		
		System.out.println("Se ha prestado la pelicula: " + pelicula1.titulo);

	} else {
		
		System.out.println("NO se ha prestado la pelicula: " + pelicula1.titulo);
		
	}
	
	if (pelicula1.devolucion()) {
		
		System.out.println("Se ha devuelto la pelicula: " + pelicula1.titulo);

	} else {
		
		System.out.println("NO se ha devuelto la pelicula: " + pelicula1.titulo);
		
	}

	/*
	System.out.println("Introduce la dimension del array, por favor");
	Scanner dimensionArray = new Scanner(System.in);    		
	int dimension = dimensionArray.nextInt();
	
	int posicionArray = 0;		// Declaramos una variable para la posicion del array y la inicializamos a 0

	
	String [] peliculas = new String[dimension];		// Declaramos un array de tipo string llamado nombres de dimension introducida por teclado
	
	for (int i = dimension; i > 0; i--) {		// Hacemos un bucle for que vaya desde lo que nos introduce el usuario hasta 0 
		
		peliculas[posicionArray] = pelicula1	// Insertamos los datos que quiere de tipo entero en cada posicion (0, 1, 2...) que tiene el array
				
		System.out.println("Se va a hacer la insercion de: " + peliculas[posicionArray]);		// Mostramos el resultado por pantalla

		posicionArray++;		// Vamos recorriendo la posicion de 1 en 1
		
		System.out.println(" ················································· ");
		
	}
	*/
					
////////////////
					
	}
}