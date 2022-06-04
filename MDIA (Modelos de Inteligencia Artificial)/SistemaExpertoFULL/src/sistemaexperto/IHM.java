package sistemaexperto;

import java.util.ArrayList;

public interface IHM {
    public int pedirValorEntero(String pregunta);
    public boolean pedirValorBooleano(String pregunta);
    public float pedirCertidumbre();

    public void mostrarHechos(ArrayList<IHecho> hechos);
    public void mostrarReglas(ArrayList<Regla> reglas);
}
