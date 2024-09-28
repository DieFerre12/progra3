package progra3.clase6.actividad2;

 public class  MochilaKnapSack {

    // Clase que representa un objeto con peso y valor
    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los objetos (según el problema)
        Objeto[] objetos = {
            new Objeto(2, 4),  // Objeto 1
            new Objeto(5, 2),  // Objeto 2
            new Objeto(6, 1),  // Objeto 3
            new Objeto(7, 6)   // Objeto 4
        };
        
        int capacidadMochila = 10;  // Capacidad máxima de la mochila

        // Llamamos a la función que realiza la búsqueda con programación dinámica
        int valorMaximo = mochilaDinamica(objetos, capacidadMochila);

        // Mostrar el resultado
        System.out.println("Valor máximo: " + valorMaximo);
    }

    // Función para resolver el problema de la mochila con programación dinámica
    static int mochilaDinamica(Objeto[] objetos, int capacidadMochila) {
        int n = objetos.length;
        int[][] dp = new int[n + 1][capacidadMochila + 1];

        // Rellenamos la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidadMochila; w++) {
                // Si el peso del objeto actual es menor o igual que el peso disponible
                if (objetos[i - 1].peso <= w) {
                    // Elegimos el máximo entre tomar el objeto o no tomarlo
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - objetos[i - 1].peso] + objetos[i - 1].valor);
                } else {
                    // No tomamos el objeto
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El valor máximo estará en dp[n][capacidadMochila]
        return dp[n][capacidadMochila];
    }
}



