package sistemaexperto;

// --- --- --- --- --- --- --- --- --- --- --- --- --- CLASE HechoEntero implementando IHecho --- --- --- --- --- --- --- --- --- --- --- --- --- //

public class HechoEntero implements IHecho{

    protected String nombre;                // Nombre del hecho  
    @Override
    public String Nombre() {                
        return nombre;
    }

    protected int valor;                   // Valor entero asociado
    @Override
    public Object Valor() {
        return valor;
    }

    protected int nivel;                   // Nivel (0 para los hechos como entrada)
    @Override
    public int Nivel() {
        return nivel;
    }
    @Override
    public void setNivel(int l) {
        nivel = l;
    }
    
    protected String pregunta = "";       // Pregunta que hay que hacer al usuario si es necesario
    @Override
    public String Pregunta() {
        return pregunta;
    }

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



// --- --- --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public HechoEntero(String nombre , int valor, String pregunta, int nivel) {
        this.nombre = nombre ;
        this.valor = valor;
        this.nivel = nivel;
        this.pregunta = pregunta;
    }
    
    // Métodos toString (para la visualización)
    
    @Override
    public String toString() {
        return nombre + "=" + valor + " (" + nivel + ")";
    }

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

}
