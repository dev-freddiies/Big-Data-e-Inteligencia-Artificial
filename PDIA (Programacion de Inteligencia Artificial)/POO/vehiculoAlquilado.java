package com.POO;

//--- --- --- --- --- --- --- CLASE VEHICULO ALQUILADO --- --- --- --- --- --- --- //


public class vehiculoAlquilado {
			
	private Cliente cliente;
	private Vehiculo vehiculo;
	private int diaAlquiler;
	private int mesAlquiler;
	private int a�oAlquiler;
	private int totalDiasAlquiler;
	
// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	public vehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, int diaAlquiler, int mesAlquiler, int a�oAlquiler, int totalDiasAlquiler) {
		
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.diaAlquiler = diaAlquiler;
		this.mesAlquiler = mesAlquiler;
		this.a�oAlquiler = a�oAlquiler;
		this.totalDiasAlquiler = totalDiasAlquiler;
		
	}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	

	
	
	// --- --- --- --- --- --- --- GETTER Y SETTER --- --- --- --- --- --- --- //

	public Cliente getCliente() {
		
		return this.cliente;
		
	}
	
	// --- ---
	
	public Vehiculo getVehiculo() {
		
		return this.vehiculo;
		
	}
	
	// --- ---
	
	public int getdiaAlquiler() {
		
		return diaAlquiler;
	}
	public void setdiaAlquiler(int diaAlquiler) {
	
		this.diaAlquiler = diaAlquiler;
	}
	
	// --- ---
	
	public int getmesAlquiler() {
		
		return mesAlquiler;
	}
	public void setmesAlquiler(int mesAlquiler) {
	
		this.mesAlquiler = mesAlquiler;
	}
	
	// --- ---
	
	public int geta�oAlquiler() {
		
		return a�oAlquiler;
	}
	public void seta�oAlquiler(int a�oAlquiler) {
	
		this.a�oAlquiler = a�oAlquiler;
	}
	
	// --- ---
	
	public int gettotalDiasAlquiler() {
		
		return totalDiasAlquiler;
	}
	public void settotalDiasAlquiler(int totalDiasAlquiler) {
	
		this.totalDiasAlquiler = totalDiasAlquiler;
	}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

		
}
		

//--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //