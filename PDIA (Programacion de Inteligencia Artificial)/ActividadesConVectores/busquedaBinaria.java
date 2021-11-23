package com.ActividadesConVectores;

import java.util.Scanner;

public class busquedaBinaria {

	public static void main(String[] args) {	// Es el main del programa
				
			int [] numeros = {1,2,3,4,5,6,7,8,9,10,15,17,20,45,51,60,68,74,75};
			int dimension = numeros.length; 	// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado, pero  con la length que es la dimesion del array que nos introducen

			for (int i = 0; i < numeros.length; i++) {		// Hacemos un bucle for que vaya desde 0 hasta la dimension del array
				
				System.out.println("Numero: " + numeros[i] + " - " + " en la posicion: " + i);		// Mostramos por pantalla el array
				
			}
			
			int inferior = 0;	// Declaramos el limite inferior
			int centro = 0;		// Declaramos el centro
			int superior = dimension - 1;	// Declaramos el limite superior que es la dimension - 1
			boolean bandera = false;	// Declaramos e inicializamos una bandera
			
			while (!bandera) { 		// Hacemos un bucle while y forzamos que se meta con la bandera inicializada a false
			
				System.out.println(" ");
				System.out.println("Introduce un numero para buscarlo dentro del array");
	
				Scanner numeroUsuario = new Scanner(System.in);    		// Leemos el numero que el usuario quiere buscar
				int numero = numeroUsuario.nextInt();
				
				while ((inferior <= superior)) {	// Generamos la busqueda binaria de la forma que es que mientras que el limite inferior sea menos o igual al superior
					
					centro = (superior + inferior)/2;		// El centro es la suma del limite superior + inferior entre 2
					
					if (numeros[centro] == numero) {	// Si el numero coincide que esta justo en el centro decimos que ese es el numero
						
						System.out.println(" ");
						System.out.println("El numero buscado: " + numero + " esta en la posicion: " + centro);		
						bandera = true;
						break;
						
					}if(numero < numeros[centro]) {		// Si el numero es menor que el que esta en el centro; igualamos el superior a que es el centro menos 1
						
						superior = centro - 1;
						
					} else {
						
						inferior = centro + 1;		// Lo mismo con el inferior
						
					}

				}	
				
				if (numeros[centro]!=numero) {
					
					System.out.println(" ");
					System.out.println("El numero buscado: " + numero + " No existe en el array");		// Validamos que no exista
					bandera = true;
					
				}
				
			}
			
///////			
	}
} 
