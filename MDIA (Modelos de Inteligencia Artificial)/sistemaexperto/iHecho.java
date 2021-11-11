package sistemaexperto;
/**
 * Interfaz generica que implementara dos tipos particulares: Booleano y entero
 * 
 * @author Alfredo
 * @version 1.0
 */

public interface iHecho {   
    
    String getNombre();
    Object getValor(); // Se tratara de un valor entero o booleano
    int getNivel();    // El lugar dentro del arbol de decisiones
                    // Nivel 0 para los hechos definido por el usuario
                    // Se aumentara en un nivel para hechos inferidos
    String getPregunta();  // Se le planteará al usuario para los hechos
                        // 1ue pueden solicitarse

    void setNivel(int l);   // Permite modificar el nivel de un hecho
}
