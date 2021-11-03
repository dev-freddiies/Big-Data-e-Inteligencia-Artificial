package com.democlass;

public class ClassDemo {
	
	public static void main(String[] args) {
		
	System.out.println("Este es mi primer programa en Java"); 
		
		
	/* Operadores aritmetico */
	int a = 20, b = 10, c = 0, d = 20, e = 20, f = 30;
		
	String x = "Thank", y = "You";
		
	// Operador + y -
	System.out.println("a + b = "+(a + b));
	System.out.println("a - b = "+(a - b)); 
		
	// El operador + si se usa con strings concatena las cadenas dadas
	System.out.println("x + y = "+x + y);
	
	// Operador * y /
	System.out.println("a * b = "+(a * b));
	System.out.println("a * b = "+(a / b));
	
	// Operador de modula da el resto de dividir el primer operando con el segundo
	System.out.println("a % b = "+(a % b));
	
	// Si el denominador es 0 en la division
	// System.out.println(a/c);
	// Lanzaria una java.lang.ArithmeticException
	
	/** Operadores relacionales **/
	
	int g = 20, h = 10;
	
	int ar[] = { 1, 2, 3 };
	int br[] = { 1, 2, 3 };
	boolean condition = true;
	
	// Varios operadores condicionales
	System.out.println("g == h : " + (g == h));
	System.out.println("g < h : " + (g < h));
	System.out.println("g <= h : " + (g <= h));
	System.out.println("g > h : " + (g > h));
	System.out.println("g >= h : " + (g >= h));
	System.out.println("g != h : " + (g != h));
	
	// Los arrays no se pueden comparar con operadores relacionales porque los objetos almacenan 
	// referencias, mas no el valor
	System.out.println("x == y :" + (ar == br));
	
	//System.out.println("condicion==true :" + (condicion == true));
	
	
	
	}	
}
