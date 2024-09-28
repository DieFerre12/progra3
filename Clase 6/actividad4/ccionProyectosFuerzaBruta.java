package progra3.clase6.actividad4;

public class ccionProyectosFuerzaBruta {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] beneficios = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxBeneficio = fuerzaBruta(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo (fuerza bruta): " + maxBeneficio);
    }

    static int fuerzaBruta(int[] costos, int[] beneficios, int presupuesto) {
        return fuerzaBrutaAux(costos, beneficios, presupuesto, 0);
    }

    // Función auxiliar que explora todas las combinaciones posibles
    static int fuerzaBrutaAux(int[] costos, int[] beneficios, int presupuesto, int i) {
        if (i == costos.length) {
            return 0;
        }
        // Opción 1: No incluir el proyecto i
        int noIncluir = fuerzaBrutaAux(costos, beneficios, presupuesto, i + 1);

        // Opción 2: Incluir el proyecto i (si el presupuesto lo permite)
        int incluir = 0;
        if (costos[i] <= presupuesto) {
            incluir = beneficios[i] + fuerzaBrutaAux(costos, beneficios, presupuesto - costos[i], i + 1);
        }

        // Tomar la opción que da el máximo beneficio
        return Math.max(noIncluir, incluir);
    }
}

/* Complejidad de Fuerza Bruta:
   Tiempo: O(2^n), ya que cada proyecto tiene dos opciones (incluirlo o no), generando 2^n combinaciones posibles.
   Espacio: O(n), por la profundidad máxima de la pila de recursión. */
