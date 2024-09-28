package progra3.clase6.actividad4;


import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    static class Proyecto {
        int costo;
        int beneficio;
        double relacion;

        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
            this.relacion = (double) beneficio / costo;
        }
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] beneficios = {150, 200, 100, 300};
        int presupuesto = 35;

        Proyecto[] proyectos = new Proyecto[costos.length];
        for (int i = 0; i < costos.length; i++) {
            proyectos[i] = new Proyecto(costos[i], beneficios[i]);
        }

        // Obtener el beneficio máximo usando greedy
        int maxBeneficio = seleccionGreedy(proyectos, presupuesto);
        System.out.println("Máximo beneficio con greedy: " + maxBeneficio);
    }

    // Algoritmo greedy para seleccionar los proyectos
    static int seleccionGreedy(Proyecto[] proyectos, int presupuesto) {
        // Ordenar los proyectos por la relación beneficio/costo de mayor a menor
        Arrays.sort(proyectos, Comparator.comparingDouble(p -> -p.relacion));

        int beneficioTotal = 0;
        int costoActual = 0;

        for (Proyecto proyecto : proyectos) {
            if (costoActual + proyecto.costo <= presupuesto) {
                costoActual += proyecto.costo;
                beneficioTotal += proyecto.beneficio;
            }
        }
        return beneficioTotal;
    }
}

/* Complejidad de Greedy:
   Tiempo: O(n log n), ya que es necesario ordenar los proyectos según su relación beneficio/costo.
   Espacio: O(n), para almacenar la lista de proyectos. */
