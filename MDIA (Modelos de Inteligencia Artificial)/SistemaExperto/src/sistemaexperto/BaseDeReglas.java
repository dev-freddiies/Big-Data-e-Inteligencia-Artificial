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
        this.reglas = new ArrayList();          // Almaceno las reglas en el array
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- GET REGLAS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public ArrayList<Regla> getReglas() {       // Busca en el array la regla y las "coge"
        return reglas;                          // Nos retorna las reglas
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- BASE DE REGLAS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    /**
     * Método para copiar y agregar reglas de un array reglasnuevas
     * @param reglas
     */
    public void setReglas(ArrayList<Regla> reglasnuevas) {                      // Inserta nuevas reglas en el array
        for (Regla r : reglasnuevas) {
            Regla copia = new Regla (r.nombre, r.premisas, r.conclusion);       // Para copiarla crea una nueva regla en la cual nos insertan el nombre, la premisa y la conclusion
            this.reglas.add(copia);                                             // Añade la copia
        } 
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- BORRA, AÑADE Y ELIMINA --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public void ClearBase()
    {
        this.reglas.clear();
    }

    public void AgregarRegla(Regla r)
    {
        this.reglas.add(r);
    }
    
    public void EliminarRegla(Regla r)
    {
        this.reglas.remove(r);
    }
    
    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


}
