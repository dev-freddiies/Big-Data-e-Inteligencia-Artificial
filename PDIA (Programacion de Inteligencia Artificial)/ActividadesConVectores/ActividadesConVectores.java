package com.ActividadesConVectores;

import java.util.Scanner;

public class ActividadesConVectores {

	public static void main(String[] args) {	// Es el main del programa
		
		// Crear un array de elementos de tipos int o double y alamcenar 10 notas que se vayan introduciendo por teclado
		// Modificar el anterior para introducir el tamaño del vector por teclado
		// Prueba a usar el atributo lengh para recorrer el vector completo y mostrar el contenido por pantalla	
				
		System.out.println("Introduce un numero para declarar la dimension del array, por favor"); 
		Scanner dimensionUsuario = new Scanner(System.in);    
		int dimension = dimensionUsuario.nextInt();
		int posicionArray = 0;
		
		int [] notas = new int [dimension];
		
		for (int i = dimension; i > 0; i--) {
		
			System.out.println("Introduce los numeros que quieres insertar: ");

			Scanner numUsuario = new Scanner(System.in);    
			int insercion = numUsuario.nextInt();		
			System.out.println(insercion);
			
			notas[posicionArray] = insercion;
			
			System.out.println("Se va a hacer la insercion de: " + notas[posicionArray]);
			posicionArray++;
			
			System.out.println(" ················································· ");

			
		}
		
		
		for (int i = 0; i < notas.length; i++) {
			
			System.out.println("En la posicion: " + i + " se ha insertado el dato: " + notas[i]);
		
		}
        
		
///////			
	}
} 
