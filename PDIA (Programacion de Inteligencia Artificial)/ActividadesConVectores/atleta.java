package com.ActividadesConVectores;

import java.util.Scanner;

public class atleta {

	public static void main(String[] args) {	// Es el main del programa
				
		System.out.println("Introduce un numero para saber cuantos atletas hay, por favor");		// Pedimos un numero al usuario para que el determine la dimension del array
		Scanner dimensionUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
		int dimension = dimensionUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
		int posicionArray = 0;		// Declaramos una variable para la posicion del array y la inicializamos a 0
		
		String atletaMejor = "";	// Nos declaramos una variable de tipo String para el mejor atleta
		String atletaPeor = ""; 	// Otra para el peor
		
		float mejor;		// Una variable de tipo float, porque pueden llevar decimales para el mejor tiempo
		float peor;
				
		String [] nombres = new String[dimension];		// Declaramos un array de tipo string llamado nombres de dimension introducida por teclado
		
		float [] tiempos = new float[dimension];		// Lo mismo pero para los tiempos de tipo float
 		
		for (int i = dimension; i > 0; i--) {		// Hacemos un bucle for que vaya desde lo que nos introduce el usuario hasta 0 
		
			System.out.println("Introduce el nombre del atleta que quieras insertar");

			Scanner nombreUsuario = new Scanner(System.in);    		// Insertamos los nombres que quiere el usuario
			String insercion = nombreUsuario.nextLine();			// Y los leemos con el scanner
			
			System.out.println(" ");		// Motivo de estetica

			System.out.println(insercion);		
			
			System.out.println(" ------------------------------------------ ");		

			System.out.println("Introduce el tiempo que ha hecho: ");		// Pedimos el tiempo que ha hecho

			Scanner tiempoUsuario = new Scanner(System.in);    			// Insertamos los numeros que quiere el usuario
			float insercionTiempos = tiempoUsuario.nextFloat();			// Y los leemos con el scanner, y leemos que sea float
			
			System.out.println(" ");		

			
			System.out.println(insercionTiempos);
			
			System.out.println(" ------------------------------------------ ");		

			
			nombres[posicionArray] = insercion;		// Insertamos los datos que quiere de tipo entero en cada posicion (0, 1, 2...) que tiene el array
			
			tiempos[posicionArray] = insercionTiempos;		// Insertamos los datos que quiere de tipo entero en cada posicion (0, 1, 2...) que tiene el array
			
			System.out.println("Se va a hacer la insercion de: " + nombres[posicionArray] + " con un tiempo de: " + tiempos[posicionArray] + " (segundos)");		// Mostramos el resultado por pantalla

			posicionArray++;		// Vamos recorriendo la posicion de 1 en 1
			
			
			System.out.println(" ················································· ");
			
		}
		
		
		for (int i = 0; i < nombres.length; i++) {		// Hacemos otro bucle for para recorrer el vector y mostrar el resultado por pantalla
			
			System.out.println("En la posicion: " + i + " se ha insertado el atleta: " + nombres[i] + " con un tiempo de: " + tiempos[i] + " (segundos)");
		
		}
		
		mejor = tiempos[0];		// Creamos una variable que se llame mejor, que nos servira mas tarde para sacar cual es el numero mayor y la inicializamos al vector notas
        peor = tiempos[0];		// Creamos una variable que se llame peor, que nos servira mas tarde para sacar cual es el numero menor y la inicializamos al vector notas
       
        for (int i = 0; i < tiempos.length; i++) {		// Nos creamos un bucle for que vaya desde el 0 hasta la longitud del vector y que vaya incrementando de 1 en 1
        	
            if(tiempos[i] > peor) {		// Si lo que hay en el array es mayor que lo que hay en la variable mayor
            	
                peor = tiempos[i];		// Mayor toma el valor mayor que hay en el array
                atletaPeor = nombres[i];
                
            }
            
            if(tiempos[i] < mejor) {		// Igual que con el menor
            	
                mejor = tiempos[i];
                atletaMejor = nombres[i];
                
            }
        }
        
		System.out.println(" ················································· ");
        System.out.println("El mejor atleta es: " + atletaMejor + " con un tiempo de: " + mejor);		// Mostramos resultados por pantalla
		System.out.println("El peor atleta es: " + atletaPeor + " con un tiempo de: " + peor);
		System.out.println(" ················································· ");

          	
        
        
		
		
///////			
	}
} 
