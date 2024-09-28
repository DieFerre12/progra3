package progra3.clase5.actividad2;

public class grafoImp implements grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;
    
    @Override
    public void inicializarGrafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices]; // Inicializar la matriz de adyacencia
    }
    
    @Override
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1; // Agregar la arista
        }
    }
    
    @Override
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0; // Eliminar la arista
        }
    }
    
    @Override
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1; // Verificar si la arista existe
        }
        return false;
    }
    
    @Override
    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
    
    @Override
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
        }
        return gradoSalida;
    }
    
    @Override
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
        }
        return gradoEntrada;
    }
    
    public static void main(String[] args) {
        grafoImp grafo = new grafoImp();
        grafo.inicializarGrafo(5); 
        
        grafo.agregarArista(0, 1); // Agregar arista de 0 a 1
        grafo.agregarArista(0, 2); // Agregar arista de 0 a 2
        grafo.agregarArista(1, 2); // Agregar arista de 1 a 2
        grafo.agregarArista(3, 4); // Agregar arista de 3 a 4
        
        System.out.println("Arista entre 0 y 1: " + grafo.verificarArista(0, 1)); // true
        System.out.println("Arista entre 1 y 3: " + grafo.verificarArista(1, 3)); // false
        
        grafo.listarAdyacentes(0); // Debería listar 1 y 2
        
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0)); // 2
        System.out.println("Grado de entrada de 2: " + grafo.contarGradoEntrada(2)); // 2
        
        grafo.eliminarArista(0, 1); // Eliminar arista de 0 a 1
        
        System.out.println("Arista entre 0 y 1 después de eliminar: " + grafo.verificarArista(0, 1)); // false
    }
}
