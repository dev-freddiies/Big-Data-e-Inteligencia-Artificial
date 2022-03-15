import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import java.util.Collections; 
public class Aplicacion implements IHM { 
 public static void main(String[] args) { 
 // A completar más tarde 
 } 
 // Solicita un valor entero al usuario 
 @Override 
 public int PedirValorEntero(String pregunta) { 
 System.out.println(pregunta); 
 try { 
 BufferedReader br = new BufferedReader(new 
InputStreamReader(System.in)); 
 return Integer.decode(br.readLine()); 
 } 
 catch (Exception e) { 
 return 0; 
 } 
 } 
 // Solicita un valor booleano, con si (verdadero) o no. 
 // Los errores se ignoran (devuelve falso) 
 @Override 
 public boolean PedirValorBooleano(String pregunta) { 
 try { 
 System.out.println(pregunta+ " (si, no)"); 
 BufferedReader br = new BufferedReader(new 
InputStreamReader(System.in)); 
 String res = br.readLine(); 
 return (res.equals("si")}; 
 }
 catch (IOException e) { 
 return false; 
 } 
 } 
}