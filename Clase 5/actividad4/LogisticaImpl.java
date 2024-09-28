package progra3.clase5.actividad4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LogisticaImpl implements Logistica {
    private List<List<Ruta>> grafo; // Lista de adyacencia
    private int[] tiemposMinimos; // Almacena los tiempos mínimos de entrega
    private boolean[] visitado; // Para verificar si un centro ha sido visitado

    public LogisticaImpl() {
        grafo = new ArrayList<>();
    }

    @Override
    public void agregarCentro(int centro, List<Ruta> conexiones) {
        while (grafo.size() <= centro) {
            grafo.add(new ArrayList<>()); // Asegurar que la lista tenga suficiente espacio
        }
        grafo.get(centro).addAll(conexiones); // Agregar conexiones para el centro
    }

    @Override
    public void calcularTiempoMinimoEntrega(int centroPrincipal) {
        int numCentros = grafo.size();
        tiemposMinimos = new int[numCentros];
        visitado = new boolean[numCentros];
        
        // Inicializar tiempos mínimos
        for (int i = 0; i < numCentros; i++) {
            tiemposMinimos[i] = Integer.MAX_VALUE; // Tiempo inicial es infinito
        }
        tiemposMinimos[centroPrincipal] = 0; // El tiempo al centro principal es 0

        PriorityQueue<Ruta> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.tiempo, b.tiempo));
        pq.offer(new Ruta(centroPrincipal, 0)); // Agregar el centro principal a la cola

        while (!pq.isEmpty()) {
            Ruta rutaActual = pq.poll();
            int centroActual = rutaActual.destino;

            if (visitado[centroActual]) continue; // Si ya se visitó, continuar
            visitado[centroActual] = true; // Marcar como visitado

            // Explorar las conexiones
            for (Ruta ruta : grafo.get(centroActual)) {
                int nuevoTiempo = tiemposMinimos[centroActual] + ruta.tiempo;
                if (nuevoTiempo < tiemposMinimos[ruta.destino]) {
                    tiemposMinimos[ruta.destino] = nuevoTiempo;
                    pq.offer(new Ruta(ruta.destino, nuevoTiempo)); // Agregar la nueva ruta a la cola
                }
            }
        }
    }

    @Override
    public void mostrarResultados() {
        System.out.println("Tiempos mínimos de entrega desde el centro principal:");
        for (int i = 0; i < tiemposMinimos.length; i++) {
            System.out.println("Centro " + i + ": " + tiemposMinimos[i] + " minutos");
        }
    }

    public static void main(String[] args) {
        LogisticaImpl logistica = new LogisticaImpl();

        // Agregar centros y sus conexiones (destino, tiempo)
        List<Ruta> conexionesCentro0 = List.of(new Ruta(1, 10), new Ruta(2, 15));
        logistica.agregarCentro(0, conexionesCentro0);
        
        List<Ruta> conexionesCentro1 = List.of(new Ruta(0, 10), new Ruta(2, 5), new Ruta(3, 20));
        logistica.agregarCentro(1, conexionesCentro1);
        
        List<Ruta> conexionesCentro2 = List.of(new Ruta(0, 15), new Ruta(1, 5), new Ruta(3, 10));
        logistica.agregarCentro(2, conexionesCentro2);
        
        List<Ruta> conexionesCentro3 = List.of(new Ruta(1, 20), new Ruta(2, 10));
        logistica.agregarCentro(3, conexionesCentro3);

        // Calcular el tiempo mínimo de entrega desde el centro principal
        logistica.calcularTiempoMinimoEntrega(0);
        
        // Mostrar los resultados
        logistica.mostrarResultados();
    }
}

