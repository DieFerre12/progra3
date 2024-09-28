package progra3.clase5.actividad3;

import java.util.List;

public interface RedElectronica {
    // Agregar una estación eléctrica (vértice) con su costo de conexión a otra estación
    void agregarEstacion(int estacion, List<Edge> conexiones);
    
    // Calcular el Árbol de Recubrimiento Mínimo utilizando el algoritmo de Prim
    void calcularArbolRecubrimientoMinimo();
    
    // Mostrar el conjunto de conexiones resultante y el costo total
    void mostrarResultado();
}
