package sistemaexperto;

// --- --- --- --- --- --- --- --- --- --- --- --- --- CLASE HechoEntero implementando IHecho --- --- --- --- --- --- --- --- --- --- --- --- --- //

public class HechoEntero implements IHecho{

	protected String nombre;
	protected int valor, nivel;
	protected String pregunta = "";
	protected float certidumbre;

    public HechoEntero(String nombre, int valor, int nivel, String pregunta, float certidumbre) {
        this.nombre = nombre;
        this.valor = valor;
        this.nivel = nivel;
        this.pregunta = pregunta;
        this.certidumbre = certidumbre;
    }

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

	public void setValor(int valor) {
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


    
    // Métodos toString (para la visualización)
    
    public String toString() {
		return this.nombre + "=" + this.valor + " (" + this.nivel + ")" + " | Certidumbre: " + this.certidumbre * 100 + "%";
	}
	

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //

}
