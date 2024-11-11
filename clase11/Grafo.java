package clase11;

import java.util.*;

public class Grafo {
    private Map<Integer, Almacen> almacenes; // Mapa de ID a Almacen
    private Map<Integer, List<Integer>> adyacencia; // Lista de adyacencia

    public Grafo() {
        almacenes = new HashMap<>();
        adyacencia = new HashMap<>();
    }

    // Método para agregar un nuevo almacén
    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adyacencia.put(almacen.getId(), new ArrayList<>()); // Inicializar la lista de adyacencia
    }

    // Método para conectar dos almacenes (agregar ruta directa)
    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencia.get(id1).add(id2); // Conectar id1 -> id2
            adyacencia.get(id2).add(id1); // Conectar id2 -> id1 (grafo no dirigido)
        } else {
            System.out.println("Almacén no encontrado.");
        }
    }

    // Implementación de BFS
    public void BFS(int inicio) {
        if (!almacenes.containsKey(inicio)) {
            System.out.println("Almacén de inicio no encontrado.");
            return;
        }

        boolean[] visitado = new boolean[almacenes.size()];
        Queue<Integer> cola = new LinkedList<>();
        
        visitado[inicio] = true;
        cola.add(inicio);

        System.out.println("Recorrido BFS desde " + almacenes.get(inicio).getNombre() + ":");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(almacenes.get(actual) + " -> ");

            for (int vecino : adyacencia.get(actual)) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    cola.add(vecino);
                }
            }
        }
        System.out.println("Fin");
    }

    // Implementación de DFS
    public void DFS(int inicio) {
        if (!almacenes.containsKey(inicio)) {
            System.out.println("Almacén de inicio no encontrado.");
            return;
        }

        boolean[] visitado = new boolean[almacenes.size()];
        System.out.println("Recorrido DFS desde " + almacenes.get(inicio).getNombre() + ":");
        DFSUtil(inicio, visitado);
        System.out.println("Fin");
    }

    // Método auxiliar para DFS (recursivo)
    private void DFSUtil(int actual, boolean[] visitado) {
        visitado[actual] = true;
        System.out.print(almacenes.get(actual) + " -> ");

        for (int vecino : adyacencia.get(actual)) {
            if (!visitado[vecino]) {
                DFSUtil(vecino, visitado);
            }
        }
    }

    // Método main para probar el sistema
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        // Crear almacenes
        Almacen a1 = new Almacen(0, "Almacen Central");
        Almacen a2 = new Almacen(1, "Almacen Norte");
        Almacen a3 = new Almacen(2, "Almacen Sur");
        Almacen a4 = new Almacen(3, "Almacen Este");
        Almacen a5 = new Almacen(4, "Almacen Oeste");

        // Agregar almacenes a la red
        redAlmacenes.agregarAlmacen(a1);
        redAlmacenes.agregarAlmacen(a2);
        redAlmacenes.agregarAlmacen(a3);
        redAlmacenes.agregarAlmacen(a4);
        redAlmacenes.agregarAlmacen(a5);

        // Conectar almacenes entre sí
        redAlmacenes.conectarAlmacenes(0, 1);
        redAlmacenes.conectarAlmacenes(0, 2);
        redAlmacenes.conectarAlmacenes(1, 3);
        redAlmacenes.conectarAlmacenes(2, 4);

        // Realizar recorridos BFS y DFS
        redAlmacenes.BFS(0);
        System.out.println();
        redAlmacenes.DFS(0);
    }
}
