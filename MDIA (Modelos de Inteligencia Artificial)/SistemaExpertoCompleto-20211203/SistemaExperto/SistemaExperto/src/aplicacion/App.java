package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import sistemaexperto.IHM;
import sistemaexperto.IHecho;
import sistemaexperto.MotorInferencias;
import sistemaexperto.Regla;

public class App implements IHM {
    public static void main(String[] args) throws Exception {
        App app = new App();

        app.run();
    }

    public void run() {

        System.out.println("Bienvenido a Sistema Experto.");

        System.out.println("Creación del motor de inferencia.");

        MotorInferencias m = new MotorInferencias(this);

        System.out.println("Agregación de reglas.");



    /*m.agregarRegla("R1 : IF (Orden=3 (¿Cuál es el orden?)) THEN  Triángulo");

        m.agregarRegla("R2 : IF (Triángulo AND Ángulo Recto (¿La figura tiene al menos un ángulo recto?)) THEN Triángulo Rectángulo");

        m.agregarRegla("R3 : IF (Triángulo AND Lados Iguales=2 (¿Cuántos lados iguales tiene la figura?)) THEN Triángulo Isósceles");

        m.agregarRegla("R4 : IF (Triángulo rectángulo AND Triángulo Isósceles) THEN Triángulo Rectángulo Isósceles");

        m.agregarRegla("R5 : IF (Triángulo AND Lados Iguales=3 (¿Cuántos lados iguales tiene la figura?)) THEN Triángulo Equilátero");

        m.agregarRegla("R6 : IF (Orden=4 (¿Cuál es el orden?)) THEN Cuadrilátero");

        m.agregarRegla("R7 : IF (Cuadrilátero AND Lados Paralelos=2 (¿Cuántos lados paralelos entre sí - 0, 2 o 4?)) THEN Trapecio");

        m.agregarRegla("R8 : IF (Cuadrilátero AND Lados Paralelos=4 (¿Cuántos lados paralelos entre sí - 0, 2 o 4?)) THEN Paralelogramo");

        m.agregarRegla("R9 : IF (Paralelogramo AND Ángulo Recto (¿La figura tiene al menos un ángulo recto?)) THEN Rectángulo");

        m.agregarRegla("R10 : IF (Paralelogramo AND Lados Iguales=4 (¿Cuántos lados iguales tiene la figura?)) THEN Rombo");

        m.agregarRegla("R11 : IF (Rectángulo AND Rombo THEN Cuadrado");*/

        ////

        /*
        m.agregarRegla("R1 : IF (Orden=1 (¿Cuál es el orden?)) THEN  jugador");

        m.agregarRegla("R2 : IF (jugador AND guantes (¿El jugador lleva guantes?)) THEN portero");

        m.agregarRegla("R3 : IF (!guantes (¿El jugador juega en el campo?)) THEN jugadorCampo");

        m.agregarRegla("R4 : IF (jugadorCampo AND atras (¿El jugador juega atras?)) THEN defensa");

        m.agregarRegla("R5 : IF (defensa AND bandas (¿El jugador juega en las bandas?)) THEN lateral");

        m.agregarRegla("R6 : IF (defensa AND !bandas THEN central");

        m.agregarRegla("R7 : IF (jugadorCampo AND medio (¿El jugador juega en el medio?)) THEN centroCampista");

        m.agregarRegla("R8 : IF (centroCampista AND derecha (¿El centrocampista juega en la derecha?)) THEN medioDerecha");

        m.agregarRegla("R9 : IF (centroCampista AND izquierda (¿El centrocampista juega en la izquierda?)) THEN medioIzquierda");

        m.agregarRegla("R10 : IF (jugadorCampo AND delante (¿El jugador juega en la posicion de delante?)) THEN delantero");

        m.agregarRegla("R11 : IF (delantero AND centro (¿El jugador juega en el centro?)) THEN delanteroCentro");

        m.agregarRegla("R13 : IF (delantero AND izquierda (¿El jugador juega en la izquierda?)) THEN extremoIzquiero");

        m.agregarRegla("R14 : IF (delantero AND derecha (¿El jugador juega en la derecha?)) THEN extremoDerecho");

        m.agregarRegla("R15 : IF (!jugadorCampo (¿El jugador esta en el banquillo?)) THEN suplente");

        m.agregarRegla("R16 : IF (!suplente and dirige (¿El dirige al equipo?)) THEN directorTecnico");

        m.agregarRegla("R17 : IF (!directorTecnico (¿Se encarga del material?)) THEN utillero");
        */

        m.agregarRegla("R1 : IF (Orden=1 (¿Cuál es el orden?)) THEN  peliculas");

        m.agregarRegla("R2 : IF (peliculas AND pistolas (¿En la pelicula hay pistolas?)) THEN accion");

        m.agregarRegla("R3 : IF (!accion (¿En la pelicula hay besitos?)) THEN romance");

        m.agregarRegla("R4 : IF (risas (¿En la pelicula hay muchas muchas risas?)) THEN comedia");

        m.agregarRegla("R5 : IF (romance AND comedia (¿En la pelicula hay risas?)) THEN comediaRomantica");

        m.agregarRegla("R6 : IF (!risas (¿En la pelicula hay lagrimas?)) THEN drama");

        m.agregarRegla("R6 : IF (!risas AND drama (¿En la pelicula hay lagrimas?)) THEN dramaR");



        



       

        System.out.println("Resolución del problema.");

        while (true) {
        
            System.out.println("\n** Resolución **");
            m.resolverP();
        
        }

    }



    // Pide una valor entero al usuario, sin verificaciones (0 en caso de problema)
    public int pedirValorEntero(String pregunta) {
        
        System.out.println(pregunta);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
        
            return Integer.decode(br.readLine());
        
        } catch (IOException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        
        }
    
    }
 


    // Solicita un valor booleano, con sí (verdadero) o no. 
    // Se ignorarn los errores (devuelve falso)
    public boolean pedirValorBooleano(String pregunta) {
        
        try {
        
            System.out.println(pregunta + " (si,no)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String res = br.readLine();
            return (res.equals("si"));

        } catch (IOException e) {
        
            //TODO: handle exception
            return false;
        
        }
    
    }



    public float pedirCertidumbre() {
        
        try {
        
            System.out.println("¿Qué certidumbre tiene tu respuesta? (0 - 100)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String res = br.readLine();
            double c = Double.parseDouble(res) / 100;
            return (float)(Math.round(c * 100.0) / 100.0);
        
        } catch (IOException e) {
        
            e.printStackTrace();
            return 0;
        
        }
    
    }



    public void mostrarHechos(ArrayList<IHecho> hechos) {

        String res = "Solución/es encontrada/s :  \n";

        Collections.sort(hechos, (IHecho h1, IHecho h2) -> {
        
            return Integer.compare(h2.getNivel(), h1.getNivel());
        
        });

        for (IHecho h: hechos) {
        
            if (h.getNivel() != 0) {
        
                res += h.toString() + "\n";
        
            }
        
        }
        
        System.out.println(res);
    
    }



    public void mostrarReglas(ArrayList<Regla> reglas) {
    
        String res = "";
    
        for (Regla r: reglas) {
    
            res += r.toString() + "\n";
    
        }
    
        System.out.println(res);
    
    }

}


