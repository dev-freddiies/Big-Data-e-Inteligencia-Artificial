package sistemaexperto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 Necesitamos un método que permita preguntar al usuario el valor de un hecho y crearlo (para agregarlo, posteriormente, a la base de hechos). Como el hecho puede ser de distintos 
 tipos ( entero o booleano ), para que sea lo más genérico posible, se utilizará una clase estática como fábrica de hechos. Esta clase se encargará de crear un hecho 
 del tipo adecuado y devolverá un objeto de tipo IHecho
*/

public class HechoFactory {

/**
 clase que contendrá un método que permite crear un nuevo hecho rellenando el valor dado por el usuario
@param f Nuevo Hecho (Entero o booleano)
@param m Motor de inferencias
@return
 */ 



// --- --- --- --- --- --- --- --- --- --- --- --- --- DECLARAMOS LAS VARIABLES Y SUS TIPOS --- --- --- --- --- --- --- --- --- --- --- --- --- //

static IHecho Hecho(IHecho f, MotorInferencias m) {     // Nos creamos una funcion donde introducimos un parametro f de IHecho y m de MotorInferencias

    try {                                                                               // Try se utiliza cuando se desean prever excepciones en el transcurso de la ejecución de un programa. 
                                                                                        // Es necesario ya que ahí se colocan las instrucciones que se desean realizar pese a la excepción, 
                            
                                                                                        // posteriormente se usa un catch donde se especifica la excepción que se sabe puede ocurrir.
       
        IHecho nuevoHecho;                                                              // Creo una nueva variable nuevoHecho en IHecho

        Class clase = f.getClass();                                                     // Una variable llamada clase en la clase class la inicializo a la clase que consigo con el get que pertenece a f que esta en IHecho

        if (clase.equals(Class.forName("sistemaexperto.HechoEntero"))) {                // Si el nombre de la clase es igual a sistemaexperto.HechoEntero:
            nuevoHecho = CrearHechoEntero(f, m);                                        // Creo un nuevoHecho de tipo entero inicializado a CrearHechoEntero donde le introduzco f (de IHecho y m del MotorInferencia)
        }
        else {
            nuevoHecho = CrearHechoBooleano(f, m);                                      // Si no me crea uno booleano
        }

        return nuevoHecho;                                                              // Me retorna el nuevoHecho

    } catch (ClassNotFoundException ex) {                                               // catch en programación se utiliza para manejar fragmentos de código que son propensos a fallar, como puede ser: recibir un valor nulo, 
                                                                                        // convertir un tipo de dato a otro o en tu caso, la lectura de un archivo.
                                 
                                                                                        // Si el código que está dentro del try falla, se ejecuta el catch y el programa se sigue ejecutando.
        Logger.getLogger(HechoFactory.class.getName()).log(Level.SEVERE, null, ex);     
        return null;
    }
}

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- -- --- --- --- --- --- --- --- --- --- --- --- //



// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- CREAMOS UN HECHO ENTERO --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

static IHecho CrearHechoEntero(IHecho f, MotorInferencias m) {
   
    //Pedir valor entero
    int valor = m.PedirValorEntero(f.Pregunta());            // Si el parámetro f lleva incorporada una pregunta la recibirá el método
    return new HechoEntero(f.Nombre(), valor, null, 0);      // Nos retorna el nuevo HechoEntero
}

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- -- --- --- --- --- --- --- //



// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- CREAMOS UN HECHO BOOLEANO --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

static IHecho CrearHechoBooleano(IHecho f, MotorInferencias m) {  
    
    //Pedir valor booleano  
    boolean valorB = m.PedirValorBooleano(f.Pregunta());            // Si el parámetro f lleva incorporada una pregunta la recibirá el método
    return new HechoBooleano(f.Nombre(), valorB, null, 0);          // Nos retorna el nuevo HechoBooleano
}

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- -- --- --- --- --- --- --- //


/**
 Crea un nuevo hecho a partir de su cadena
 Los hechos se expresan con:

 "Nombre=Valor (pregunta)" para un hecho entero 
 "Nombre(pregunta) "/" !Nombre(pregunta)" para un hecho booleano.
 
    1) Se dividirá la cadena mediante los separadores (   "=", "(", ")", "!"   ),

    2) Eliminar los espacios al principio y al final de la cadena con TRIM o REPLACEFIRST(si la cadena empieza por una palabra clave)

    3) Crear el hecho correspondiente con el valor correcto.

    4) También se completará  la pregunta si esta se ha proporcionado (en cuyo caso no será un hecho solo inferido).
 */



// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- CREAMOS UN HECHO EN IHECHO --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

static IHecho Hecho(String hechoStr) {
    hechoStr = hechoStr.trim();

    // Tenemos un hecho correcto Nombre=Valor[(pregunta)]

    if (hechoStr.contains("=")) {                                       // Si la cadena contiene el símbolo "=", significa que hay un hecho entero

        hechoStr = hechoStr.replaceFirst("^" + "\\(", "");              // Remplazar al ppio cadena \ por espacio blanco
        String [] nombreValorPregunta = hechoStr.split("[=()]");        // Creamos un array llamado nombreValorPregunta 

        if (nombreValorPregunta.length >= 2) {                          // Si la longitud de nombreValorPregunta es mayor o igual a 2 igualamos la pregunta a null                     

            String pregunta = null;

            if (nombreValorPregunta.length == 3) {                      // Si la longitud de nombreValorPregunta es estrictamente igual a 3

                pregunta = nombreValorPregunta[2].trim();               // El método trim( ) elimina los espacios en blanco en ambos extremos del string, lo que esta en la posicion 2 del array

            }

            return new HechoEntero(nombreValorPregunta[0].trim(), Integer.parseInt(nombreValorPregunta[1].trim()), pregunta, 0);        // Java Integer es la clase del lenguaje Java que nos permite convertir un tipo básico int en un objeto
        }

    } else {

        boolean valor = true;                                           // Es un hecho booleano nombre[(pregunta)] o !nombre[(pregunta)]

        if (hechoStr.startsWith("!")) {

            valor = false;
            hechoStr = hechoStr.substring(1).trim();

        }
        
        hechoStr = hechoStr.replaceFirst("^" + "\\(", "");              // Split, después de haber eliminado el primer delimitador si es necesario : '('

        String[] nombrePregunta = hechoStr.split("[()]");
        String pregunta = null;

        if (nombrePregunta.length == 2) {

            pregunta = nombrePregunta[1].trim();

        }

        return new HechoBooleano(nombrePregunta[0].trim(), valor, pregunta, 0);
    }

    // Si llegamos aquí, la sintaxis es incorrecta
    return null;
}

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- -- --- --- --- --- --- --- //



}
