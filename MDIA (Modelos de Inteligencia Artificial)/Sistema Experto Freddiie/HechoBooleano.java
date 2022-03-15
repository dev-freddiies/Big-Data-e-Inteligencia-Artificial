class HechoBooleano implements IHecho { 

    protected String nombre; 
    
    @Override 
    public String Nombre() { 
    return nombre; 
    } 
    
    protected boolean valor; 
    @Override 
    public Object Valor() { 
    return valor; 
    } 
    
    protected int nivel; 
    @Override 
    public int Nivel() { 
    return nivel; 
    } 
    
    @Override 
    public void setNivel(int n) { 
    nivel = n; 
    } 
    
    protected String pregunta = null; 
    @Override 
    public String Pregunta() { 
    return pregunta; 
    } 
    
    public HechoBooleano(String nombre, boolean valor, String pregunta, int nivel) { 
        this.nombre = nombre; 
        this.valor = valor; 
        this.pregunta = pregunta; 
        this.nivel = nivel; 
    } 
    
    @Override 
    public String toString() 
    { 
    
    String res = ""; 
    
    if (!valor) 
    { 
    res += "!"; 
    } 
    res += nombre + " (" + nivel + ")"; 
    return res; 
    }

   } 
   