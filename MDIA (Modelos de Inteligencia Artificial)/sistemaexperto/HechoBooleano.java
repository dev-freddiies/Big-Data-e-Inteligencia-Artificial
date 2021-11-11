package sistemaexperto;

public class HechoBooleano implements iHecho { 
    
    protected String nombre;    //Nombre del hecho
    protected boolean valor;    // En la interfaz esta definido como object y le hemos cambiado por un booleano
                                // En esta clase se concreta como entero
    protected int nivel;        // Nivel 0 para los hecho que son entrada
    protected String pregunta;
   
    public HechoBooleano(String nombre, boolean valor, int nivel, String pregunta) {
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

    public boolean isValor() {
        return valor;
    }
     
    public void setValor(boolean valor) {
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

    @Override
    public Object getValor() {
        // TODO Auto-generated method stub
        return valor;
    }

    
}
