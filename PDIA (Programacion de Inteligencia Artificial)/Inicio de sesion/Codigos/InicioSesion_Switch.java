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
		System.out.println("Introduce una contraseņa de usuario para el login porfavor");
		String pass = sc_pass.nextLine();
		
		if (nombre.equals("java") == true && pass.equals("inicial") == true ) {
			System.out.println("Usuario valido, bienvenido");
		} else {
			System.out.println("Usuario incorrecto, no valido");
		}*/

		
		
		
		System.out.println("Se va a hacer ahora solamente con el uso de switch");
		
		System.out.println("Hola, escribe como te quieras logear, alumno, profe o pro"); // Le preguntamos como quiere logearse
		Scanner scNombreUsuario = new Scanner (System.in); // Utilizamos el scanner
		String nombreUsuario = scNombreUsuario.nextLine(); // Creamos una variable de tipo string y la inicializamos a lo que nos introducen por teclado
	
		switch(nombreUsuario){
			
			case "alumno": // En caso de que sea alumno, hay que validarlo con bucles if que nos dicen como nos hemos logueado y si nos hemos equivocado acabando el programa
				System.out.println("Hola, quieres iniciar sesion como un alumno, PD: usuario=alumno y contraseņa=ejemplo");
				
				Scanner scNombreLumno = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String nombreAlumno = scNombreLumno.nextLine();
				
				Scanner scPassAlumno = new Scanner( System.in );
				System.out.println("Introduce una contraseņa de usuario para el login porfavor");
				String PassAlumno = scPassAlumno.nextLine();
				
				if (nombreAlumno.equals("alumno") && PassAlumno.equals("ejemplo")) {
					
					
					System.out.println("Usuario valido, bienvenido, te has logeado como un alumno");
					
				} else {
					
					System.out.println("Usuario y/o contraseņa incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea alumno");
				}
				
				break; // Utilizamos el break para salir del programa
		
			case "profe": // Lo mismo que con el usuario alumno
				
				System.out.println("Hola, quieres iniciar sesion como un profe, PD: usuario=profe y contraseņa=aprobado");
				
				Scanner scNombreProfe= new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String NombreProfe = scNombreProfe.nextLine();
				
				Scanner scPassProfe = new Scanner( System.in );
				System.out.println("Introduce una contraseņa de usuario para el login porfavor");
				String PassProfe = scPassProfe.nextLine();
				
				if (NombreProfe.equals("profe") && PassProfe.equals("aprobado")) {
					
					System.out.println("Usuario valido, bienvenido, te has logeado como un profesor");
					
				} else {
					
					System.out.println("Usuario y/o contraseņa incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea profesor");
				}
				
				break;
				
			case "experto": // Lo mismo que en los otros dos casos
				
				System.out.println("Hola, quieres iniciar sesion como un experto, PD: usuario=experto y contraseņa=profesional");
				
				Scanner scNombreExperto = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String NombreExperto = scNombreExperto.nextLine();
				
				Scanner scPassExperto = new Scanner( System.in );
				System.out.println("Introduce una contraseņa de usuario para el login porfavor");
				String PassExperto = scPassExperto.nextLine();
				
				if (NombreExperto.equals("experto") && PassExperto.equals("profesional")) {
					
					System.out.println("Usuario valido, bienvenido, te has logeado como un experto");
					
				} else {
					
					System.out.println("Usuario y/o contraseņa incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea experto");
				}
				break;
				
			default: System.out.println("Eres un impostor");
				
			}
			
	
/*	
		
		String nombreAlumno; // Declaramos la variable nombreAlumno que nos servirá mas tarde para almacenar el nombre que nos pasen por teclado, y es de tipo String
		String passAlumno; // Declaramos la variable passAlumno que nos servirá mas tarde para almacenar la contraseņa que nos pasen por teclado, y es de tipo String
		boolean bandera = false; // Nos declaramos una variable de tipo booleano que se llame bandera y que la inicializamos a false
		
		Scanner scNombreAlumno = new Scanner (System.in); // Utilizamos el scanner
		System.out.println("Introduce un nombre de usuario para el login porfavor"); // Pedimos un nombre de usuario para el login
		nombreAlumno = scNombreAlumno.nextLine(); // Igualamos la variable que hemos declarado anteriormente a la del scanner para almacenar el nombre que nos han introducido por parametro
			
		Scanner scPassAlumno = new Scanner(System.in); // Lo mismo pero con la contraseņa
		System.out.println("Introduce una contraseņa de usuario para el login porfavor");
		passAlumno = scPassAlumno.nextLine();
		
		if (nombreAlumno.equals("alumno") && passAlumno.equals("ejemplo") || nombreAlumno.equals("profe") && passAlumno.equals("aprobado") || nombreAlumno.equals("experto") && passAlumno.equals("profesional")) {
		// Hacemos un bucle if para validar todos los usuarios con sus respectivas contraseņas con el uso de && y || (que significan y y o)	
		// Osea que si me introducen alumno y ejemplo o profe y aprobado o experto y profesional me dará como valido y me devolverá por pantalla que el usuario es correcto
			System.out.println("Usuario correcto");
			bandera = true; // Y como el usuario es correcto la bandera hay que ponerla a true
				
		}	
	        
	    while (!bandera) { // Mientras que la bandera sea negativa nos dira que el usuario es incorrecto y nos lo pedirá nuevamente hasta que sea verdad
	    	
			System.out.println("Usuario incorrecto");

			System.out.println("Introduce un nombre de usuario correcto para el login");
			nombreAlumno = scNombreAlumno.nextLine();
			
			System.out.println("Introduce una contraseņa correcta de usuario para el login");
			passAlumno = scPassAlumno.nextLine();
	    	
			if (nombreAlumno.equals("alumno") && passAlumno.equals("ejemplo") || nombreAlumno.equals("profe") && passAlumno.equals("aprobado") || nombreAlumno.equals("experto") && passAlumno.equals("profesional")) {				
				
				System.out.println("Usuario correcto, te has logeado como: " + nombreAlumno);
				// Si lo que me introducen es correcto me lo dará como válido y se acabará el programa

				bandera = true;
					
			} else {
				
				bandera = false;
				// Si no me lo seguirá pidiendo
			}
	    }
	    
*/
		
	}
}


	
