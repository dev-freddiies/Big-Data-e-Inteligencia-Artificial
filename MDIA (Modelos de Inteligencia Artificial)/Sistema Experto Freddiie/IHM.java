import java.util.ArrayList; 
public interface IHM { 
 int PedirValorEntero(String pregunta); 
 boolean PedirValorBooleano(String pregunta); 
 void MostrarHechos(ArrayList<IHecho> hechos); 
 void MostrarReglas(ArrayList<Regla> reglas); 
}