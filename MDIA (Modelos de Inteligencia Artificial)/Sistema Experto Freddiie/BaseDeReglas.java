import java.util.ArrayList; 
class BaseDeReglas { 
 protected ArrayList<Regla> reglas; 
 public ArrayList<Regla> getReglas() { 
 return reglas; 
 } 
 public void setReglas(ArrayList<Regla> _reglas) { 
 // Se copian las reglas y se agregan 
 for (Regla r : _reglas) { 
 Regla copia = new Regla(r.nombre, r.premisas, r.conclusion); 
 reglas.add(copia); 
 } 
 } 
 public BaseDeReglas() { 
 reglas = new ArrayList(); 
 } 

 public void ClearBase() 
 { 
 reglas.clear(); 
 } 
 public void AgregarRegla(Regla r) 
 { 
 reglas.add(r); 
 } 
 public void Eliminar(Regla r) 
 { 
 reglas.remove(r); 
 }
}