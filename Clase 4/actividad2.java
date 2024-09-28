package progra3.clase4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class actividad2 {

    // Método para encontrar el mínimo número de comprobantes para alcanzar el monto
    public static List<String> encontrarMinimoComprobantes(Comprobante[] comprobantes, int monto) {
        // Ordenar los comprobantes por valor en orden descendente
        Arrays.sort(comprobantes, (a, b) -> Integer.compare(b.valor, a.valor));
        List<String> resultado = new ArrayList<>();
        
        // Recorrer los comprobantes
        for (Comprobante comprobante : comprobantes) {
            // Mientras el valor del comprobante sea menor o igual al monto restante
            while (monto >= comprobante.valor) {
                monto -= comprobante.valor;
                resultado.add(comprobante.tipo + " de " + comprobante.valor);
            }
        }
        
        // Si no se puede cubrir el monto exacto
        if (monto != 0) {
            System.out.println("No es posible alcanzar el monto exacto.");
            return new ArrayList<>();
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        // Crear una lista de comprobantes disponibles (monedas, cheques, bonos, etc.)
        Comprobante[] comprobantes = {
            new Comprobante("Moneda", 1),
            new Comprobante("Cheque", 5),
            new Comprobante("Bono", 100),
            new Comprobante("Moneda", 10),
            new Comprobante("Moneda", 20)
        };
        
        // Monto a cubrir
        int monto = 136;
        
        // Encontrar los comprobantes necesarios
        List<String> resultado = encontrarMinimoComprobantes(comprobantes, monto);
        
        if (!resultado.isEmpty()) {
            System.out.println("Comprobantes usados para hacer " + monto + ": " + resultado);
        }
    }
}

// Clase para representar los comprobantes
class Comprobante {
    String tipo;
    int valor;
    
    public Comprobante(String tipo, int valor) {
        this.tipo = tipo;
        this.valor = valor;
    }



    /*Ordenar los comprobantes tiene una complejidad de O(n log n) y seleccionar los comprobantes tiene una complejidad de
     * O(n) por lo que la complejidad total del algoritmo es O(n log n) + O(n) = O(n log n)
    */

}
