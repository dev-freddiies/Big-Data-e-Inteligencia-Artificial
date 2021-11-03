package com.iniciosesion;

import java.util.Scanner;

public class InicioSesion {

	public static void main(String[] args) { // Es el main del programa
		
		System.out.println("Hola, este es un programa para iniciar sesion en Java");
		
		Scanner sc_nombre = new Scanner (System.in);
		System.out.println("Introduce un nombre de usuario para el login porfavor");
		String nombre = sc_nombre.nextLine(); //Para leer un string es con nextLine, si es nextInt lee solo los enteros
		
		Scanner sc_pass = new Scanner( System.in );
		System.out.println("Introduce una contraseña de usuario para el login porfavor");
		String pass = sc_pass.nextLine();
		
		if (nombre.equals("java") == true && pass.equals("inicial") == true ) {
			System.out.println("Usuario valido, bienvenido");
		} else {
			System.out.println("Usuario incorrecto, no valido");
		}

		// Con el while sale un bucle infinito
		
				/*while (nombre.equals("java") == false && pass.equals("inicial") == false) {
					if (nombre.equals("java") == true && nombre.equals("inicial") == true) {
						System.out.println("Usuario y contraseña validos, bienvenido usuario");
					} else {
						System.out.println("Usuario y/o contraseña incorrectos, lo siento");
					}
				}*/
	}
}