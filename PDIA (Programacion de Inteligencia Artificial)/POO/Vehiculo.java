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
	public double tarifa;
	public String color;
	public boolean disponible;
	public int kilometrajeTotal;
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	Vehiculo (String matricula, String marca, double tarifa, String color, boolean disponible, int kilometrajeTotal) {
		
		this.matricula = matricula;
		this.marca = marca;
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
	
	public int getkilometrajeTotal(int kilometrajeTotal) {
		
		return kilometrajeTotal;
		
	}
	public void setkilometrajeTotal(int kilometrajeTotal) {
	
		this.kilometrajeTotal = kilometrajeTotal;
		
	}
}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //
