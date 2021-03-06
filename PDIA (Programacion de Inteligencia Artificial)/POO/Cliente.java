package com.POO;

//--- --- --- --- --- --- --- CLASE CLIENTE --- --- --- --- --- --- --- //


public class Cliente {
			
	private String nif;
	private String nombre;
	private String apellidos;
	
// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	
	
	// --- --- --- CONSTRUCTOR QUE INICIALIZA LAS VARIABLES DE CLASE --- --- --- //

	public Cliente(String nif, String Nombre, String apellidos) {
		
		this.nif = nif;
		this.nombre = Nombre;
		this.apellidos = apellidos;
		
	}
	
	// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

	
	
	
	
	// --- --- --- VALIDAR DNI --- --- --- //

	public boolean validar() {

		String letraMayuscula = ""; //Guardaremos la letra introducida en formato may?scula
			
		// Aqu? excluimos cadenas distintas a 9 caracteres que debe tener un dni y tambi?n si el ?ltimo caracter no es una letra
		if(nif.length() != 9 || Character.isLetter(this.nif.charAt(8)) == false) {
			return false;
		}
		
		// Al superar la primera restricci?n, la letra la pasamos a may?scula
		letraMayuscula = (this.nif.substring(8)).toUpperCase();

		// Por ?ltimo validamos que s?lo tengo 8 d?gitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuaci?n
		// Llamamos a los m?todos privados de la clase soloNumeros() y letraDNI()
		if(soloNumeros() == true && letraDNI().equals(letraMayuscula)) {
			return true;
		}
		else {
			return false;
		}
	}

		private boolean soloNumeros() {

			int i, j = 0;
			String numero = ""; // Es el n?mero que se comprueba uno a uno por si hay alguna letra entre los 8 primeros d?gitos
			String miDNI = ""; // Guardamos en una cadena los n?meros para despu?s calcular la letra
			String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

			for(i = 0; i < this.nif.length() - 1; i++) {
				numero = this.nif.substring(i, i+1);

				for(j = 0; j < unoNueve.length; j++) {
					if(numero.equals(unoNueve[j])) {
						miDNI += unoNueve[j];
					}
				}
			}

			if(miDNI.length() != 8) {
				return false;
			}
			else {
				return true;
			}
		}

		private String letraDNI() {
		// El m?todo es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella

		// pasar miNumero a integer
		int miDNI = Integer.parseInt(this.nif.substring(0,8));
		int resto = 0;
		String miLetra = "";
		String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

		resto = miDNI % 23;

		miLetra = asignacionLetra[resto];

		return miLetra;
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
