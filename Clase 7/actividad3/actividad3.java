package progra3.clase7.actividad3;

import java.util.Scanner;

public class actividad3 {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        actividad3 fw = new actividad3();

        // Inicialización del grafo (matriz de adyacencia)
        int graph[][] = { 
            {0, 8, 5, INF},   // Nodo 0
            {3, 0, INF, 4},   // Nodo 1
            {INF, 2, 0, INF},  // Nodo 2
            {INF, INF, -2, 0}  // Nodo 3
        };
        
        Scanner scanner = new Scanner(System.in);
        int V = graph.length;

        int origen = -1;
        int destino = -1;

        // Pedir al usuario el nodo de origen y destino con validación
        while (origen < 0 || origen >= V) {
            System.out.print("Ingrese el nodo de origen (0 a " + (V - 1) + "): ");
            origen = scanner.nextInt();
            if (origen < 0 || origen >= V) {
                System.out.println("Por favor, ingrese un valor válido entre 0 y " + (V - 1));
            }
        }

        while (destino < 0 || destino >= V) {
            System.out.print("Ingrese el nodo de destino (0 a " + (V - 1) + "): ");
            destino = scanner.nextInt();
            if (destino < 0 || destino >= V) {
                System.out.println("Por favor, ingrese un valor válido entre 0 y " + (V - 1));
            }
        }

        // Llamar al método que realiza el algoritmo de Floyd-Warshall
        fw.floydWarshall(graph, V, origen, destino);
        
        scanner.close();
    }

    void floydWarshall(int graph[][], int V, int origen, int destino) {
        int dist[][] = new int[V][V];
        int next[][] = new int[V][V];

        // Inicializar la matriz de distancias y la matriz de predecesores
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;  // Si hay una arista, el siguiente nodo es el nodo de destino
                } else {
                    next[i][j] = -1; // No hay conexión
                }
            }
        }
        
        // Actualizar la matriz de distancias y predecesores
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // Actualizar el predecesor
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);

        // Imprimir el camino más corto entre origen y destino
        printPath(next, origen, destino);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
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

    void printPath(int next[][], int origen, int destino) {
        if (next[origen][destino] == -1) {
            System.out.println("No hay camino desde " + origen + " a " + destino);
            return;
        }
        
        System.out.print("El camino más corto de " + origen + " a " + destino + " es: " + origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
    }
}
