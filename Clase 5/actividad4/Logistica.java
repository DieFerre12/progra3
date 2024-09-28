package progra3.clase5.actividad4;

import java.util.List;

public interface Logistica {

    /* COSTO: O((V+E) log V ), donde V es el número de vértices y E es el número de aristas. 
    Usando una cola de prioridad basada en un heap de Fibonacci: La complejidad temporal mejora a O(E+V log V).*/ 
    
    void agregarCentro(int centro, List<Ruta> conexiones);

    void calcularTiempoMinimoEntrega(int centroPrincipal);
    
    void mostrarResultados();
}

