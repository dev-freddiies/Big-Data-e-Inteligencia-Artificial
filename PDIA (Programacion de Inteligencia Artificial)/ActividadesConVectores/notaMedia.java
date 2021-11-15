package com.ActividadesConVectores;

import java.util.Scanner;

public class notaMedia {

	public static void main(String[] args) {	// Es el main del programa
				
		System.out.println("Introduce un numero para declarar el numero de alumnos");		// Pedimos un numero al usuario para que el determine la dimension del array
		Scanner dimensionUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
		
		int dimension = dimensionUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
		int posicionArray = 0;
		float suma = 0;		// Declaramos una variable suma para la hacer la suma de los datos introducidos en el array y la inicializamos a 0 y es de tipo float porque necesitamos decimales para el resultado
		float calcularMedia = 0;		// Declaramos una variable media y la inicializamos a 0
		
		int [] notas = new int [dimension];		// Creamos un array llamado notas y lo igualamos a la variable dimension para que la longitud del vector sea igual a la que nos introduce el usuario
		
		for (int i = dimension; i > 0; i--) {		// Hacemos un bucle for que vaya desde lo que nos introduce el usuario hasta 0 
		
			System.out.println("Introduce los numeros que quieres insertar: ");

			Scanner numUsuario = new Scanner(System.in);    // Insertamos los numeros que quiere el usuario
			int insercion = numUsuario.nextInt();			// Y los leemos con el scanner
			

			System.out.println(insercion);
			

			notas[posicionArray] = insercion;		// Insertamos los datos que quiere de tipo entero en cada posicion (0, 1, 2...) que tiene el array
			
			System.out.println("Se va a hacer la insercion de: " + notas[posicionArray]);		// Mostramos el resultado por pantalla
			posicionArray++;		// Vamos recorriendo la posicion de 1 en 1
			
			System.out.println(" ················································· ");	        
			
		}
		
		
		for (int i = 0; i < notas.length; i++) {		// Hacemos otro bucle for para recorrer el vector y mostrar el resultado por pantalla
					
				System.out.println("En la posicion: " + i + " se ha insertado el dato: " + notas[i]);
				
		}
		
		for (int i = 0; i < notas.length; i++) {
			
            suma = suma + notas[i]; 	// Sumamos los datos que nos van introduciendo
            calcularMedia = suma / notas.length;		// Y calculamos la media dividiendo la suma total entre el numero de datos que nos han introducido

		}
		
		System.out.println(" ················································· ");	        

		System.out.println("La media es: " + calcularMedia + " -- Por que: " + suma + " / " + notas.length + " = " + calcularMedia);
        
		
///////			
	}
} 

