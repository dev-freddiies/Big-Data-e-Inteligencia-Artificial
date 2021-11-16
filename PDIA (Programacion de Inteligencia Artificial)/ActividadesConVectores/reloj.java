package com.ActividadesConVectores;

public class reloj {

	public static void main(String[] args) throws InterruptedException {	// Lo de throws InterruptedException es simplemente para que el contador a la hora de mostrar los resultados vaya mas lento para poder visualizarlo mejor y que no vaya tan rapido
		
		int segundos = 0;		// Nos declaramos 3 variables que sean los segundos, minutos y horas y las inicializamos a 0
		int minutos = 0;
		int horas = 0;		
		
		while (true) {	// Con un bucle while a true lo que hacemos es que repita todo el proceso de abajo
			
			segundos++; // Empezamos a que vayan los segundos de 1 en 1 incrementandolos

			if (segundos == 60) { // Reseteamos los segundos y una vez que lleguen a 60 lo que hacemos es que incrementamos los minutos ( Ya que 60 seg es 1 min)
				
				segundos = 0; // Cuando lleegan a 60 los reseteamos
				minutos++;
				
			}
			
				if (minutos == 60) { // Exactamente igual con los minutos y con las horas
						
					minutos = 0;
					horas++;
					
				}
				
					if (horas == 24) {
						
						horas = 0;
						
					}
				
					System.out.println(horas + " : " + minutos + " : " + segundos);		// Mostramos el resultado por pantalla
					Thread.sleep(1000);		// Esto sirve para que nos muestre el resultado por pantalla mas lento
						
		}
        
		
///////			
	}
} 


