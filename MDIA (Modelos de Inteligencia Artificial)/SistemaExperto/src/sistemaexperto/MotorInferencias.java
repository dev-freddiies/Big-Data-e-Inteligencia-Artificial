package sistemaexperto;

import java.util.ArrayList;
/**
 * Motor de Inferencia de Razonamiento Deductivo, fácilmente adaptable a otros problemas 
 * de identificación (de plantas, de insectos, de animales, de rocas)
 */


public class MotorInferencias {

// --- --- --- --- --- --- --- --- --- --- --- --- --- VARIABLES DE LA CLASE --- --- --- --- --- --- --- --- --- --- --- --- --- //

    private BaseDeHechos bdf;
    private BaseDeReglas bdr;
    private IHM ihm;
    private int nivelMaxRegla;

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


    
// --- --- --- --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public  MotorInferencias(IHM ihm) {
        this.ihm = ihm;
        this.bdf = new BaseDeHechos();
        this.bdr = new BaseDeReglas();
    }
    
// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



// --- --- --- --- --- --- --- --- --- --- --- --- --- --- PEDIMOS VALORES ENTEROS Y BOOLEANOS --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

    // Solicita un valor entero al ihm (El programa principal Aplicacion implementará este interfaz utilizando los siguientes métodos)
    int PedirValorEntero(String pregunta) {
        return ihm.PedirValorEntero(pregunta);
    }
    
    // Solicita un valor booleano al ihm
    boolean PedirValorBooleano(String pregunta) {
        return ihm.PedirValorBooleano(pregunta);
    }
    
// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    /***
    Indica si una regla pasada como argumento es aplicable: debe cumplir todas las premisas.
    Este método recorre los hechos indicados como premisa y verifica si existen en la base de hechos.
     
    Pueden darse varios casos:
    
        - El hecho no está presente en la base de hechos: 
        o bien posee una pregunta, y en este caso hay que consultar el valor al usuario y agregarlo a la base de hechos, 
        o bien no posee ninguna pregunta (en cuyo caso es un hecho sólamente inferible, derivado de aplicar reglas), y  la regla no podrá aplicarse.
        
        - El hecho está presente en la base de hechos:  
        bien el valor se corresponde, en cuyo caso pasamos al hecho siguiente, 
        o bien el valor no se corresponde, en cuyo caso la regla no se aplicará.

        Durante el recorrido de los hechos, es preciso buscar cuál es el nivel máximo de las premisas. 

        Si la regla se aplica, el hecho inferido tendrá como nivel el de las premisas + 1. 

        De este modo, una regla que tenga premisas de nivel 0 y 3 creará un hecho de nivel 4.

    Si una regla es aplicable el método devuelve su nivel, si no devuelve -1
     */



    int EsAplicable(Regla r) {

        int nivelMax = -1;

        // Se verifica la veracidad de cada premisa

        for (IHecho f : r.getPremisas()) {

            IHecho hechoEncontrado = bdf.Buscar(f.Nombre());        // hechoEncontrado en IHecho lo buscamos en la base de hechos y buscamos el nombre en f Nuevo Hecho 
                                                                    // (Entero o booleano) y f esta en Hechofactory

            if (hechoEncontrado == null) {

                // Este hecho no existe en base de hechos

                if (f.Pregunta() != null) {

                    hechoEncontrado = HechoFactory.Hecho(f, this);      // Si este hecho esta en HechoFactory lo almacenamos en la variable hechoencontrado
                    bdf.AgregarHecho(hechoEncontrado);                  // Almacenamos hechoEncontrado en AgregarHecho para agregarlo en la base de hechos 
                                    
                } else {

                    return -1;

                }

            }
            
            // El hecho existe en base (antes o creado), ¿pero con el valor correcto?

            if (!hechoEncontrado.Valor().equals(f.Valor())) {           // Si no encontramos el valor nos devuelve -1

                return -1;

            } else {

                nivelMax = Math.max(nivelMax, hechoEncontrado.Nivel());
            }
        }
        return nivelMax;
    }
    


    /**
      
    Devuelve la primera regla aplicable de la base que se pasa como argumento
    
    Si puede aplicarse alguna regla, esta se devuelve, y el atributo @nivelMaxRegla del motor se modifica para contener el nivel de la regla devuelta. 
    
    En caso de que no pueda aplicarse ninguna regla, se devuelve null
    
    */ 



    Regla BuscadorRegla(BaseDeReglas bdrLocale) {

        for(Regla r : bdrLocale.getReglas()) {

            int nivel = EsAplicable(r);
            
            if (nivel != -1) {

                nivelMaxRegla = nivel;

                return r;
            }
        }

        return null;
    }
    


    /*
    Algoritmo principal que permtite resolver un caso dado

    Se realiza una copia local de todas las reglas existentes y se inicializa la base de hechos (vacía).
         
    Mientras pueda aplicarse alguna regla:
         
        Se aplica, y el hecho inferido se agrega a la base de hechos (incrementando su nivel).
        Se elimina la regla (para no volver a ejecutarla más adelante sobre el mismo problema).
        Cuando no quedan más reglas aplicables, se muestra el resultado.  
    */ 



    public void Resolver() {

        // Se copian todas las reglas en brdLocale
        BaseDeReglas bdrLocale = new BaseDeReglas();
        bdrLocale.setReglas(bdr.getReglas());
        
        // Se vacía la base de hechos
        bdf.Vaciar();
        
        // mientras existan reglas a aplicar
        Regla r = BuscadorRegla(bdrLocale);
        while(r!=null) {

            // Aplicar la regla
            IHecho nuevoHecho = r.conclusion;
            nuevoHecho.setNivel(nivelMaxRegla + 1);
            bdf.AgregarHecho(nuevoHecho);

            // Eliminar la regla de las posibles para no volver a aplicarla
            bdrLocale.EliminarRegla(r);

            // Buscar la siguiente regla aplicable
            r = BuscadorRegla(bdrLocale);
        }
        
        // Visualización de los resultados
        ihm.MostrarHechos(bdf.getHechos());
    }
    


    // Agregar una regla a la base a partir de su cadena
    // En forma :
    // Nombre : IF premisas THEN conclusion
    
    public void AgregarRegla(String str) {

        // Separación nombre:regla
        String [] nombreRegla = str.split(":");         // El metodo split sirve para separar un string o cadena de texto en varios strings
                                                        // Entonces basicamente lo que esta haciendo es que separa en distintos strings separados por : y lo almacena en un string

        if (nombreRegla.length == 2) {                  // Si la longitud del nombre de la regla es igual a 2

            String nombre = nombreRegla[0].trim();      // trim elimina los espacios en blanco en ambos extremos del string

            // Separación premisas THEN conclusión
            String regla = nombreRegla[1].trim();

            regla = regla.replaceFirst("^" + "IF", "");

            String[] premisasConclusion = regla.split("THEN");

            if (premisasConclusion.length == 2) {

                // Lectura de las premisas
                ArrayList<IHecho> premisas = new ArrayList();

                String[] premisasStr = premisasConclusion[0].split(" AND ");

                for(String cadena : premisasStr) {

                    IHecho premisa = HechoFactory.Hecho(cadena.trim());
                    premisas.add(premisa);

                }

                // Lectura de la conclusión
                String conclusionStr = premisasConclusion[1].trim();
                IHecho conclusion = HechoFactory.Hecho(conclusionStr);

                // Creación de la regla y adición a la base
                bdr.AgregarRegla(new Regla(nombre, premisas, conclusion));
            }

        }

    }

}
