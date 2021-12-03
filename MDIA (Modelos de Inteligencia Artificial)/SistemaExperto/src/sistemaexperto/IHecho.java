package sistemaexperto;

// --- --- --- --- --- --- --- --- --- --- --- --- --- CREAMOS LA INTERFAZ IHECHO --- --- --- --- --- --- --- --- --- --- --- --- --- //

/*
Una interfaz () es sintácticamente similar a una clase abstracta, en la que puede especificar uno o más métodos que no tienen cuerpo ({}). 
Esos métodos deben ser implementados por una clase para que se definan sus acciones.
Por lo tanto, una interfaz especifica qué se debe hacer, pero no cómo hacerlo. Una vez que se define una interfaz, 
cualquier cantidad de clases puede implementarla. Además, una clase puede implementar cualquier cantidad de interfaces.
*/

public interface IHecho {

    // Interface para todos los hechos que se debe implementar

    String Nombre();
    Object Valor(); // posteriormente será o Entero o Booleano
    int Nivel();
    String Pregunta();
    
    void setNivel(int l); // Permite modificar el nivel de un hecho

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- -- --- --- --- --- --- --- --- --- --- --- --- //

}
