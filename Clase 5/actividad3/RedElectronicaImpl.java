package progra3.clase5.actividad3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RedElectronicaImpl implements RedElectronica {
    private List<List<Edge>> grafo; // Lista de adyacencia
    private boolean[] enMST; // Para verificar si un vértice está en el MST
    private int costoTotal; // Costo total del MST
    private List<Edge> resultado; // Conexiones resultantes

    // Constructor de la clase
    public RedElectronicaImpl() {
        grafo = new ArrayList<>(); // Inicializa la lista de adyacencia
        costoTotal = 0; // Inicializa el costo total
        resultado = new ArrayList<>(); // Inicializa la lista de resultados
    }

    @Override
    public void agregarEstacion(int estacion, List<Edge> conexiones) {
        while (grafo.size() <= estacion) {
            grafo.add(new ArrayList<>()); // Asegurar que la lista tenga suficiente espacio
        }
        grafo.get(estacion).addAll(conexiones); // Agregar conexiones para la estación
    }

    @Override
    public void calcularArbolRecubrimientoMinimo() {
        int numEstaciones = grafo.size();
        enMST = new boolean[numEstaciones];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.costo, b.costo));
        
        // Comenzar desde la estación 0
        enMST[0] = true;
        for (Edge edge : grafo.get(0)) {
            pq.offer(edge);
        }
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (!enMST[edge.destino]) {
                enMST[edge.destino] = true;
                resultado.add(edge);
                costoTotal += edge.costo;

                for (Edge nextEdge : grafo.get(edge.destino)) {
                    if (!enMST[nextEdge.destino]) {
                        pq.offer(nextEdge);
                    }
                }
            }
        }
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Conexiones en el Árbol de Recubrimiento Mínimo:");
        for (Edge edge : resultado) {
            System.out.println("Estación -> " + edge.destino + " (Costo: " + edge.costo + ")");
        }
        System.out.println("Costo total del MST: " + costoTotal);
    }

    public static void main(String[] args) {
        RedElectronicaImpl redElectrica = new RedElectronicaImpl();

        // Agregar estaciones y sus conexiones (destino, costo)
        List<Edge> conexionesEstacion0 = List.of(new Edge(1, 10), new Edge(2, 6), new Edge(3, 5));
        redElectrica.agregarEstacion(0, conexionesEstacion0);
        
        List<Edge> conexionesEstacion1 = List.of(new Edge(0, 10), new Edge(3, 15));
        redElectrica.agregarEstacion(1, conexionesEstacion1);
        
        List<Edge> conexionesEstacion2 = List.of(new Edge(0, 6), new Edge(3, 4));
        redElectrica.agregarEstacion(2, conexionesEstacion2);
        
        List<Edge> conexionesEstacion3 = List.of(new Edge(0, 5), new Edge(1, 15), new Edge(2, 4));
        redElectrica.agregarEstacion(3, conexionesEstacion3);

        // Calcular el Árbol de Recubrimiento Mínimo
        redElectrica.calcularArbolRecubrimientoMinimo();
        
        // Mostrar el resultado
        redElectrica.mostrarResultado();
    }
}
