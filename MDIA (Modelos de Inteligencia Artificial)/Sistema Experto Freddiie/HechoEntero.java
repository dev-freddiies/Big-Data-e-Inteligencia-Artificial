class HechoEntero implements IHecho { 

    protected String nombre; 
   
    @Override 
    public String Nombre() { 
    return nombre; 
    } 

    protected int valor; 
    @Override 
    public Object Valor() { 
    return valor; 
    }

    protected int nivel; 
    @Override 
    public int Nivel() { 
    return nivel; 
    }

    public void setNivel(int l) { 
    nivel = l; 
    }

    protected String pregunta = ""; 
    @Override 
    public String Pregunta() { 
    return pregunta; 
    }

    public HechoEntero(String nombre, int valor, String pregunta, int nivel) { 

        this.nombre = nombre; 
        this.valor = valor; 
        this.pregunta = pregunta; 
        this.nivel = nivel; 

    }

    @Override 
    public String toString() { 
    return nombre + "=" + valor +" (" + nivel + ")"; 
    }
     
   }