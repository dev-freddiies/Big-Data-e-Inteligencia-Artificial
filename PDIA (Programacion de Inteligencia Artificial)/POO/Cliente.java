package com.POO;

//--- --- --- --- --- --- --- CLASE CLIENTE --- --- --- --- --- --- --- //


public class Cliente {
			
	private String nif;
	private String nombre;
	private String apellidos;
	
	
	
	
	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	public Cliente(String nif, String Nombre, String apellidos) {
		
		this.nif = nif;
		this.nombre = Nombre;
		this.apellidos = apellidos;
		
	}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	// --- --- --- --- --- --- --- GETTER Y SETTER --- --- --- --- --- --- --- //

		public String getnif() {
			
			return nif;
			
		}
		public void setnif(String nif) {
			
			this.nif = nif;
			
		}
		
		// --- ---
		
		public String getNombre() {
			
			return nombre;
			
		}
		public void setNombre(String Nombre) {
			
			this.nombre = Nombre;
		}
		
		// --- ---
		
		public String getApellidos() {
		
			return apellidos;
		}
		public void setApellidos(String Apellidos) {
		
			this.apellidos = Apellidos;
		}
			
}
		

//--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //
