package com.ActividadesConVectores;

import java.util.Random;
//import java.util.Arrays;
import java.util.Scanner;

public class insercionOrdenada {

	public static void main(String[] args) {	// Es el main del programa
			
		System.out.println("Introduce un numero para declarar el minimo del array, por favor");		// Pedimos un numero al usuario para que el determine la dimension del array
		Scanner minimoUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
		int minimo = minimoUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
		
		System.out.println("Introduce un numero para declarar el minimo del array, por favor");		// Pedimos un numero al usuario para que el determine la dimension del array
		Scanner maximoUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
		int maximo = minimoUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
		
		System.out.println("Introduce un numero para saber cuantos numeros en el array hay, por favor");		// Pedimos un numero al usuario para que el determine la dimension del array
		Scanner dimensionUsuario = new Scanner(System.in);		// Escaneamos lo que nos introduce el usuario
		int dimension = dimensionUsuario.nextInt();		// Declaramos la dimension como entero y la igualamos a lo que nos esta introduciendo el usuario por teclado
				
		int [] orden = new int [dimension];		// Creamos un array llamado orden y lo igualamos a la variable dimension para que la longitud del vector sea igual a la que nos introduce el usuario 
		
		
		
		for (int i=0; i < orden.length; i++) {	// Creo un bucle for e inserto los numeros aleatorios en el array
			
			orden[i] = (int) (Math.random() * maximo ) + minimo;
			
		}

		
		System.out.println("");
		System.out.println("");
		System.out.println(" --------------- El vector sin ordenar con los datos queda: --------------- ");
		
		
		
		for (int i = 0; i < dimension; i++) {
			
			System.out.println("En la posicion: "+ i + " está el dato: " + orden[i]);	// Muestro por pantalla

		}
		
		
		
		System.out.println(" -------------------------------------------------------------------------- ");
		System.out.println("");
		System.out.println("");
		
		
		
		// Metodo por insercion
		
		
		
		int menor = 0;
		int posicion = 0;
		int aux = 0;
		
		for (int i = 0; i < dimension - 1; i++) {      // tomamos como menor el primero
            
			menor = orden[i];                       // de los elementos que quedan por ordenar                    

			posicion = i;                            // y guardamos su posición
            
            for (int j = i + 1; j < dimension; j++){ // buscamos en el resto
                  
            	if (orden[j] < menor) {           // del array algún elemento
                      
            		menor = orden[j];             // menor que el actual
                      
            		posicion = j;
                  
            	}
            }
            
            if (posicion != i){                      // si hay alguno menor se intercambia                         
                
            	aux = orden[i];
                
            	orden[i] = orden[posicion];
                
            	orden[posicion] = aux;
            }

		}
		
		
		
		System.out.println(" --------------- El vector ordenado con los datos queda: ------------------ ");
		
		for (int i = 0; i < dimension; i++) {
			
			System.out.println("En la posicion: "+ i + " está el dato: " + orden[i]);

		}

		System.out.println(" -------------------------------------------------------------------------- ");    
		
///////			
	}
} 
