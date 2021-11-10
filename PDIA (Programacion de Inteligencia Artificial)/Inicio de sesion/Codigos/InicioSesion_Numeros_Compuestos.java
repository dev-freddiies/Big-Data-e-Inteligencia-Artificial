package com.iniciosesion;

import java.util.Scanner;

public class InicioSesion {

	public static void main(String[] args) { // Es el main del programa
		
		//System.out.println("Hola, este es un programa para iniciar sesion en Java");
		
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

		
		
/*		
		System.out.println("Se va a hacer ahora solamente con el uso de switch");
		
		System.out.println("Hola, escribe como te quieras logear, alumno, profe o pro"); // Le preguntamos como quiere logearse
		Scanner scNombreUsuario = new Scanner (System.in); // Utilizamos el scanner
		String nombreUsuario = scNombreUsuario.nextLine(); // Creamos una variable de tipo string y la inicializamos a lo que nos introducen por teclado
	
		switch(nombreUsuario){
			
			case "alumno": // En caso de que sea alumno, hay que validarlo con bucles if que nos dicen como nos hemos logueado y si nos hemos equivocado acabando el programa
				System.out.println("Hola, quieres iniciar sesion como un alumno, PD: usuario=alumno y contraseña=ejemplo");
				
				Scanner scNombreLumno = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String nombreAlumno = scNombreLumno.nextLine();
				
				Scanner scPassAlumno = new Scanner( System.in );
				System.out.println("Introduce una contraseña de usuario para el login porfavor");
				String PassAlumno = scPassAlumno.nextLine();
				
				if (nombreAlumno.equals("alumno") && PassAlumno.equals("ejemplo")) {
					
					
					System.out.println("Usuario valido, bienvenido, te has logeado como un alumno");
					
				} else {
					
					System.out.println("Usuario y/o contraseña incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea alumno");
				}
				
				break; // Utilizamos el break para salir del programa
		
			case "profe": // Lo mismo que con el usuario alumno
				
				System.out.println("Hola, quieres iniciar sesion como un profe, PD: usuario=profe y contraseña=aprobado");
				
				Scanner scNombreProfe= new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String NombreProfe = scNombreProfe.nextLine();
				
				Scanner scPassProfe = new Scanner( System.in );
				System.out.println("Introduce una contraseña de usuario para el login porfavor");
				String PassProfe = scPassProfe.nextLine();
				
				if (NombreProfe.equals("profe") && PassProfe.equals("aprobado")) {
					
					System.out.println("Usuario valido, bienvenido, te has logeado como un profesor");
					
				} else {
					
					System.out.println("Usuario y/o contraseña incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea profesor");
				}
				
				break;
				
			case "experto": // Lo mismo que en los otros dos casos
				
				System.out.println("Hola, quieres iniciar sesion como un experto, PD: usuario=experto y contraseña=profesional");
				
				Scanner scNombreExperto = new Scanner (System.in);
				System.out.println("Introduce un nombre de usuario para el login porfavor");
				String NombreExperto = scNombreExperto.nextLine();
				
				Scanner scPassExperto = new Scanner( System.in );
				System.out.println("Introduce una contraseña de usuario para el login porfavor");
				String PassExperto = scPassExperto.nextLine();
				
				if (NombreExperto.equals("experto") && PassExperto.equals("profesional")) {
					
					System.out.println("Usuario valido, bienvenido, te has logeado como un experto");
					
				} else {
					
					System.out.println("Usuario y/o contraseña incorrecto, no valido, prueba a introducir otro usuario porque alomejor perteneces a otro que no sea experto");
				}
				break;
				
			default: System.out.println("Eres un impostor");
				
			}
*/			
	

/*		
		String nombreAlumno; // Declaramos la variable nombreAlumno que nos servirá mas tarde para almacenar el nombre que nos pasen por teclado, y es de tipo String
		String passAlumno; // Declaramos la variable passAlumno que nos servirá mas tarde para almacenar la contraseña que nos pasen por teclado, y es de tipo String
		boolean bandera = false; // Nos declaramos una variable de tipo booleano que se llame bandera y que la inicializamos a false
		
		Scanner scNombreAlumno = new Scanner (System.in); // Utilizamos el scanner
		System.out.println("Introduce un nombre de usuario para el login porfavor"); // Pedimos un nombre de usuario para el login
		nombreAlumno = scNombreAlumno.nextLine(); // Igualamos la variable que hemos declarado anteriormente a la del scanner para almacenar el nombre que nos han introducido por parametro
			
		Scanner scPassAlumno = new Scanner(System.in); // Lo mismo pero con la contraseña
		System.out.println("Introduce una contraseña de usuario para el login porfavor");
		passAlumno = scPassAlumno.nextLine();
		
		if (nombreAlumno.equals("alumno") && passAlumno.equals("ejemplo") || nombreAlumno.equals("profe") && passAlumno.equals("aprobado") || nombreAlumno.equals("experto") && passAlumno.equals("profesional")) {
		// Hacemos un bucle if para validar todos los usuarios con sus respectivas contraseñas con el uso de && y || (que significan y y o)	
		// Osea que si me introducen alumno y ejemplo o profe y aprobado o experto y profesional me dará como valido y me devolverá por pantalla que el usuario es correcto
			System.out.println("Usuario correcto");
			bandera = true; // Y como el usuario es correcto la bandera hay que ponerla a true
				
		}	
	        
	    while (!bandera) { // Mientras que la bandera sea negativa nos dira que el usuario es incorrecto y nos lo pedirá nuevamente hasta que sea verdad
	    	
			System.out.println("Usuario incorrecto");

			System.out.println("Introduce un nombre de usuario correcto para el login");
			nombreAlumno = scNombreAlumno.nextLine();
			
			System.out.println("Introduce una contraseña correcta de usuario para el login");
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

/*
System.out.println("Se va a hacer ahora solamente con el uso del for");
int contador = 0;	

for (int i = 0; i <= 10; i ++) {
		
		System.out.println("Le quedan: " + contador + " intentos"); // Mostramos el contador
		
		Scanner scNombreUsuario = new Scanner (System.in); // Utilizamos el scanner
		System.out.println("Introduce un nombre de usuario para el login porfavor"); // Pedimos un nombre de usuario para el login
		String nombreUsuario = scNombreUsuario.nextLine(); // Creamos una variable de tipo string y la inicializamos a lo que nos introducen por teclado
			
		
		Scanner scPassUsuario = new Scanner(System.in); // Lo mismo pero con la contraseña
		System.out.println("Introduce una contraseña de usuario para el login porfavor");
		String passUsuario = scPassUsuario.nextLine();
		
		if (nombreUsuario.equals("java") && passUsuario.equals("inicial")) {				
			
			System.out.println("Usuario correcto, te has logeado como: " + nombreUsuario);
			// Si lo que me introducen es correcto me lo dará como válido y se acabará el programa
			break;
			

		} else {
			
			System.out.println("Usuario incorrecto"); // Le preguntamos como quiere logearse
			contador = 10 - i;
		}
	}
	
*/
		
        
/*
System.out.println("Ejercicio de bucles avanzados");

Scanner numUsuario = new Scanner(System.in);    
System.out.println("Introduce un numero mayor que 0, por favor: ");
int num = numUsuario.nextInt();
 
int contador = 0;
        
if(num >= 0) {
            
	for(int i=1; i<=num; i++){
                
		contador = contador + i;
        System.out.println("El valor total es: " + contador);

            
	}
            
            
} else {
           
	System.out.println("El valor introducido no es mayor a 0");
        
}
*/	

////	


/*
int factorial=1; // Declaramos una variable factorial como entero y la inicializamos a 1
int num; // Declaramos una variable numero como entero

Scanner numero = new Scanner(System.in); // Utilizamos el scanner y pedimos que introduzca un numero y luego la igualamos a lo que nos introducen por parametro
System.out.print("Introduce un número: ");
num = numero.nextInt();
    
for (int i = num; i > 0; i--) { // Con un bucle for hacemos que vaya decrementando desde el numero introducido hasta 0 con el i--
    	
	factorial = factorial * i;	// Para hacer el factorial basta con multiplicar por el indice el factorial
	System.out.println("El factorial de " + num + " * " + i + " es: " + factorial); // Y mostramos el resultado por pantalla

    }
*/    


		

int num = 0;   // Declaramos e inicializamos numero a 0
for (int i = 0; i <= 49; i++) { // Con un bucle for hacemos que vaya decrementando desde el numero introducido hasta 0 con el i++
    	
	num = num + 1;	// Vamos aumentando el numero de 1 en 1 sumando el numero + 1 (que esta inicializado a 0)

	if (num % 2 == 0 || num % 3 == 0) { // Si el modulo del numero dividido entre 2 o 3 es 0 nos dice que el numero es compuesto
			
		System.out.println("El numero " + num + " es compuesto"); // Y mostramos el resultado por pantalla
		
	} else {
		
		System.out.println("El numero " + num + " es primo"); // Y mostramos el resultado por pantalla

	}
}


		
		
//
}     
}		






	
