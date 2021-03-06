package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import sistemaexperto.*;

public class App implements IHM {

     // Muestra la lista de hechos de nivel >0 y por orden decreciente de nivel
     public void MostrarHechos(ArrayList<IHecho> hechos) {

        String res = "Solución(s) encontrada(s) : \n"; 
        Collections.sort(hechos,(IHecho f1, IHecho f2) -> {

            return Integer.compare(f2.Nivel(), f1.Nivel());

        });

        for(IHecho f : hechos) {

            if (f.Nivel() != 0) {

                res += f.toString() + "\n";

            }
        }

        System.out.println(res);

    }

    // Muestra las reglas contenidas en la base
    public void MostrarReglas(ArrayList<Regla> reglas) {

        String res = "";

        for(Regla r : reglas) {

            res += r.toString() + "\n";

        }

        System.out.println(res);

    }
    public static void main(String[] args)  {
        
        App ap =new App();
        ap.Run();

    }

    public void Run(){

        System.out.println("SISTEMA EXPERTO");

        System.out.println("** Creación del motor **");

        MotorInferencias m = new MotorInferencias(this);

        System.out.println("** Agregar las reglas **");

    /*m.AgregarRegla("R1 : IF (Orden=3 (¿Cuál es el orden?)) THEN  Triángulo");

        m.AgregarRegla("R2 : IF (Triángulo AND Ángulo Recto (¿La figura tiene al menos un ángulo recto?)) THEN Triángulo Rectángulo");

        m.AgregarRegla("R3 : IF (Triángulo AND Lados Iguales=2 (¿Cuántos lados iguales tiene la figura?)) THEN Triángulo Isósceles");

        m.AgregarRegla("R4 : IF (Triángulo rectángulo AND Triángulo Isósceles) THEN Triángulo Rectángulo Isósceles");

        m.AgregarRegla("R5 : IF (Triángulo AND Lados Iguales=3 (¿Cuántos lados iguales tiene la figura?)) THEN Triángulo Equilátero");

        m.AgregarRegla("R6 : IF (Orden=4 (¿Cuál es el orden?)) THEN Cuadrilátero");

        m.AgregarRegla("R7 : IF (Cuadrilátero AND Lados Paralelos=2 (¿Cuántos lados paralelos entre sí - 0, 2 o 4?)) THEN Trapecio");

        m.AgregarRegla("R8 : IF (Cuadrilátero AND Lados Paralelos=4 (¿Cuántos lados paralelos entre sí - 0, 2 o 4?)) THEN Paralelogramo");

        m.AgregarRegla("R9 : IF (Paralelogramo AND Ángulo Recto (¿La figura tiene al menos un ángulo recto?)) THEN Rectángulo");

        m.AgregarRegla("R10 : IF (Paralelogramo AND Lados Iguales=4 (¿Cuántos lados iguales tiene la figura?)) THEN Rombo");

        m.AgregarRegla("R11 : IF (Rectángulo AND Rombo THEN Cuadrado");*/

        ////

        m.AgregarRegla("R1 : IF (Orden=1 (¿Cuál es el orden?)) THEN  jugador");

        m.AgregarRegla("R2 : IF (jugador AND guantes (¿El jugador lleva guantes?)) THEN portero");

        m.AgregarRegla("R3 : IF (!guantes (¿El jugador juega en el campo?)) THEN jugadorCampo");

        m.AgregarRegla("R4 : IF (jugadorCampo AND atras (¿El jugador juega atras?)) THEN defensa");

        m.AgregarRegla("R5 : IF (defensa AND bandas (¿El jugador juega en las bandas?)) THEN lateral");

        m.AgregarRegla("R6 : IF (defensa AND !bandas THEN central");

        m.AgregarRegla("R7 : IF (jugadorCampo AND medio (¿El jugador juega en el medio?)) THEN centroCampista");

        m.AgregarRegla("R8 : IF (centroCampista AND derecha (¿El centrocampista juega en la derecha?)) THEN medioDerecha");

        m.AgregarRegla("R9 : IF (centroCampista AND izquierda (¿El centrocampista juega en la izquierda?)) THEN medioIzquierda");

        m.AgregarRegla("R10 : IF (jugadorCampo AND delante (¿El jugador juega en la posicion de delante?)) THEN delantero");

        m.AgregarRegla("R11 : IF (delantero AND centro (¿El jugador juega en el centro?)) THEN delanteroCentro");

        m.AgregarRegla("R12 : IF (delantero AND izquierda (¿El jugador juega en la izquierda?)) THEN extremoIzquiero");

        m.AgregarRegla("R11 : IF (delantero AND derecha (¿El jugador juega en la derecha?)) THEN extremoDerecho");

        m.AgregarRegla("R12 : IF (!jugadorCampo (¿El jugador esta en el banquillo?)) THEN suplente");

        m.AgregarRegla("R13 : IF (!suplente and dirige (¿El dirige al equipo?)) THEN directorTecnico");

       















        

        





        



        System.out.println("\n** Resolución **");

           // Resolución
           while(true) {

            System.out.println("\n** Resolución **");
            m.Resolver();

        }

    }



     // Pide una valor entero al usuario, sin verificaciones (0 en caso de problema)
     public int PedirValorEntero(String pregunta) {

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
     public boolean PedirValorBooleano(String pregunta) {
         
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

}
