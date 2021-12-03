package com.POO;

import java.util.Scanner;

// --- --- --- --- --- --- --- ---  MAIN  --- --- --- --- --- --- --- --- //
	
public class MisVehiculos {
	
	public static void main(String[] args) {	// Es el main del programa
		
		Vehiculo vehiculoFreddiie = new Vehiculo("8556 BXZ", "VW", "Golf", 500.0, "Plateado", false, 450000);
		
			vehiculoFreddiie.setDisponible(true);
			
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("Matricula: " + vehiculoFreddiie.matricula);
				System.out.println("Marca: " + vehiculoFreddiie.marca);
				System.out.println("Kilometraje total: " + vehiculoFreddiie.kilometrajeTotal + " km");
				System.out.println("Color: " + vehiculoFreddiie.color);
				System.out.println("Tarifa: " + vehiculoFreddiie.tarifa);
				System.out.println("Disponible: " + vehiculoFreddiie.disponible);
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

				
				
		Vehiculo vehiculoPruebas = new Vehiculo("0040 HBP", "Nissan", "370z", 1000.0, "Blanco", true, 1);

			vehiculoPruebas.setMarca("Ferrari");
			vehiculoPruebas.setkilometrajeTotal(10);
			vehiculoPruebas.setDisponible(false);
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("Matricula: " + vehiculoPruebas.matricula);
				System.out.println("Marca: " + vehiculoPruebas.marca);
				System.out.println("Kilometraje total: " + vehiculoPruebas.kilometrajeTotal  + " km");
				System.out.println("Color: " + vehiculoPruebas.color);
				System.out.println("Tarifa: " + vehiculoPruebas.tarifa);
				System.out.println("Disponible: " + vehiculoPruebas.disponible);
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

				
				
		Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", 100.0, "Blanco", true, 1);
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("Matricula: " + vehiculo1.matricula);
				System.out.println("Marca: " + vehiculo1.marca);
				System.out.println("Kilometraje total: " + vehiculo1.kilometrajeTotal + " km");
				System.out.println("Modelo: " + vehiculo1.modelo);
				System.out.println("Color: " + vehiculo1.color);
				System.out.println("Tarifa: " + vehiculo1.tarifa);
				System.out.println("Disponible: " + vehiculo1.disponible);
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

				
				
		Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", 80.0, "Negro", true, 1);

				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("Matricula: " + vehiculo2.matricula);
				System.out.println("Marca: " + vehiculo2.marca);
				System.out.println("Kilometraje total: " + vehiculo2.kilometrajeTotal  + " km");
				System.out.println("Modelo: " + vehiculo2.modelo);
				System.out.println("Color: " + vehiculo2.color);
				System.out.println("Tarifa: " + vehiculo2.tarifa);
				System.out.println("Disponible: " + vehiculo2.disponible);
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

			
		
		Cliente cliente1 = new Cliente ("67405415L", "Federico", "Diaz");
		
		vehiculoAlquilado alquiler1 = new vehiculoAlquilado (cliente1, vehiculoFreddiie, 11, 11, 2021, 2);
			
			cliente1.setNombre("Alvaro");

				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- CLIENTE --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("DNI : " + alquiler1.getCliente().getnif());
				System.out.println("Nombre : " + alquiler1.getCliente().getNombre());
				System.out.println("Apellidos: " + alquiler1.getCliente().getApellidos());
				System.out.println("FECHA -- " + " DIA: " + alquiler1.getdiaAlquiler() + " MES: " + alquiler1.getmesAlquiler() + " AÑO: " + alquiler1.getañoAlquiler());	
				System.out.println("Dias vehiculo alquilado: " + alquiler1.gettotalDiasAlquiler() + " dias");
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

				
				
		Cliente clienteEj = new Cliente ("30435624X", "Juan", "Pérez");
				
		vehiculoAlquilado alquiler2 = new vehiculoAlquilado (clienteEj, vehiculo1, 31, 11, 2021, 2);
		
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- CLIENTE --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println("DNI : " + alquiler2.getCliente().getnif());
				System.out.println("Nombre : " + alquiler2.getCliente().getNombre());
				System.out.println("Apellidos: " + alquiler2.getCliente().getApellidos());
				System.out.println("FECHA -- " + " DIA: " + alquiler2.getdiaAlquiler() + " MES: " + alquiler2.getmesAlquiler() + " AÑO: " + alquiler2.getañoAlquiler());	
				System.out.println("Dias vehiculo alquilado: " + alquiler2.gettotalDiasAlquiler() + " dias");
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");

				
				
		Cliente cliente3 = new Cliente (" ", " ", " ");			
			
			cliente3.setnif("76044551L");
			
			if (cliente3.validar()) {
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println(" ··· DNI CORRECTO ··· ");
				System.out.println("DNI : " + cliente3.getnif() + " ES VALIDO");
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
			} else {
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println(" ··· DNI INCORRECTO ··· ");
				System.out.println(" ··· Introduce un DNI correcto porfavor ··· ");
				System.out.println(" ");
				System.out.println("DNI : " + cliente3.getnif() + " NO ES VALIDO");
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");

				
			}
			
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			
			
			
		Cliente cliente4 = new Cliente (" ", " ", " ");			
			
			cliente4.setnif("760445512"); // Longitud mas larga y sin letra
			
			if (cliente4.validar()) {
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println(" ··· DNI CORRECTO ··· ");
				System.out.println("DNI : " + cliente4.getnif() + " ES VALIDO");
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
			} else {
				
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				System.out.println(" ");
				System.out.println(" ··· DNI INCORRECTO ··· ");
				System.out.println(" ··· Introduce un DNI correcto porfavor ··· ");
				System.out.println(" ");
				System.out.println("DNI : " + cliente4.getnif() + " NO ES VALIDO");
				System.out.println(" ");
				System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
				
			}
			
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");

			
			
				System.out.println("Introduce el DNI del cliente, por favor");
				Scanner nifCliente = new Scanner(System.in);    		
				String dniCliente = nifCliente.nextLine();			
				
				System.out.println("Introduce el nombre del cliente, por favor");
				Scanner nombreCliente = new Scanner(System.in);    		
				String nombre = nombreCliente.nextLine();		
				
				System.out.println("Introduce los apellidos del cliente, por favor");
				Scanner apellidosCliente = new Scanner(System.in);    		
				String apellidos = apellidosCliente.nextLine();			
			
				
				
			Cliente cliente5 = new Cliente (dniCliente, nombre, apellidos);		
			
			
			
				System.out.println("Introduce la matricula del vehiculo, por favor");
				Scanner matriculaVehiculo3 = new Scanner(System.in);    		
				String vehiculo3Matri = matriculaVehiculo3.nextLine();		
				
				System.out.println("Introduce la marca del vehiculo, por favor");
				Scanner marcaVehiculo3 = new Scanner(System.in);    		
				String vehiculo3Marca = marcaVehiculo3.nextLine();				
				
				System.out.println("Introduce el modelo del vehiculo, por favor");
				Scanner modeloVehiculo3 = new Scanner(System.in);    		
				String vehiculo3Mod = modeloVehiculo3.nextLine();
				
				System.out.println("Introduce la tarifa del vehiculo, por favor");
				Scanner tarifaVehiculo3 = new Scanner(System.in);    		
				double vehiculo3Tar = tarifaVehiculo3.nextDouble();
				
				System.out.println("Introduce el color del vehiculo, por favor");
				Scanner colorVehiculo3 = new Scanner(System.in);    	
				String vehiculo3Col = colorVehiculo3.nextLine();
				
				System.out.println("Introduce cual es la disponibilidad del vehiculo, por favor");
				Scanner disponibilidadVehiculo3 = new Scanner(System.in);    		
				boolean vehiculo3Disp = disponibilidadVehiculo3.nextBoolean();
				
				System.out.println("Introduce los kilometros totales del vehiculo, por favor");
				Scanner kmtotalVehiculo3 = new Scanner(System.in);    		
				double vehiculo3KmTotal = kmtotalVehiculo3.nextDouble();
			
			
			
				System.out.println("Introduce el dia del alquiler, por favor");
				Scanner diaAlquiler3 = new Scanner(System.in);    		
				int alquiler3Dia = diaAlquiler3.nextInt();
				
				System.out.println("Introduce el mes del alquiler, por favor");
				Scanner mesAlquiler3 = new Scanner(System.in);    		
				int alquiler3Mes = mesAlquiler3.nextInt();
				
				System.out.println("Introduce el año del alquiler, por favor");
				Scanner añoAlquiler3 = new Scanner(System.in);    		
				int alquiler3Año = añoAlquiler3.nextInt();
				
				System.out.println("Introduce el numero de dias que se va a alquilar el vehiculo, por favor");
				Scanner totalDiasAlquiler3 = new Scanner(System.in);    		
				int alquiler3TotalDias = totalDiasAlquiler3.nextInt();
			
			
			
			Vehiculo vehiculo3 = new Vehiculo(vehiculo3Matri, vehiculo3Marca, vehiculo3Mod, vehiculo3Tar, vehiculo3Col, vehiculo3Disp, vehiculo3KmTotal);

			vehiculoAlquilado alquiler3 = new vehiculoAlquilado (cliente5, vehiculo3, alquiler3Dia, alquiler3Mes, alquiler3Año, alquiler3TotalDias);

			

			
			
						if (cliente5.validar()) {
							
							System.out.println(" --- --- --- --- --- --- --- --- --- --- --- COMPROBACION DNI --- --- --- --- --- --- --- --- --- --- --- ");
							System.out.println(" ");
							System.out.println(" ··· DNI CORRECTO ··· ");
							System.out.println("DNI : " + cliente5.getnif() + " ES VALIDO");
							System.out.println(" ");
							System.out.println("Se ha introducido: " + cliente5.getNombre() + " " + cliente5.getApellidos() + " con el DNI: " + cliente5.getnif());
							System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
							
						} else {
							
							System.out.println(" --- --- --- --- --- --- --- --- --- --- --- COMPROBACION DNI --- --- --- --- --- --- --- --- --- --- --- ");
							System.out.println(" ");
							System.out.println(" ··· DNI INCORRECTO ··· ");
							System.out.println(" ··· Introduce un DNI correcto porfavor ··· ");
							System.out.println(" ");
							System.out.println("DNI : " + cliente5.getnif() + " NO ES VALIDO");
							System.out.println(" ");
							System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
							
						}
						
						

					System.out.println(" ");
					System.out.println(" ");

						
						
					System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- VEHICULO ALQUILADO --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
					System.out.println(" ");
					System.out.println("Matricula: " + vehiculo3.matricula);
					System.out.println("Marca: " + vehiculo3.marca);
					System.out.println("Kilometraje total: " + vehiculo3.kilometrajeTotal  + " km");
					System.out.println("Modelo: " + vehiculo3.modelo);
					System.out.println("Color: " + vehiculo3.color);
					System.out.println("Tarifa: " + vehiculo3.tarifa);
					System.out.println("Disponible: " + vehiculo3.disponible);
					System.out.println(" ");
					System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");

					System.out.println(" ");
					System.out.println(" ");

					System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- INFORMACION DEL CLIENTE --- --- --- --- --- --- --- --- --- --- --- --- --- ");
					System.out.println(" ");
					System.out.println("DNI : " + alquiler3.getCliente().getnif());
					System.out.println("Nombre : " + alquiler3.getCliente().getNombre());
					System.out.println("Apellidos: " + alquiler3.getCliente().getApellidos());
					System.out.println("FECHA -- " + " DIA: " + alquiler3.getdiaAlquiler() + " MES: " + alquiler3.getmesAlquiler() + " AÑO: " + alquiler3.getañoAlquiler());	
					System.out.println("Dias vehiculo alquilado: " + alquiler3.gettotalDiasAlquiler() + " dias");
					System.out.println(" ");
					System.out.println(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ");
			
					
					
			
					
////////////////
					
	}
		
	
	
	
	
	
// // // // 
	
}
