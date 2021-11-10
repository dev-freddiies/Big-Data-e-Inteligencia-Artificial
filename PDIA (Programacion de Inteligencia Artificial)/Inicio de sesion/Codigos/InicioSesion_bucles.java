package com.iniciosesion;

import java.util.Scanner;

public class InicioSesion {

	public static void main(String[] args) { // Es el main del programa
		
		System.out.println("Hola, este es un programa para iniciar sesion en Java");
		
		//System.out.println("Se va a hacer ahora solamente con el uso de if");

		/*Scanner sc_nombre = new Scanner (System.in);
		System.out.println("Introduce un nombre de usuario para el login porfavor");
		String nombre = sc_nombre.nextLine(); //Para leer un string es con nextLine, si es nextInt lee solo los enteros
		
		Scanner sc_pass = new Scanner( System.in );
		System.out.println("Introduce una contraseña de usuario para el login porfavor");
		String pass = sc_pass.nextLine();
		
		if (nombre.equals("java") == true && pass.equals("inicial") == true ) {
			System.out.println("Usuario valido, bienvenido");
		} else {
			System.out.println("Usuario incorrecto, no valido");
		}*/

		
		
		
		System.out.println("Se va a hacer ahora solamente con el uso de switch");
		
		System.out.println("Hola, escribe como te quieras logear, alumno, profe o pro");
		Scanner sc_nombre_usuario = new Scanner (System.in);
		String nombre_usuario = sc_nombre_usuario.nextLine();
	
		switch(nombre_usuario){
			
			case "alumno":
				System.out.println("Hola, quieres iniciar sesion como un alumno, PD: usuario=alumno y contraseña=ejemplo");
				Scanner sc_nombre_alumno = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String nombre_alumno = sc_nombre_alumno.nextLine();
				
				Scanner sc_pass_alumno = new Scanner( System.in );
				System.out.println("Introduce una contraseña de usuario para el login porfavor");
				String pass_alumno = sc_pass_alumno.nextLine();
				
				if (nombre_alumno.equals("alumno") == true && pass_alumno.equals("ejemplo") == true ) {
					System.out.println("Usuario valido, bienvenido, te has logeado como un alumno");
				} else {
					System.out.println("Usuario y/o contraseña incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea alumno");
				}
				break;
		
			case "profe":
				System.out.println("Hola, quieres iniciar sesion como un profe, PD: usuario=profe y contraseña=aprobado");
				Scanner sc_nombre_profe = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String nombre_profe = sc_nombre_profe.nextLine();
				
				Scanner sc_pass_profe = new Scanner( System.in );
				System.out.println("Introduce una contraseña de usuario para el login porfavor");
				String pass_profe = sc_pass_profe.nextLine();
				
				if (nombre_profe.equals("profe") == true && pass_profe.equals("aprobado") == true ) {
					System.out.println("Usuario valido, bienvenido, te has logeado como un profesor");
				} else {
					System.out.println("Usuario y/o contraseña incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea profesor");
				}
				break;
				
			case "experto":
				System.out.println("Hola, quieres iniciar sesion como un experto, PD: usuario=experto y contraseña=profesional");
				Scanner sc_nombre_experto = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String nombre_experto = sc_nombre_experto.nextLine();
				
				Scanner sc_pass_experto = new Scanner( System.in );
				System.out.println("Introduce una contraseña de usuario para el login porfavor");
				String pass_experto = sc_pass_experto.nextLine();
				
				if (nombre_experto.equals("experto") == true && pass_experto.equals("profesional") == true ) {
					System.out.println("Usuario valido, bienvenido, te has logeado como un experto");
				} else {
					System.out.println("Usuario y/o contraseña incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea experto");
				}
				break;
				
			default: System.out.println("Eres un impostor");
				
			}
		
			
			
		/*System.out.println("Se va a hacer ahora solamente con el uso del while");
		
		String nombre;
		while (nombre != "alumno" || nombre!= "profe" || nombre != "experto") {
			
		}*/
		
		
		
		
	}
}