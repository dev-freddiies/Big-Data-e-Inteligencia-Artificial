import java.util.ArrayList; 
class BaseDeHechos { 

    protected ArrayList<IHecho> hechos; 
    public ArrayList<IHecho> getHechos() 
    { 
    return hechos; 
    } 
    public BaseDeHechos() 
    { 
    hechos = new ArrayList<IHecho>(); 

} 

public void Vaciar() { 

    hechos.clear(); 
    } 
    public void AgregarHecho(IHecho hecho) { 
    hechos.add(hecho); 
    }



public IHecho Buscar(String nombre) { 
    for(IHecho hecho : hechos) { 
    if (hecho.Nombre().equals(nombre)) { 
    return hecho; 
    } 
    } 
    return null; 
    } 
    public Object RecuperarValorHecho(String nombre) { 
    for(IHecho hecho : hechos) { 
    if (hecho.Nombre().equals(nombre)) { 
    return hecho.Valor(); 
    }
} 
return null; 
    }
}
    