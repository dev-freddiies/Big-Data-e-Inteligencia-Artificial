package sistemaexperto;

public class HechoBooleano implements IHecho {

    // --- --- --- --- --- --- --- --- --- --- --- --- --- DECLARAMOS LAS VARIABLES Y SUS TIPOS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    protected String nombre;            // Nombre del hecho
  
    protected int nivel;                // Nivel (0 para los hechos como entrada)

    protected boolean valor;            // Valor booleano del hecho

    protected String pregunta;          // Pregunta que se debe hacer al usuario si es necesario

    protected float certidumbre;

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


    public HechoBooleano(String nombre, boolean valor, int nivel, String pregunta, float certidumbre) {

		this.nombre = nombre;
		this.valor = valor;
		this.nivel = nivel;
		this.pregunta = pregunta;
		this.certidumbre = certidumbre;
	
    }


    // --- --- --- --- --- --- --- --- --- --- --- --- --- FUNCIONES --- --- --- --- --- --- --- --- --- --- --- --- --- //

    @Override
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Object getValor() {
		return this.valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public float getCertidumbre() {
		return this.certidumbre;
	}

	public void setCertidumbre(float certidumbre) {
		this.certidumbre = certidumbre;
	}

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR --- --- --- --- --- --- --- --- --- --- --- --- --- //

    /*
    public HechoBooleano(String nombre , boolean valor, String pregunta, int nivel) {
        this.nombre = nombre ;
        this.valor = valor;
        this.pregunta = pregunta;
        this.nivel = nivel;
    }
    */

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- --- METODOS --- --- --- --- --- --- --- --- --- --- --- --- --- //

    public String toString() {
		String res = "";
		if (!this.valor) {
			res += "!";
		}
		res += res + this.nombre + " (" + this.nivel + ")" + " | Certidumbre: " + this.certidumbre * 100 + "%";
		return res;
	}

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //


}
