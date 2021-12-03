package com.POO;

public class Vehiculo {

	/*
	# Matricula: String
	# Marca: String
	# Tarifa: doble
	# Color: String
	# Disponible: booleano
	# kilometrajeTotal: int
	
	-- getter
	-- setter
	-- void recorre(int km)
	*/

	
	
	
	
	//  --- --- --- --- --- --- VARIABLES DE LA CLASE --- --- --- --- --- ---  //	
	
	public String matricula;
	public String marca;
	public String modelo;
	public double tarifa;
	public String color;
	public boolean disponible;
	public double kilometrajeTotal;
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	Vehiculo (String matricula, String marca, String modelo, double tarifa, String color, boolean disponible, double kilometrajeTotal) {
		
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.tarifa = tarifa;
		this.color = color;
		this.disponible = disponible;
		this.kilometrajeTotal = kilometrajeTotal;
		
	}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
	// --- --- --- --- --- --- --- GETTER Y SETTER --- --- --- --- --- --- --- //

	public String getMatricula() {
		
		return matricula;
		
	}
	public void setMatricula(String matricula) {
		
		this.matricula = matricula;
		
	}
	
	// --- ---
	
	public String getMarca(String marca) {
		
		return marca;
		
	}
	public void setMarca(String marca) {
		
		this.marca = marca;
	}
	
	// --- ---
	
	public String getModelo(String modelo) {
		
		return modelo;
		
	}
	public void setModelo(String modelo) {
		
		this.modelo = modelo;
	}
	
	// --- ---
	
	public double getTarifa(double tarifa) {
	
		return tarifa;
	}
	public void setTarifa(double tarifa) {
	
		this.tarifa = tarifa;
	}
	
	// --- ---
	
	public String getColor(String color) {
		
		return color;
		
	}
	public void setColor(String color) {
		
		this.color = color;
		
	}
	
	// --- ---
	
	public boolean isDisponible(boolean disponible) {
	
		return disponible;
		
	}
	public void setDisponible(boolean disponible) {
	
		this.disponible = disponible;
		
	}
	
	// --- ---
	
	public double getkilometrajeTotal(double kilometrajeTotal) {
		
		return kilometrajeTotal;
		
	}
	public void setkilometrajeTotal(double kilometrajeTotal) {
	
		this.kilometrajeTotal = kilometrajeTotal;
		
	}
	
	// --- ---
	

	


	public double recorre(double km) {
		
		this.kilometrajeTotal = km + this.kilometrajeTotal;
		
		return this.kilometrajeTotal;
		
	}
	
	public void arrancar() {
		
		System.out.println("El coche está arrancado");
		
	}
	
	public void parar() {
		
		System.out.println("El coche está parado");
		
	}
	
	
	
	public boolean primeralquiler() {
		
		boolean disponibilidad = false;
		
		if ((disponible == true) && (kilometrajeTotal == 0)) {
			
			disponibilidad = true;
			
		}
		
		return disponibilidad;
		
	}

	
	
	
// // // //
}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //
