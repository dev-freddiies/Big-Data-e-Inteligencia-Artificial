package sistemaexperto;

public class HechoBooleano implements IHecho {

    protected String nombre;
    protected boolean valor;
    protected int nivel;
    protected String pregunta;
	protected float certidumbre;

    public HechoBooleano(String nombre, boolean valor, int nivel, String pregunta, float certidumbre) {
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

	public String toString() {
		String res = "";
		if (!this.valor) {
			res += "!";
		}
		res += res + this.nombre + " (" + this.nivel + ")" + " | Certidumbre: " + this.certidumbre * 100 + "%";
		return res;
	}
}