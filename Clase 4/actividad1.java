package progra3.clase4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class actividad1 {
    public static List<Integer> encontrarMinimoMonedas(int[] monedas, int monto) {
        Arrays.sort(monedas);
        List<Integer> resultado = new ArrayList<>();
        
        for (int i = monedas.length - 1; i >= 0; i--) {

            while (monto >= monedas[i]) {
                monto -= monedas[i];
                resultado.add(monedas[i]);
            }
        }
        
        // Si no se pudo entregar el cambio exacto, el monto no debería ser mayor a 0
        if (monto != 0) {
            System.out.println("No es posible entregar cambio exacto.");
            return new ArrayList<>();
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25};
        int monto = 36;
        
        List<Integer> resultado = encontrarMinimoMonedas(monedas, monto);
        
        if (!resultado.isEmpty()) {
            System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
        }
    }

    //complejidad O(nlogn)
}
