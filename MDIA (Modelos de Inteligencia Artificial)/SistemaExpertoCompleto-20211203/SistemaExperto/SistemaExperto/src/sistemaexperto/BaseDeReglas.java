package sistemaexperto;

import java.util.ArrayList;

public class BaseDeReglas {         // Nos creamos una clase llamada BaseDeReglas

/**
 * Contiene una ista de reglas accesible en lectura o escritura a través de métodos.
 * Cuando se cree una nueva Base de reglas a partir de una lista de reglas hay que tener la 
 * precaución de copiarlas una a una para que la eliminación de una regla en la base de reglas
 * no provoque la eliminacion del contenido de la base de reglas
 */



    protected ArrayList<Regla> reglas;          // El protected es como el private


    // --- --- --- --- --- --- --- --- --- --- --- --- --- BASE DE REGLAS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public BaseDeReglas() {
        
        this.reglas = new ArrayList<Regla>();          // Almaceno las reglas en el array
    
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- GET REGLAS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public ArrayList<Regla> getReglas() {       // Busca en el array la regla y las "coge"
    
        return new ArrayList<Regla>(this.reglas);                         // Nos retorna las reglas
    
    }

    public void setReglas(ArrayList<Regla> nuevasReglas) {
        
        this.reglas.addAll(nuevasReglas);
    
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- BASE DE REGLAS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    /**
     * Método para copiar y agregar reglas de un array reglasnuevas
     * @param reglas
     */
    
    public void addReglas(ArrayList<Regla> reglas) {
    
        for (Regla regla: reglas) {
            
            Regla aux = new Regla(regla.getNombre(), regla.getPremisas(), regla.getConclusion());
            this.reglas.add(aux);
        
        }
    
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- BORRA, AÑADE Y ELIMINA --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public void clearReglas() {

        this.reglas.clear();
    
    }

    public void addRegla(Regla regla) {
        
        this.reglas.add(new Regla(regla.getNombre(), regla.getPremisas(), regla.getConclusion()));
    
    }

    public void removeRegla(Regla regla) {
        
        this.reglas.remove(regla);
    
    }
    
    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


}
