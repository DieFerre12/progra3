package clase13;

import java.util.Random;

public class Sudoku6x6 {
    private static final int SIZE = 6; // Tamaño del tablero 6x6
    private static final int SUBGRID_ROWS = 2; // Filas del subcuadrante 2x3
    private static final int SUBGRID_COLS = 3; // Columnas del subcuadrante 2x3
    private static final int EMPTY = 0; // Valor para las celdas vacías
    private int[][] board;

    public Sudoku6x6() {
        board = new int[SIZE][SIZE];
    }

    // Método principal para generar un tablero de Sudoku
    public void generateSudoku() {
        fillBoard(); // Llena el tablero con una solución completa
        removeNumbers(); // Elimina algunos números para crear el desafío
    }

    // Llena el tablero utilizando backtracking
    private boolean fillBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard()) {
                                return true;
                            }
                            board[row][col] = EMPTY; // Retrocede si no es solución
                        }
                    }
                    return false; // Si no se puede colocar ningún número válido
                }
            }
        }
        return true; // Si llena todas las celdas, devuelve verdadero
    }

    // Verifica si un número es válido en una posición dada
    private boolean isValid(int row, int col, int num) {
        // Verifica la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verifica la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verifica el subcuadrante 2x3
        int subGridRowStart = (row / SUBGRID_ROWS) * SUBGRID_ROWS;
        int subGridColStart = (col / SUBGRID_COLS) * SUBGRID_COLS;

        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[subGridRowStart + i][subGridColStart + j] == num) {
                    return false;
                }
            }
        }

        return true; // El número es válido en la posición dada
    }

    // Elimina algunos números para crear el rompecabezas
    private void removeNumbers() {
        Random rand = new Random();
        int cellsToRemove = 12 + rand.nextInt(6); // Elimina entre 12 y 18 celdas

        while (cellsToRemove > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);

            if (board[row][col] != EMPTY) {
                board[row][col] = EMPTY;
                cellsToRemove--;
            }
        }
    }

    // Imprime el tablero en la consola de manera más visual
    public void printBoard() {
        System.out.println("┌───┬───┬───┐");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("│ ");
                if (board[i][j] == EMPTY) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println("│");

            // Imprimir líneas divisorias entre filas
            if ((i + 1) % SUBGRID_ROWS == 0 && i < SIZE - 1) {
                System.out.println("├───┼───┼───┤");
            }
        }
        System.out.println("└───┴───┴───┘");
    }

    public static void main(String[] args) {
        Sudoku6x6 sudoku = new Sudoku6x6();
        sudoku.generateSudoku();
        sudoku.printBoard(); // Muestra el tablero generado
    }
}
