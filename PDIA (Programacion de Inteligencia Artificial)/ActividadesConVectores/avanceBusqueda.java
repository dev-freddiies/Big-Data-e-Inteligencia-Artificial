package com.ActividadesConVectores;

import java.util.Scanner;

public class avanceBusqueda {

	public static void main(String[] args) {	// Es el main del programa
		
	boolean bandera = false;
		
		while (!bandera) {
		
			System.out.println("Introduce un numero para saber el numero de elementos que quieres insertar en el array");		// Pedimos un numero al usuario para que el determine la dimension del array
			Scanner dimensionUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
			int dimension = dimensionUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
			int posicionArray = 0;		// Declaramos una variable para la posicion del array y la inicializamos a 0
			boolean encontrado = false;
			
			
			int [] numeros = new int[dimension];		// Declaramos un array de tipo string llamado nombres de dimension introducida por teclado
			 
			if (dimension >= 10) {
				
				for (int i = dimension; i > 0; i--) {		// Hacemos un bucle for que vaya desde lo que nos introduce el usuario hasta 0 
					
					System.out.println("Introduce un numero que quieras insertar en el array");
		
					Scanner numeroUsuario = new Scanner(System.in);    		// Insertamos los nombres que quiere el usuario
					int insercion = numeroUsuario.nextInt();			// Y los leemos con el scanner
					
					System.out.println(" ");		// Motivo de estetica
		
					System.out.println(insercion);		
					
					System.out.println(" ------------------------------------------ ");	
					
					numeros[posicionArray] = insercion;		// Insertamos los datos que quiere de tipo entero en cada posicion (0, 1, 2...) que tiene el array
									
					System.out.println("Se va a hacer la insercion de: " + numeros[posicionArray]);		// Mostramos el resultado por pantalla
		
					posicionArray++;		// Vamos recorriendo la posicion de 1 en 1
					
					System.out.println(" ················································· ");
					
				}
				
				System.out.println(" ");

				for (int i = 0; i < numeros.length; i++) {		// Hacemos otro bucle for para recorrer el vector y mostrar el resultado por pantalla
					
					System.out.println("En la posicion: " + i + " se ha insertado el numero: " + numeros[i]);
					
					bandera = true;
				
				}
					
					System.out.println(" ");
					System.out.println(" ************ · BUSQUEDA · ************ ");
					System.out.println(" ");

				
					System.out.println("Introduce un numero que quieras buscar, por favor");
					
					Scanner busquedaUsuario = new Scanner(System.in);    		// Insertamos los nombres que quiere el usuario
					int busqueda = busquedaUsuario.nextInt();	
			        int i = 0;
					
					boolean elNumeroEsta = false;
					
					System.out.println(" ");
					
					System.out.println("Tamaño de tu array: " + dimension);
				
					System.out.println(" ");

					for (i = 0; i < numeros.length; i++) {		// Hacemos otro bucle for para recorrer el vector y mostrar el resultado por pantalla
						
						if (busqueda == numeros[i]) {
							
							System.out.println("El numero: " + busqueda + " esta en la posicion: " + i);
							elNumeroEsta = true;
							
						}
					
					}
			
					if (elNumeroEsta == false) {
						
						System.out.println(" ");
			            System.out.println("El numero: " + busqueda + " no esta");
			            bandera = false;
						
					}
				
				
			} else {
				
				System.out.println("Por favor, introduce 10 numeros o mas");
				
				bandera = false;
				
			}
			
			
          	
        
        
		
		}	
///////			
	}

		
	}
