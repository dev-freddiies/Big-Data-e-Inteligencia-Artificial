package com.ActividadesConVectores;

import java.util.Scanner;

public class palindromo {

	public static void main(String[] args) {	// Es el main del programa
			
		System.out.println("Introduce un nombre para saber si es palindromo");

		Scanner cadenaUsuario = new Scanner(System.in);    		// Insertamos los nombres que quiere el usuario
		String cadena = cadenaUsuario.nextLine();			// Y los leemos con el scanner
		char aux;
	
		char [] palindromo = cadena.toCharArray();
		int dimension = cadena.length(); 	// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado, pero  con la length que es la dimesion del array que nos introducen
		
		System.out.println("Numero de letras de tu palabra: " + dimension);
		
		System.out.println(" ------------------------------------------------------------------ ");
		System.out.println("    La palabra: " + cadena + " con la forma de un array quedaría: ");		// Mostramos por pantalla
		System.out.println(" ------------------------------------------------------------------ ");
		


		for (int i = 0; i < palindromo.length; i++) {		// Hacemos un bucle for que vaya desde lo que nos introduce el usuario hasta 0 
			
			System.out.println(palindromo[i]);		// Mostramos por pantalla el array
			
		}
		
		
		for (int i = 0; i < palindromo.length / 2; i++) {		// Creamos el array desde el indice igualado a 0 hasta la dimension del array llamado palindromo, pero entre dos e incrementandolo de uno en uno

			aux = palindromo[i];		// Creamos una variable auxiliar y la igualamos al array que hemos creado anteriormente
			palindromo[i] = palindromo[palindromo.length - 1 -i];		// El array palindromo, lo igualamos a que su dimension menos 1 menos el indice
			palindromo[palindromo.length - 1 -i] = aux;		// Rellenamos el array con la variable auxiliar
			
		}
		
		System.out.println("");

		if (String.valueOf(palindromo).equals(cadena)) {		// Como no podemos igualar un string un char necesitamos el valueof y equals
			
			System.out.println(" ······························ ");
			System.out.println(cadena + "  ¡ Es un palindromo ! ");		//	Mostramos el resultado por pantalla
			System.out.println(" ······························ ");

			
		} else {
			
			System.out.println(" ······························ ");
			System.out.println(cadena + " ¡ NO es un palindromo ! ");
			System.out.println(" ······························ ");


		}

		
///////			
	}
} 
