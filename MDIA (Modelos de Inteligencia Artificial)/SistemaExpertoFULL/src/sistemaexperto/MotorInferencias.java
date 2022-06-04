package sistemaexperto;

import java.util.ArrayList;

public class MotorInferencias {

    private BaseDeHechos bdh;
    private BaseDeReglas bdr;
    private IHM ihm;
    private int nivelMaxRegla;
    private float certidumbreRegla;
    private boolean noAplicablePorIncertidumbre;

    public MotorInferencias(IHM ihm) {
        this.ihm = ihm;
        this.bdh = new BaseDeHechos();
        this.bdr = new BaseDeReglas();
    }

    public void agregarRegla(String str) {
        String[] nombreRegla = str.split(":");
        if (nombreRegla.length == 2) {
            String nombre = nombreRegla[0].trim();
            String regla = nombreRegla[1].trim();
            regla = regla.replaceFirst("^" + "IF", "");
            String[] premisasConclusion = regla.split("THEN");
            if (premisasConclusion.length == 2) {
                ArrayList<IHecho> premisas = new ArrayList<IHecho>();

                String[] premisasStr = premisasConclusion[0].split(" AND ");
                for (String cadena: premisasStr) {
                    IHecho premisa = HechoFactory.Hecho(cadena.trim());
                    premisas.add(premisa);
                }
                
                String conclusionStr = premisasConclusion[1].trim();
                IHecho conclusion = HechoFactory.Hecho(conclusionStr);


                this.bdr.addRegla(new Regla(nombre, premisas, conclusion));
            }
        }
    }

    public void resolverP() {
        BaseDeReglas bdrLocal = new BaseDeReglas();
        bdrLocal.setReglas(this.bdr.getReglas());
    
        this.bdh.vaciar();
    
        Regla r = buscarReglaP(bdrLocal);

        while (r != null) {
            // Si la regla no se aplica porque al menos una de las premisas tiene certidumbre < 0.5,
            // no aplicamos la regla (aunque debemos borrarla para que no vuelva a preguntar)
            if (!this.noAplicablePorIncertidumbre) {
                IHecho nuevoHecho = r.getConclusion();
                nuevoHecho.setNivel(this.nivelMaxRegla + 1);
                nuevoHecho.setCertidumbre(this.certidumbreRegla);
                this.bdh.addHecho(nuevoHecho);
            }
            //System.out.println("Eliminando la regla " + r.getNombre());
            bdrLocal.removeRegla(r);
            
            // Volvemos a colocar esto a false porque siempre suponemos que en principio la premisa es cierta
            this.noAplicablePorIncertidumbre = false;
            r = buscarReglaP(bdrLocal);
        }
    
        this.ihm.mostrarHechos(this.bdh.getHechos());
    }

    Regla buscarReglaP(BaseDeReglas bdrLocal) {
        for (Regla r: bdrLocal.getReglas()) {
            this.certidumbreRegla = 1;
            int nivel = esAplicableP(r);
            if (nivel != -1) {
                this.nivelMaxRegla = nivel;
                return r;
            } 
        }
        return null;
    }

    int esAplicableP(Regla r) {
        int nivelMax = -1;

        for (IHecho h: r.getPremisas()) {
            IHecho hechoEncontrado = this.bdh.getHecho(h.getNombre());
            if (hechoEncontrado == null) {
                if (h.getPregunta() != null) {
                    hechoEncontrado = HechoFactory.Hecho(h, this);
                    if (hechoEncontrado.getCertidumbre() < 0.5) {
                        // Si la certidumbre es < 0.5, colocamos la bandera a true y añadimos la premisa a la bdh
                        // Después retornamos -2 (puede ser lo que sea excepto -1) para salir del bucle de reglas en buscarReglaP()
                        this.noAplicablePorIncertidumbre = true;
                        this.bdh.addHecho(hechoEncontrado);
                        return -2;
                    }
                    this.bdh.addHecho(hechoEncontrado);
                } else {
                    return -1;
                }

              
            }

            if (!hechoEncontrado.getValor().equals(h.getValor())) {
                return -1;
            } else {
                nivelMax = Math.max(nivelMax, hechoEncontrado.getNivel());
                // En caso de que la certidumbre sea > 0.5 (es decir, hemos llegado hasta aquí), hay que compararla con la del resto de premisas 
                // y guardar la menor de todas. Después se utilizará este valor para asignar la certidumbre a la conclusión y propagar la probabilidad.
                if (hechoEncontrado.getCertidumbre() < this.certidumbreRegla) {
                    this.certidumbreRegla = hechoEncontrado.getCertidumbre();
                }
            }
        }

        return nivelMax;
    }

    int pedirValorEntero(String pregunta) {
        return this.ihm.pedirValorEntero(pregunta);
    }

    boolean pedirValorBooleano(String pregunta) {
        return this.ihm.pedirValorBooleano(pregunta);
    }

    float pedirCertidumbre() {
        return this.ihm.pedirCertidumbre();
    }


    /*
    public void resolver() {
        BaseDeReglas bdrLocal = new BaseDeReglas();
        bdrLocal.setReglas(this.bdr.getReglas());
    
        this.bdh.vaciar();
    
        Regla r = buscarRegla(bdrLocal);

        while (r != null) {
            IHecho nuevoHecho = r.getConclusion();
            nuevoHecho.setNivel(this.nivelMaxRegla + 1);
            this.bdh.addHecho(nuevoHecho);
    
            bdrLocal.removeRegla(r);
    
            r = buscarRegla(bdrLocal);
        }
    
        this.ihm.mostrarHechos(this.bdh.getHechos());
    }
    
    Regla buscarRegla(BaseDeReglas bdrLocal) {
        for (Regla r: bdrLocal.getReglas()) {
            int nivel = esAplicable(r);
            if (nivel != -1) {
                this.nivelMaxRegla = nivel;
                return r;
            }
        }
        return null;
    }

    int esAplicable(Regla r) {
        int nivelMax = -1;

        for (IHecho h: r.getPremisas()) {
            IHecho hechoEncontrado = this.bdh.getHecho(h.getNombre());
            if (hechoEncontrado == null) {
                if (h.getPregunta() != null) {
                    hechoEncontrado = HechoFactory.Hecho(h, this);
                    this.bdh.addHecho(hechoEncontrado);
                } else {
                    return -1;
                }
            }

            if (!hechoEncontrado.getValor().equals(h.getValor())) {
                return -1;
            } else {
                nivelMax = Math.max(nivelMax, hechoEncontrado.getNivel());
            }
        }

        return nivelMax;
    }
    */
    
}
