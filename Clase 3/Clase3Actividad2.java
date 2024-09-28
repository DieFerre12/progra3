public class Clase3Actividad2 {

    public static void main(String[] args) {
            // Ejemplo de array para probar la función
            int[] nums = {10, 15, 3, 8, 25, 12, 5, 7, 555};
    
            // Llamada a la función para encontrar los dos mayores
            int[] resultado = encontrarDosMayores(nums, 0, nums.length - 1);
    
            // Mostrar los resultados
            System.out.println("Los dos números mayores son: " + resultado[0] + " y " + resultado[1]);
        }
    
        public static int[] encontrarDosMayores(int[] nums, int inicio, int fin) {
            if (inicio == fin) {
                return new int[]{nums[inicio], Integer.MIN_VALUE}; // Caso base: un solo elemento
            }
    
            int medio = (inicio + fin) / 2;
    
            // Dividir la lista en dos mitades y resolverlas recursivamente
            int[] izq = encontrarDosMayores(nums, inicio, medio);
            int[] der = encontrarDosMayores(nums, medio + 1, fin);
    
            // Fusionar los resultados de manera recursiva
            int mayor1, mayor2;
    
            if (izq[0] > der[0]) {
                mayor1 = izq[0];
                mayor2 = Math.max(izq[1], der[0]);
            } else {
                mayor1 = der[0];
                mayor2 = Math.max(der[1], izq[0]);
            }
    
            return new int[]{mayor1, mayor2};
        }
    }
    
    


