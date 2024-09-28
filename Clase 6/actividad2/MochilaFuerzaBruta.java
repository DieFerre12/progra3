package progra3.clase6.actividad2;

public class MochilaFuerzaBruta {

    // Clase que representa un objeto con peso y valor
    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los objetos (según el problema)
        Objeto[] objetos = {
            new Objeto(2, 4),  // Objeto 1
            new Objeto(5, 2),  // Objeto 2
            new Objeto(6, 1),  // Objeto 3
            new Objeto(7, 6)   // Objeto 4
        };
        
        int capacidadMochila = 10;  // Capacidad máxima de la mochila

        // Llamamos a la función que realiza la búsqueda de la mejor combinación
        Resultado mejorResultado = mejorCombinacion(objetos, capacidadMochila);

        // Mostrar el resultado
        System.out.println("Valor máximo: " + mejorResultado.valorMaximo);
        System.out.println("Peso total: " + mejorResultado.pesoTotal);
    }

    // Clase para almacenar el resultado de la mejor combinación
    static class Resultado {
        int valorMaximo;
        int pesoTotal;

        public Resultado(int valorMaximo, int pesoTotal) {
            this.valorMaximo = valorMaximo;
            this.pesoTotal = pesoTotal;
        }
    }

    // Función para encontrar la mejor combinación
    static Resultado mejorCombinacion(Objeto[] objetos, int capacidadMochila) {
        int n = objetos.length;
        int mejorValor = 0;
        int mejorPeso = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int pesoTotal = 0;
            int valorTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    pesoTotal += objetos[j].peso;
                    valorTotal += objetos[j].valor;
                }
            }

            // Verificar si el peso total no excede la capacidad de la mochila
            if (pesoTotal <= capacidadMochila && valorTotal > mejorValor) {
                mejorValor = valorTotal;
                mejorPeso = pesoTotal;
            }
        }

        // Retornar el mejor resultado
        return new Resultado(mejorValor, mejorPeso);
    }
}
