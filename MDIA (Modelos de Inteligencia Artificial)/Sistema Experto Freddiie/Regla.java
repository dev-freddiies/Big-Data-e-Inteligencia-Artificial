import java.util.ArrayList; 
import java.util.StringJoiner; 
public class Regla { 
 protected ArrayList<IHecho> premisas; 
 public ArrayList<IHecho> getPremisas() { 
 return premisas; 
 } 
 public void setPremisas(ArrayList<IHecho> _premisas) { 
 premisas = _premisas; 
 } 
 protected IHecho conclusion; 
 public IHecho getConclusion() { 
 return conclusion; 
 } 
 public void setConclusion(IHecho _conclusion) { 
 conclusion = _conclusion; 
 } 
 protected String nombre; 
 public String getNombre() { 
 return nombre; 
 } 
 public void setNombre(String _nombre) { 
 nombre = _nombre; 
 } 
 public Regla(String _nombre, ArrayList<IHecho> _premisas, 
IHecho _conclusion) { 
 nombre = _nombre; 
 premisas = _premisas; 
 conclusion = _conclusion;
} 

@Override 
 public String toString() { 
 String cadena = nombre + " : IF ("; 
 StringJoiner sj = new StringJoiner(" AND "); 
 for(IHecho hecho : premisas) { 
 sj.add(hecho.toString()); 
 } 
 cadena += sj.toString() + ") THEN " + conclusion.toString(); 
 return cadena; 
 }
}

