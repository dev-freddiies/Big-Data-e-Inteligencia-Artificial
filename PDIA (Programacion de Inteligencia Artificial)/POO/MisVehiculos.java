package com.POO;

	// --- --- --- --- --- --- --- ---  MAIN  --- --- --- --- --- --- --- --- //
	
public class MisVehiculos {
	
	public static void main(String[] args) {	// Es el main del programa
		
		Vehiculo vehiculoFreddiie = new Vehiculo("8556 BXZ", "VW", "Golf", 500.0, "Plateado", false, 450000);
		
		Vehiculo vehiculoPruebas = new Vehiculo("0040 HBP", "Nissan", "370z", 1000.0, "Blanco", true, 1);
		
		Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", 100.0, "Blanco", true, 1);

		Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", 80.0, "Negro", true, 1);
		
			vehiculoFreddiie.setDisponible(true);
			
			vehiculoPruebas.setMarca("Ferrari");
			vehiculoPruebas.setkilometrajeTotal(10);
			vehiculoPruebas.setDisponible(false);


		
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println("Matricula: " + vehiculoFreddiie.matricula);
				System.out.println("Marca y kilometraje total: " + vehiculoFreddiie.marca + " --- " + vehiculoFreddiie.kilometrajeTotal);
				System.out.println("Color: " + vehiculoFreddiie.color);
				System.out.println("Tarifa: " + vehiculoFreddiie.tarifa);
				System.out.println("Disponible: " + vehiculoFreddiie.disponible);
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");

				System.out.println(" ");
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println("Matricula: " + vehiculoPruebas.matricula);
				System.out.println("Marca y kilometraje total: " + vehiculoPruebas.marca + " --- " + vehiculoPruebas.kilometrajeTotal);
				System.out.println("Color: " + vehiculoPruebas.color);
				System.out.println("Tarifa: " + vehiculoPruebas.tarifa);
				System.out.println("Disponible: " + vehiculoPruebas.disponible);
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
				System.out.println(" ");       			
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println("Matricula: " + vehiculo1.matricula);
				System.out.println("Marca y kilometraje total: " + vehiculo1.marca + " --- " + vehiculoFreddiie.kilometrajeTotal);
				System.out.println("Modelo: " + vehiculo1.modelo);
				System.out.println("Color: " + vehiculo1.color);
				System.out.println("Tarifa: " + vehiculo1.tarifa);
				System.out.println("Disponible: " + vehiculo1.disponible);
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");

				System.out.println(" ");
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println("Matricula: " + vehiculo2.matricula);
				System.out.println("Marca y kilometraje total: " + vehiculo2.marca + " --- " + vehiculoPruebas.kilometrajeTotal);
				System.out.println("Modelo: " + vehiculo2.modelo);
				System.out.println("Color: " + vehiculo2.color);
				System.out.println("Tarifa: " + vehiculo2.tarifa);
				System.out.println("Disponible: " + vehiculo2.disponible);
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
			
				
			Cliente cliente1 = new Cliente ("67405415L", "Federico", "Diaz");
		
			vehiculoAlquilado alquiler1 = new vehiculoAlquilado (cliente1, vehiculoFreddiie, 11, 11, 2021, 2);
			
				cliente1.setNombre("Alvaro");

			
				System.out.println(" ");
				System.out.println(" --- --- --- VEHICULO ALQUILADO --- --- --- ");
				System.out.println("DNI : " + alquiler1.getCliente().getnif());
				System.out.println("Nombre : " + alquiler1.getCliente().getNombre());
				System.out.println("Apellidos: " + alquiler1.getCliente().getApellidos());
				System.out.println("FECHA -- " + " DIA: " + alquiler1.getdiaAlquiler() + " MES: " + alquiler1.getmesAlquiler() + " AÑO: " + alquiler1.getañoAlquiler());	
				System.out.println("Dias vehiculo alquilado: " + alquiler1.gettotalDiasAlquiler() + " dias");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
				
				
			Cliente clienteEj = new Cliente ("30435624X", "Juan", "Pérez");
				
			vehiculoAlquilado alquiler2 = new vehiculoAlquilado (clienteEj, vehiculo1, 31, 11, 2021, 2);
			
				System.out.println(" ");
				System.out.println(" --- --- --- VEHICULO ALQUILADO --- --- --- ");
				System.out.println("DNI : " + alquiler2.getCliente().getnif());
				System.out.println("Nombre : " + alquiler2.getCliente().getNombre());
				System.out.println("Apellidos: " + alquiler2.getCliente().getApellidos());
				System.out.println("FECHA -- " + " DIA: " + alquiler2.getdiaAlquiler() + " MES: " + alquiler2.getmesAlquiler() + " AÑO: " + alquiler2.getañoAlquiler());	
				System.out.println("Dias vehiculo alquilado: " + alquiler2.gettotalDiasAlquiler() + " dias");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
			
	}
		
	
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
// // // // 
	
}
