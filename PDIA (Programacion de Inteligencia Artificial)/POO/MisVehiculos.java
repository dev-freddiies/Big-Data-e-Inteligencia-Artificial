package com.POO;

	// --- --- --- --- --- --- --- ---  MAIN  --- --- --- --- --- --- --- --- //
	
public class MisVehiculos {
	
	public static void main(String[] args) {	// Es el main del programa
		
		Vehiculo vehiculoFreddiie = new Vehiculo("8556 BXZ", "VW", 500.0, "Plateado", false, 450000);
		
		Vehiculo vehiculoPruebas = new Vehiculo("0040 HBP", "Nissan", 1000.0, "Blanco", true, 1);
		
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
			
			
				
			Cliente cliente1 = new Cliente ("67405415L", "Federico", "Diaz");
			
			vehiculoAlquilado alquiler1 = new vehiculoAlquilado (cliente1, vehiculoFreddiie, 11, 11, 20122, 2);
			
				cliente1.setNombre("Alvaro");

			
				System.out.println(" ");
				System.out.println(" --- --- --- VEHICULO ALQUILADO --- --- --- ");
				System.out.println("DNI : " + alquiler1.getCliente().getnif());
				System.out.println("Nombre : " + alquiler1.getCliente().getNombre());
				System.out.println("Apellidos: " + alquiler1.getCliente().getApellidos());
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
			
			
	}
		
	
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
// // // // 
	
}
