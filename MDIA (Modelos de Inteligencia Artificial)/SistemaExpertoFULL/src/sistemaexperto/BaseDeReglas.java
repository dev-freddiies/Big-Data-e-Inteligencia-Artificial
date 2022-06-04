package sistemaexperto;

import java.util.ArrayList;

public class BaseDeReglas {
    /**
     * Cuando se cree una base de reglas nueva a partir de una lista de reglas
     * hay que tener precaución de copiarlas una a una para que la eliminación 
     * de una regla en la base no provoque la eliminación del contenido
     * de la base completa
     */

    protected ArrayList<Regla> reglas;

    public BaseDeReglas() {
        this.reglas = new ArrayList<Regla>();
    }

    public ArrayList<Regla> getReglas() {
        return new ArrayList<Regla>(this.reglas);
    }
    
    public void setReglas(ArrayList<Regla> nuevasReglas) {
        this.reglas.addAll(nuevasReglas);
    }

    public void addReglas(ArrayList<Regla> reglas) {
        for (Regla regla: reglas) {
            Regla aux = new Regla(regla.getNombre(), regla.getPremisas(), regla.getConclusion());
            this.reglas.add(aux);
        }
    }

    public void clearReglas() {
        this.reglas.clear();
    }

    public void addRegla(Regla regla) {
        this.reglas.add(new Regla(regla.getNombre(), regla.getPremisas(), regla.getConclusion()));
    }

    public void removeRegla(Regla regla) {
        this.reglas.remove(regla);
    }
}
