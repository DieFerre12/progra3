package progra3.clase6.actividad4;

import java.util.ArrayList;
import java.util.List;

public class SeleccionProyectosDinamico {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int maxBeneficio = seleccionProyectosDinamico(costos, beneficios, presupuesto);
        System.out.println("Máximo beneficio con programación dinámica: " + maxBeneficio);

        List<Integer> paquetesSeleccionados = obtenerPaquetesSeleccionados(costos, beneficios, presupuesto);
        System.out.println("Paquetes seleccionados: " + paquetesSeleccionados);
    }

    // Algoritmo de programación dinámica para seleccionar proyectos
    static int seleccionProyectosDinamico(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][presupuesto];
    }

    // Método para obtener los paquetes seleccionados
    static List<Integer> obtenerPaquetesSeleccionados(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Recuperar los paquetes seleccionados
        List<Integer> seleccionados = new ArrayList<>();
        int w = presupuesto;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                seleccionados.add(i - 1); // Agregar el índice del paquete seleccionado
                w -= costos[i - 1]; // Restar el costo del paquete seleccionado
            }
        }

        return seleccionados;
    }
}
/*Complejidad de Programación Dinámica:
Tiempo: O(n * W), donde n es el número de proyectos y W es el presupuesto.
Espacio: O(n * W), para almacenar la tabla dp de soluciones intermedias. */