public class Clase3Actividad3 {

    // Clase interna Cliente
    static public class Cliente {
        int id;
        String nombre;
        int scoring;

        Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }
    }

    // Clase interna MaximosScoringClientes
    public static class MaximosScoringClientes {

        public Cliente[] encontrarDosMaximosScoring(Cliente[] listaClientes) {
            return encontrarDosMaximosScoring(listaClientes, 0, listaClientes.length - 1);
        }

        private Cliente[] encontrarDosMaximosScoring(Cliente[] listaClientes, int inicio, int fin) {
            if (inicio == fin) {
                // Caso base: un solo cliente, devolvemos un arreglo con él dos veces
                return new Cliente[]{listaClientes[inicio], listaClientes[inicio]};
            }

            if (fin - inicio == 1) {
                // Caso base: dos clientes, devolvemos el par ordenado por scoring
                if (listaClientes[inicio].scoring >= listaClientes[fin].scoring) {
                    return new Cliente[]{listaClientes[inicio], listaClientes[fin]};
                } else {
                    return new Cliente[]{listaClientes[fin], listaClientes[inicio]};
                }
            }

            int mitad = (inicio + fin) / 2;

            // Divide
            Cliente[] maxIzquierda = encontrarDosMaximosScoring(listaClientes, inicio, mitad);
            Cliente[] maxDerecha = encontrarDosMaximosScoring(listaClientes, mitad + 1, fin);

            // Conquista
            Cliente max1, max2;

            if (maxIzquierda[0].scoring >= maxDerecha[0].scoring) {
                max1 = maxIzquierda[0];
                max2 = (maxIzquierda[1].scoring >= maxDerecha[0].scoring) ? maxIzquierda[1] : maxDerecha[0];
            } else {
                max1 = maxDerecha[0];
                max2 = (maxDerecha[1].scoring >= maxIzquierda[0].scoring) ? maxDerecha[1] : maxIzquierda[0];
            }

            return new Cliente[]{max1, max2};
        }
    }

    // Método main
    public static void main(String[] args) {
        // Crear una instancia de MaximosScoringClientes
        MaximosScoringClientes maximos = new MaximosScoringClientes();

        // Crear un array de clientes
        Cliente[] clientes = {
            new Cliente(1, "Juan", 75),
            new Cliente(2, "Ana", 92),
            new Cliente(3, "Luis", 83),
            new Cliente(4, "Marta", 95),
            new Cliente(5, "Pedro", 88)
        };

        // Encontrar los dos clientes con mayor scoring
        Cliente[] maxClientes = maximos.encontrarDosMaximosScoring(clientes);

        // Mostrar los resultados
        System.out.println("Cliente con máximo scoring: " + maxClientes[0].nombre + " con scoring de " + maxClientes[0].scoring);
        System.out.println("Segundo cliente con máximo scoring: " + maxClientes[1].nombre + " con scoring de " + maxClientes[1].scoring);
    }
}
