package progra3.clase5.actividad2;

public interface grafo {
     // Inicialización del grafo con un número fijo de vértices
    // Complejidad: O(V^2), donde V es el número de vértices (se crea una matriz de VxV).
    void inicializarGrafo(int numVertices);
    
    // Agregar una arista desde el vértice de origen al vértice de destino
    // Complejidad: O(1), acceso directo en la matriz.
    void agregarArista(int origen, int destino);
    
    // Eliminar una arista desde el vértice de origen al vértice de destino
    // Complejidad: O(1), acceso directo en la matriz.
    void eliminarArista(int origen, int destino);
    
    // Verificar si existe una arista desde el vértice de origen al vértice de destino
    // Complejidad: O(1), acceso directo en la matriz.
    boolean verificarArista(int origen, int destino);
    
    // Listar los vértices adyacentes a un vértice dado
    // Complejidad: O(V), donde V es el número de vértices (se recorre una fila de la matriz).
    void listarAdyacentes(int vertice);
    
    // Contar el grado de salida de un vértice dado (número de aristas que salen del vértice)
    // Complejidad: O(V), donde V es el número de vértices (se recorre una fila de la matriz).
    int contarGradoSalida(int vertice);
    
    // Contar el grado de entrada de un vértice dado (número de aristas que entran al vértice)
    // Complejidad: O(V), donde V es el número de vértices (se recorre una columna de la matriz).
    int contarGradoEntrada(int vertice);
    
}
