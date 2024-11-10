package clase12;

import java.util.*;

class Node {
    String name;
    int cost;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class ej2 {
    private final Map<String, List<Node>> graph = new HashMap<>();

    // Agregar conexiones al grafo
    public void addEdge(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost));
    }

    // Método para realizar la búsqueda UCS
    public List<String> uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(start, 0));
        
        Map<String, Integer> costMap = new HashMap<>(); // Para registrar los costos mínimos
        Map<String, String> parentMap = new HashMap<>(); // Para reconstruir la ruta
        Set<String> visited = new HashSet<>();
        costMap.put(start, 0); // El costo inicial es 0

        System.out.println("Iniciando búsqueda desde " + start + " hasta " + goal);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            System.out.println("Explorando nodo: " + current.name + " con costo acumulado: " + current.cost);

            // Si alcanzamos el nodo objetivo, reconstruimos la ruta
            if (current.name.equals(goal)) {
                System.out.println("¡Destino alcanzado! Nodo objetivo: " + goal);
                return reconstruirRuta(parentMap, start, goal);
            }

            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            // Explorar vecinos
            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                int newCost = current.cost + neighbor.cost;
                if (!visited.contains(neighbor.name) && 
                    (!costMap.containsKey(neighbor.name) || newCost < costMap.get(neighbor.name))) {
                    
                    costMap.put(neighbor.name, newCost);
                    parentMap.put(neighbor.name, current.name);
                    priorityQueue.add(new Node(neighbor.name, newCost));

                    System.out.println("  Visitando vecino: " + neighbor.name + 
                        " | Costo hasta aquí: " + newCost);
                }
            }
        }

        System.out.println("No se encontró un camino desde " + start + " hasta " + goal);
        return Collections.emptyList(); // No se encontró ruta
    }

    // Método para reconstruir la ruta desde el nodo final al inicio
    private List<String> reconstruirRuta(Map<String, String> parentMap, String start, String goal) {
        List<String> ruta = new ArrayList<>();
        String current = goal;
        while (current != null) {
            ruta.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(ruta); // Invertir la ruta para mostrarla desde el inicio
        return ruta;
    }

    public static void main(String[] args) {
        ej2 ucs = new ej2();

        // Agregar conexiones
        ucs.addEdge("A", "B", 2);
        ucs.addEdge("A", "C", 4);
        ucs.addEdge("B", "C", 1);
        ucs.addEdge("B", "D", 7);
        ucs.addEdge("C", "E", 3);
        ucs.addEdge("D", "E", 1);

        // Ejecutar UCS
        String startRoom = "A";
        String goalRoom = "E";
        List<String> ruta = ucs.uniformCostSearch(startRoom, goalRoom);
        
        if (!ruta.isEmpty()) {
            System.out.println("\nRuta más barata encontrada: " + String.join(" -> ", ruta));
            System.out.println("Costo total: " + ruta.size());
        } else {
            System.out.println("No se encontró una ruta válida desde " + startRoom + " hasta " + goalRoom);
        }
    }
}
