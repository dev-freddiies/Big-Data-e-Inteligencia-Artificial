//Una interfaz en Java
/*
Una interfaz en Java es una colección de métodos abstractos y propiedades constantes. 
En las interfaces se especifica qué se debe hacer pero no su implementación. 
Serán las clases que implementen estas interfaces las que describen la lógica del comportamiento de los métodos
*/

//iHecho va a definir los metodos que permiten leer atributos y modificar el nivel de hecho
public interface iHecho{
  
  String Nombre();
  Object Valor();
  int Nivel();
  String Pregunta();
  
  void setNivel(int l); //Permitir modificar el nivel de un hecho 

    
}
