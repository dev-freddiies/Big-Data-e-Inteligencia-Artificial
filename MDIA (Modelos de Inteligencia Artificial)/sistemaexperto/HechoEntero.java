package sistemaexperto;
/**
 * Clase que implementa la interfaz iHecho
 * Representa un hecho entero
 * 
 * @author Alfredo
 * @version 1.0
 */

public class HechoEntero implements iHecho {
    
    protected String nombre;    //Nombre del hecho
    protected int valor;    // En la interfaz esta definido como object
                            // En esta clase se concreta como entero
    protected int nivel;
    protected String pregunta;



    public HechoEntero(String nombre, int valor, int nivel, String pregunta) {
        this.nombre = nombre;
        this.valor = valor;
        this.nivel = nivel;
        this.pregunta = pregunta;
    }



    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Object getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }



}
