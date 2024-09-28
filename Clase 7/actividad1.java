package progra3.clase7;

public class actividad1 extends FloydWarshall {
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        
        // Inicialización del grafo con pesos
        int graph[][] = { 
            {0, 2, INF, 5},   // Desde el nodo 1
            {INF, 0, INF, 4}, // Desde el nodo 2
            {INF, INF, 0, INF}, // Desde el nodo 3
            {INF, INF, 2, 0}   // Desde el nodo 4
        };
        
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }
}
