package sistemaexperto;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
Una regla forma parte del conocimiento de un experto, la debe definir un experto.
Todo el conjunto de Reglas definidas pasarán a la Base de Reglas
 */

public class Regla {
    /**
    @nombre nombre de la regla que será una cadena de caracteres.  
    @premisas Una lista de hechos que forman las premisas de la regla (la parte izquierda).  
    @conclusion Un hecho que es la conclusión de la regla (la parte derecha).
    */



// --- --- --- --- --- --- --- --- --- --- --- --- --- DECLARAMOS LAS VARIABLES Y SUS TIPOS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    protected ArrayList<IHecho> premisas; // Lista de hechos- las premisas de la regla (parte izquierda)

    protected IHecho conclusion; // Conclusión de la regla (parte derecha)

    protected String nombre;    // Nombre de la regla

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- GETTER Y SETTER --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public ArrayList<IHecho> getPremisas() {
        return premisas;
    }

    public void setPremisas(ArrayList<IHecho> premisas) {
        this.premisas = premisas;
    }

    public IHecho getConclusion() {
        return conclusion;
    }

    public void setConclusion(IHecho conclusion) {
        this.conclusion = conclusion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR --- --- --- ---  --- --- --- --- --- --- --- --- --- --- --- --- //

    public Regla(String nombre, ArrayList<IHecho> premisas, IHecho conclusion) {

        this.nombre = nombre;
        this.premisas = premisas;
        this.conclusion = conclusion;
        
    }

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


/* 
Por motivos de legibilidad, se agrega un método toString . 

Describe la regla de la siguiente manera:

    Nombre: IF (premisa1 AND premisa2 AND premisa 3... ) THEN conclusión
    El código de este método utiliza la clase de Java, que permite concatenar varias cadenas con un separador (AND en nuestro caso).

    StringJoiner
 */



// --- --- --- --- --- --- --- --- --- --- --- METODOS QUE MUESTRA LA REGLA --- --- --- --- --- --- --- --- --- --- --- //

@Override
public String toString() { 
    String cadena = nombre + " : IF (";
    
    StringJoiner sj = new StringJoiner(" AND ");
    for(IHecho hecho : premisas) {
        sj.add(hecho.toString());
    }
    
    cadena = cadena + sj.toString() + ") THEN " + conclusion.toString();
    return cadena;
}

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



}
