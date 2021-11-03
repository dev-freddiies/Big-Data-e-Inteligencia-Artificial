//HechoEntero contiene atributos protegidos y accesibles mediante
//metodos de la interfaz iHEcho

class HechoEntero implements iHecho {
    
    
    
    
    //atributos de mi class 
    
    //Niveles de visibilidad; public, private y protected
    
    protected String nombre; //Nombre del poligono 
    protected int valor;
    protected int nivel;
    protected String pregunta="";
    
    
    //Construcor de la Clase, sirve para reservar memoria para 
    //ese objeto
    //"Lo empleamos para inicializar los valores del objeto"
    //Se debe llamar igual que la clase 
    //Puede haber uno o varios
    public void HechoEntero(String _nombre, int _valor, String _pregunta, int _nivel){
    {
        nombre=nombre;
        valor=valor;
        pregunta=pregunta;
        nivel=nivel
    } 
    
    }
    
    
    //Métodos Getters
    
    public String Nombre(){ //GetNombre
        
        return nombre; //Devolvemos el atributo nombre

    }
    
    public valor(){
        
        return valor;
        
    }
    
    public nivel(){
        
        return nivel;
        
    }
    
    public String pregunta(){
        
        return pregunta;
        
    }
    
    
    //Métodos Setters
    
    vois setNivel(int l){
        nivel=l;
    }