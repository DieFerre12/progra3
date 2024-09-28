package progra3.clase6.actividad3;

public class SeleccionProyectosDinamico {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int maxBeneficio = seleccionProyectosDinamico(costos, beneficios, presupuesto);
        System.out.println("Máximo beneficio con programación dinámica: " + maxBeneficio);
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
}
/*Complejidad de Programación Dinámica:
Tiempo: O(n * W), donde n es el número de proyectos y W es el presupuesto.
Espacio: O(n * W), para almacenar la tabla dp de soluciones intermedias. */