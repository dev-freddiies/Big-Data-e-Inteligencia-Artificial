package sistemaexperto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HechoFactory {
    // Crea un nuevo hecho rellenando el valor dado por el usuario
    static IHecho Hecho(IHecho h, MotorInferencias m) {

        try {
        
            IHecho nuevoHecho;
            Class clase = h.getClass();
        
            if (clase.equals(Class.forName("sistemaexperto.HechoEntero"))) {
        
                nuevoHecho = crearHechoEntero(h, m);
        
            } else {
        
                nuevoHecho = crearHechoBooleano(h, m);
        
            }
        
            return nuevoHecho;
        
        } catch (ClassNotFoundException ex) {
        
            Logger.getLogger(HechoFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }
    
    }

    // Crea un hecho entero
    static IHecho crearHechoEntero(IHecho f, MotorInferencias m) {
    
        int valor = m.pedirValorEntero(f.getPregunta());
        float certidumbre = m.pedirCertidumbre();
        return new HechoEntero(f.getNombre(), valor, 0, null, certidumbre);
    
    }

    // Crea un hecho booleano
    static IHecho crearHechoBooleano(IHecho f, MotorInferencias m) {
    
        boolean valor = m.pedirValorBooleano(f.getPregunta());
        float certidumbre = m.pedirCertidumbre();
        return new HechoBooleano(f.getNombre(), valor, 0, null, certidumbre);
    
    }



    /**
     * Crea un nuevo hecho a partir de su cadena
     * Los hechos se expresan con:
     * "Nombre=Valor (pregunta)" para un hecho entero 
     * "Nombre(pregunta)"/"!Nombre(pregunta)" para un hecho booleano.
     * 1) Se dividirá la cadena mediante los separadores (   "=", "(",")", "!"   ),
     * 2) Eliminar los espacios al principio y al final de la cadena con TRIM o REPLACEFIRST(si la cadena empieza por una palabra clave)
     * 3) Crear el hecho correspondiente con el valor correcto.
     * 4) También se completará  la pregunta si esta se ha proporcionado (en cuyo caso no será un hecho solo inferido).
     */
   


    static IHecho Hecho(String hechoStr) {
        
        hechoStr = hechoStr.trim();
        
        if (hechoStr.contains("=")) {
            // Existe el símbolo "=", por lo que es un hecho entero
        
            hechoStr = hechoStr.replaceFirst("^" + "\\(", "");
            String[] nombreValorPregunta = hechoStr.split("[=()]");
        
            if (nombreValorPregunta.length >= 2) {
                // Tenemos un hecho correcto Nombre=Valor[(pregunta)]
                String pregunta = null;
                if (nombreValorPregunta.length == 3) {
        
                    pregunta = nombreValorPregunta[2].trim();
        
                }
        
                return new HechoEntero(nombreValorPregunta[0].trim(), Integer.parseInt(nombreValorPregunta[1].trim()), 0, pregunta, 1);
        
            }
        
        } else {
            // Es un hecho booleano nombre[(pregunta)] o !nombre[(pregunta)]
        
            boolean valor = true;
        
            if (hechoStr.startsWith("!")) {
        
                valor = false;
                hechoStr = hechoStr.substring(1).trim();
        
            }
            // Split, después de aber eliminado el primer delimitador si es necesario : '('
        
            hechoStr = hechoStr.replaceFirst("^" + "\\(", "");
            String[] nombrePregunta = hechoStr.split("[()]");
            String pregunta = null;
        
            if (nombrePregunta.length == 2) {
        
                pregunta = nombrePregunta[1].trim();
        
            }
        
            return new HechoBooleano(nombrePregunta[0].trim(), valor, 0, pregunta, 1);
        
        }
        // Si llegamos aquí, la sintaxis es incorrecta
        return null;
    }
}
