package sistemaexperto;
import java.util.ArrayList;

public class BaseDeHechos {
    
    protected ArrayList<IHecho> hechos;   // Lista de los hechos 

    
    // --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR BASE DE HECHOS --- --- --- --- --- --- --- --- --- --- --- //
    
    public BaseDeHechos() {            // La base de hechos esta compuesta por metodos y por una variable que se inicializa a traves de un array
        hechos = new ArrayList();                                                               
    } 
    public ArrayList<IHecho> getHechos () { 
        return hechos; 
    } 

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- BORRAR UN HECHO --- --- --- --- --- --- --- --- --- --- --- --- //

    public void Vaciar() {
        hechos.clear();             // Se hace con un clear llamando a la variable hechos (que es un array vaya)
    }
    
    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- AGREGAR UN HECHO --- --- --- --- --- --- --- --- --- --- --- --- //

    public void AgregarHecho(IHecho hecho) {
        hechos.add(hecho);
    }
                                                        // Hacen falta métodos más específicos                                          
    public IHecho Buscar(String nombre) {               // Buscar un hecho a partir de su NOMBRE, y devuelve null si no existe
        for(IHecho hecho: hechos) {                     // En el bucle for los dos puntos es una forma de hacer el bucle for each
            if (hecho.Nombre().equals(nombre)) {        // Si el Nombre que esta en la clase hecho es igual al nombre (Que será el que introducen por parámetro)
                return hecho;                           // Retorna hehcho
            }
        }
        return null;                                    // Si no retorna null
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- RECUPERAR VALOR HECHO (O BUSCAR) --- --- --- --- --- --- --- --- --- --- --- --- //
 
    public Object RecuperarValorHecho(String nombre) {      // Creamos un Objeto llamado RecuperarValorHecho metiendole un String (el nombre que me meten por parametro)
        for(IHecho hecho : hechos) {                        // Otra vez el bucle for each con los dos puntos
            if (hecho.Nombre().equals(nombre)) {            // Si el Nombre que está en la clase hecho es igual al nombre
                return hecho.Valor();                       // Nos retorna el valor que está alojado en la calse hecho
            }
        }
        return null;                                        // Si no null
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


}
