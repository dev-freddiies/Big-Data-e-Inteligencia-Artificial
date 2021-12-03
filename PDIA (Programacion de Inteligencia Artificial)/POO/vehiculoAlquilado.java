package com.POO;

//--- --- --- --- --- --- --- CLASE VEHICULO ALQUILADO --- --- --- --- --- --- --- //


public class vehiculoAlquilado {
			
	private Cliente cliente;
	private Vehiculo vehiculo;
	private int diaAlquiler;
	private int mesAlquiler;
	private int añoAlquiler;
	private int totalDiasAlquiler;
	
// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	

	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	public vehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, int diaAlquiler, int mesAlquiler, int añoAlquiler, int totalDiasAlquiler) {
		
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.diaAlquiler = diaAlquiler;
		this.mesAlquiler = mesAlquiler;
		this.añoAlquiler = añoAlquiler;
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
	
	public int getañoAlquiler() {
		
		return añoAlquiler;
	}
	public void setañoAlquiler(int añoAlquiler) {
	
		this.añoAlquiler = añoAlquiler;
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