package com.ActividadesConVectores;

//import java.util.Arrays;
import java.util.Scanner;

public class ordenamientoInsercion {

	public static void main(String[] args) {	// Es el main del programa
		
		// Crear un array de elementos de tipos int o double y alamcenar 10 notas que se vayan introduciendo por teclado
		// Modificar el anterior para introducir el tamaño del vector por teclado
		// Prueba a usar el atributo lengh para recorrer el vector completo y mostrar el contenido por pantalla	
				
		System.out.println("Introduce un numero para declarar la dimension del array, por favor");		// Pedimos un numero al usuario para que el determine la dimension del array
		Scanner dimensionUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
		int dimension = dimensionUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
		int posicionArray = 0;		// Declaramos una variable para la posicion del array y la inicializamos a 0
		
		int [] orden = new int [dimension];		// Creamos un array llamado notas y lo igualamos a la variable dimension para que la longitud del vector sea igual a la que nos introduce el usuario 
		
		for (int i = dimension; i > 0; i--) {		// Hacemos un bucle for que vaya desde lo que nos introduce el usuario hasta 0 
		
			System.out.println("Introduce los numeros que quieres insertar: ");

			Scanner numUsuario = new Scanner(System.in);    // Insertamos los numeros que quiere el usuario
			int insercion = numUsuario.nextInt();			// Y los leemos con el scanner
			System.out.println(insercion);
			
			orden[posicionArray] = insercion;		// Insertamos los datos que quiere de tipo entero en cada posicion (0, 1, 2...) que tiene el array
			
			System.out.println("Se va a hacer la insercion de: " + orden[posicionArray]);		// Mostramos el resultado por pantalla
			posicionArray++;		// Vamos recorriendo la posicion de 1 en 1
			
			System.out.println(" ················································· ");

			
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println(" --------------- El vector sin ordenar con los datos queda: --------------- ");
		
		for (int i = 0; i < dimension; i++) {
			
			System.out.println("En la posicion: "+ i + " está el dato: " + orden[i]);

		}
		
		
		System.out.println(" -------------------------------------------------------------------------- ");
		System.out.println("");
		System.out.println("");
		
		// Metodo por insercion
		
		int aux;	// Variable auxiliar para el intercambio de valores.

		for (int i = 1; i < dimension; i++){	// Empezamos en 1
			aux = orden[i];	// Guardamos el valor a ordenar.
			int j = i - 1;
			while ( (j >= 0) && orden[j] > aux )	// Siempre que sea mayor que aux.
								// ordenamos de menor a mayor.
				orden[j+1] = orden[j--];	// Trasladamos el valor y movemos el indice.
			orden [j+1] = aux;	// Ponemos el valor a ordenar en su sitio.
		}	

		
		System.out.println(" --------------- El vector ordenado con los datos queda: ------------------ ");
		
		for (int i = 0; i < dimension; i++) {
			
			System.out.println("En la posicion: "+ i + " está el dato: " + orden[i]);

		}

		System.out.println(" -------------------------------------------------------------------------- ");


		/*
		System.out.println("El array ordenado queda como: ");
		
		for (int i = 0; i < notas.length; i++) {		// Hacemos otro bucle for para recorrer el vector y mostrar el resultado por pantalla
			
			Arrays.sort(notas);		// Con el sort ordenamos el vector
			
			System.out.println(i + " (posicion en el vector) " + " -- " + notas[i]); // Mostramos el resultado por pantalla

		}
		*/


     
		
///////			
	}
} 
