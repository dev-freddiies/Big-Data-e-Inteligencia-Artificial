package sistemaexperto;

import java.util.ArrayList;


 // El programa principal Aplicacion implementará este interfaz utilizando los siguientes métodos

public interface IHM {
    
    public int PedirValorEntero(String pregunta); 
    public boolean PedirValorBooleano(String pregunta); 
    public void MostrarHechos(ArrayList<IHecho> hechos); 
    public void MostrarReglas(ArrayList<Regla> reglas); 
}
