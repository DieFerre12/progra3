package progra3.clase7;

public class actividad2 {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        
        // Inicialización del grafo con tiempos de entrega (en minutos)
        int graph[][] = { 
            {0, 2, INF, 5},    // Centro de distribución 1
            {INF, 0, 3, 4},    // Centro de distribución 2
            {2, INF, 0, INF},   // Centro de distribución 3
            {INF, INF, -2, 0}   // Centro de distribución 4 (costo negativo)
        };
        
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    public void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        
        // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Verificar ciclos negativos
        boolean hasNegativeCycle = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                hasNegativeCycle = true;
                break;
            }
        }

        // Imprimir la matriz de distancias y verificar ciclos negativos
        printSolution(dist, V);
        if (hasNegativeCycle) {
            System.out.println("Se han encontrado ciclos negativos en el grafo.");
        } else {
            System.out.println("No se han encontrado ciclos negativos en el grafo.");
        }
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de tiempos mínimos de entrega entre cada par de centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
