package sistemaexperto;
import java.util.ArrayList;

public class BaseDeHechos {
    
    protected ArrayList <iHecho> hechos;    // El nombre del array es hechos
                                            // El tipo de elementos que almacena es

    public BaseDeHechos(ArrayList<iHecho> hechos) {
        this.hechos = hechos;
    }

    public ArrayList<iHecho> getHechos() {
        return hechos;
    }

    // Este no lo vamos a utilizar
    public void setHechos(ArrayList<iHecho> hechos) {
        this.hechos = hechos;
    }

    public void vaciar()

        hechos.clear();
    }
    
    public void AgregarHecho (iHecho hecho){

        hechos.add(hecho);
    }

    public iHecho Buscar (String nombre){

    }
}
