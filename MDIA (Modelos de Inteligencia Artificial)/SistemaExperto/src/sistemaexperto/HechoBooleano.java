package sistemaexperto;

public class HechoBooleano implements IHecho {

    // --- --- --- --- --- --- --- --- --- --- --- --- --- DECLARAMOS LAS VARIABLES Y SUS TIPOS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    protected String nombre;            // Nombre del hecho
  
    protected int nivel;                // Nivel (0 para los hechos como entrada)

    protected boolean valor;            // Valor booleano del hecho

    protected String pregunta;          // Pregunta que se debe hacer al usuario si es necesario

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- FUNCIONES --- --- --- --- --- --- --- --- --- --- --- --- --- //

    @Override
    public String Nombre() {        // Funcion Nombre que nos retorna el nombre del hecho
        return nombre;
    }

    @Override
    public Object Valor() {         // Igual que el nombre
        return valor;
    }

    @Override
    public int Nivel() {
        return nivel;
    }

    @Override
    public void setNivel(int n) {       // Nos introducen n y lo igualamos al nivel
        nivel = n;
    }

    @Override
    public String Pregunta() {
        return pregunta;
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public HechoBooleano(String nombre , boolean valor, String pregunta, int nivel) {
        this.nombre = nombre ;
        this.valor = valor;
        this.pregunta = pregunta;
        this.nivel = nivel;
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- METODOS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    @Override
    public String toString() {                          // Métodos toString (para la visualización) de la forma Hecho(nivel) o !Hecho(nivel)
        String res = "";
        if (!valor) {
            res += "!";
        }
        res += this.nombre + " (" + this.nivel + ")";
        return res;
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


}
