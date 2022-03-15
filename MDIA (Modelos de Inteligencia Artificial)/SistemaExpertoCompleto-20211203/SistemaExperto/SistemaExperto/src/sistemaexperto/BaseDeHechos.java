package sistemaexperto;
import java.util.ArrayList;

public class BaseDeHechos {
    
    protected ArrayList<IHecho> hechos;   // Lista de los hechos 

    
    // --- --- --- --- --- --- --- --- --- --- --- CONSTRUCTOR BASE DE HECHOS --- --- --- --- --- --- --- --- --- --- --- //
    
    public BaseDeHechos() {
        this.hechos = new ArrayList<IHecho>();
    }

    public BaseDeHechos(ArrayList<IHecho> hechos) {
        this.hechos = hechos;
    }

    public ArrayList<IHecho> getHechos() {
        return this.hechos;
    }

    public void setHechos(ArrayList<IHecho> hechos) {
        this.hechos = hechos;
    }
    
    public void vaciar() {
        this.hechos.clear();
    }

    public void addHecho(IHecho hecho) {
        this.hechos.add(hecho);
    }


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    // --- --- --- --- --- --- --- --- --- --- --- --- BORRAR UN HECHO --- --- --- --- --- --- --- --- --- --- --- --- //

    /*
    public void Vaciar() {
        hechos.clear();             // Se hace con un clear llamando a la variable hechos (que es un array vaya)
    }
    */
    
    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- //



    public IHecho getHecho(String nombre) {

        for (IHecho hecho: this.hechos) {
        
            if (hecho.getNombre().equals(nombre)) {
        
                return hecho;
        
            }
        
        }
        
        return null;
    
    }


    
    public Object getValorHecho(String nombre) {
    
        for (IHecho hecho: this.hechos) {
    
            if (hecho.getNombre().equals(nombre)) {
    
                return hecho.getValor();
    
            }
    
        }
    
        return null;
    
    }

}
