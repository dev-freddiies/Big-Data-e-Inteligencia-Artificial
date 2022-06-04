package sistemaexperto;

public interface IHecho {
	int getNivel();
	float getCertidumbre();
	void setNivel(int nivel);
	void setCertidumbre(float certidumbre);
	String getNombre();
	String getPregunta();
	Object getValor();
}
