package progra3.clase6.actividad3;

public class SeleccionProyectos {

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        // Ejemplo de entrada
        int[] costos = {2, 3, 4, 5};      // Costos de los proyectos
        int[] beneficios = {3, 4, 5, 6};  // Beneficios esperados de los proyectos
        int presupuesto = 5;              // Presupuesto máximo

        // Llamamos a la función para seleccionar los proyectos óptimos
        int maxBeneficio = seleccionarProyectos(costos, beneficios, presupuesto);

        // Mostrar el resultado
        System.out.println("Beneficio máximo que se puede obtener: " + maxBeneficio);
    }

    // Función para seleccionar proyectos usando programación dinámica
    static int seleccionarProyectos(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;  // Número de proyectos
        int[][] dp = new int[n + 1][presupuesto + 1];  // Tabla de DP para almacenar los resultados intermedios

        // Llenamos la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                // Si el costo del proyecto actual es menor o igual al presupuesto disponible
                if (costos[i - 1] <= w) {
                    // Tomamos el máximo entre no seleccionar el proyecto o seleccionarlo
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    // Si no podemos incluir el proyecto, mantenemos el beneficio sin incluirlo
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El beneficio máximo estará en dp[n][presupuesto]
        return dp[n][presupuesto];
    }
}
