package progra3.clase1;

public class actividad1 {
   
        // Método para encontrar el valor máximo en un array
        public static int encontrarMaximo(int[] array) {
            // Inicializar max con el primer elemento del array
            int max = array[0];
            
            // Recorrer el array
            for (int i = 1; i < array.length; i++) {
                // Si encontramos un valor mayor que max, lo actualizamos
                if (array[i] > max) {
                    max = array[i];
                }
            }
            
            return max;
        }
    
        public static void main(String[] args) {
            // Ejemplo de uso
            int[] array = {3, 5, 7, 2, 8, 10, 4};
            
            // Calcular el máximo
            int maximo = encontrarMaximo(array);
            
            // Imprimir el valor máximo
            System.out.println("El valor máximo del array es: " + maximo);
        }
    }
    

