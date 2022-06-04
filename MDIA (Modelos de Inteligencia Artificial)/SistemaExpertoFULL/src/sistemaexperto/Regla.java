package sistemaexperto;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Regla {
    protected String nombre;
    protected ArrayList<IHecho> premisas;
    protected IHecho conclusion;

    public Regla(String nombre, ArrayList<IHecho> premisas, IHecho conclusion) {
        this.nombre = nombre;
        this.premisas = premisas;
        this.conclusion = conclusion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<IHecho> getPremisas() {
        return new ArrayList<IHecho>(this.premisas);
    }

    public void setPremisas(ArrayList<IHecho> premisas) {
        this.premisas = new ArrayList<IHecho>(premisas);
    }

    public IHecho getConclusion() {
        return this.conclusion;
    }

    public void setConclusion(IHecho conclusion) {
        this.conclusion = conclusion;
    }

    public String toString() {
        String cadena = this.nombre + " : IF (";

        StringJoiner sj = new StringJoiner(" AND ");

        for (IHecho hecho: premisas) {
            sj.add(hecho.toString());
        }

        cadena += sj.toString() + ") THEN " + this.conclusion.toString();
        return cadena;
    }

}
