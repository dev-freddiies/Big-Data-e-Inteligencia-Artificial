package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import sistemaexperto.IHM;
import sistemaexperto.IHecho;
import sistemaexperto.MotorInferencias;
import sistemaexperto.Regla;

//import sistemaexperto.*;

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

        m.agregarRegla(
                "R1 : IF (ordenador=1 (¿Que ordenador tienes? respuesta numérica - 1  gaming, 2  office, 3 home, 4 diseño)) THEN gaming");
        m.agregarRegla(
                "R2 : IF (ordenador=2 (¿Que ordenador tienes? respuesta numérica - 1  gaming, 2  office, 3 home, 4 diseño)) THEN office");
        m.agregarRegla(
                "R3 : IF (office AND oficina=1 (¿Que tipo de office? respuesta numérica - 1  clerk, 2  developer)) THEN clerk");
        m.agregarRegla(
                "R4 : IF (office AND oficina=2 (¿Que tipo de office? respuesta numérica - 1  clerk, 2  developer)) THEN developer");
        m.agregarRegla(
                "R5 : IF (ordenador=3 (¿Que ordenador tienes? respuesta numérica - 1  gaming, 2  office, 3 home, 4 diseño)) THEN home");
         m.agregarRegla(
                "R5 : IF (ordenador=4 (¿Que ordenador tienes? respuesta numérica - 1  gaming, 2  office, 3 home, 4 diseño)) THEN diseño");


        System.out.println("Resolución del problema.");
        while (true) {
            System.out.println("\n** Resolución **");
            m.resolverP();
        }

    }

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

    public boolean pedirValorBooleano(String pregunta) {
        try {
            System.out.println(pregunta + " (si,no)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String res = br.readLine();
            return (res.equals("si"));

        } catch (IOException e) {
            // TODO: handle exception
            return false;
        }
    }

    public float pedirCertidumbre() {
        try {
            System.out.println("¿Qué certidumbre tiene tu respuesta? (0 - 100)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String res = br.readLine();
            double c = Double.parseDouble(res) / 100;
            return (float) (Math.round(c * 100.0) / 100.0);
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

        for (IHecho h : hechos) {
            if (h.getNivel() != 0) {
                res += h.toString() + "\n";
            }
        }
        System.out.println(res);

        if (res.contains("developer")) {
            System.out.println("Equipo developer: RAM >=8 GB, hd_size >= 512 GB, Screen Size > 15 pulgadas, Processors allowed: i3, i5, i7 and all amd, gc_size >= 2, Os-windows");
            
        } else if (res.contains("clerk")) {
            System.out.println("Equipo clerk: RAM >=2 GB, hd_size >= 512 GB, Screen Size > 12 pulgadas, Processors brand: intel, Os-windows");

        } else if (res.contains("home")) {
            System.out.println("Equipo home: RAM >= 4 GB, hd_size >= 512 GB, Screen Size > 13 pulgadas, Os-window, mac");

        } else
            System.out.println("Equipo gaming: RAM >=8 GB, hd_size >= 512 GB, Screen Size > 15 pulgadas, Processors allowed: i3, i5, i7 and all amd, gc_size >= 2, Os-windows"); 
           
    }

    public void mostrarReglas(ArrayList<Regla> reglas) {
        String res = "";
        for (Regla r : reglas) {
            res += r.toString() + "\n";
        }
        System.out.println(res);
    }
}
