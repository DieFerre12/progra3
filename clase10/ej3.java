package clase10;

public class ej3 {

    static int N = 4; // Tamaño del tablero 4x4
    static int totalSoluciones = 0; // Contador de soluciones

    // Función para verificar si la colocación de una computadora es válida
    public static boolean esSeguroComputadora(int[][] tablero, int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) {
                return false; // Ya hay una computadora en la fila o columna
            }
        }
        return true;
    }

    // Función para verificar si la colocación de una impresora es válida
    public static boolean esSeguroImpresora(int[][] tablero, int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2 || tablero[i][col] == 2) {
                return false; // Ya hay una impresora en la fila o columna
            }
        }
        return true;
    }

    // Función principal para resolver el problema
    public static void resolverDistribucion() {
        int[][] tablero = new int[N][N]; // Crear un tablero vacío
        colocarComputadoras(tablero, 0, 0); // Iniciar colocando las computadoras
        System.out.println("Total de soluciones: " + totalSoluciones);
    }

    // Función recursiva para colocar las 4 computadoras
    public static void colocarComputadoras(int[][] tablero, int fila, int colocadas) {
        if (colocadas == 4) { // Si se colocaron 4 computadoras, intentar colocar impresoras
            colocarImpresoras(tablero, 0, 0, 0);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroComputadora(tablero, i, j)) {
                    tablero[i][j] = 1; // Colocar computadora
                    colocarComputadoras(tablero, i + 1, colocadas + 1); // Recursión
                    tablero[i][j] = 0; // Backtrack: quitar computadora
                }
            }
        }
    }

    // Función recursiva para colocar las 4 impresoras
    public static void colocarImpresoras(int[][] tablero, int fila, int col, int colocadas) {
        if (colocadas == 4) { // Si se colocaron 4 impresoras, imprimir la solución
            imprimirTablero(tablero);
            totalSoluciones++; // Incrementar el contador de soluciones
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (esSeguroImpresora(tablero, i, j) && tablero[i][j] == 0) {
                    tablero[i][j] = 2; // Colocar impresora
                    colocarImpresoras(tablero, i, j + 1, colocadas + 1); // Recursión
                    tablero[i][j] = 0; // Backtrack: quitar impresora
                }
            }
        }
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("C "); // Computadora
                } else if (tablero[i][j] == 2) {
                    System.out.print("I "); // Impresora
                } else {
                    System.out.print(". "); // Celda vacía
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDistribucion();
    }
}
