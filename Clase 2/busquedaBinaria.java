public class busquedaBinaria {
    public static int busquedaBin (int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } 
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }
    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int objetivo = 15;

        int resultado = busquedaBin(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("El objetivo no se encuentra en el arreglo");
        } else {
            System.out.println("El objetivo se encuentra en el índice " + resultado);
        }
    }
}
