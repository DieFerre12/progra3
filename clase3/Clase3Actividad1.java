public class Clase3Actividad1 {
    static class Cliente {
        int id;
        String nombre;
        int scoring;
    
        Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }
    }

    public static class MaxScoringCliente {

        public Cliente encontrarMaximoScoring(Cliente[] listaClientes) {
            return encontrarMaximoScoring(listaClientes, 0, listaClientes.length - 1);
        }

        private Cliente encontrarMaximoScoring(Cliente[] listaClientes, int inicio, int fin) {
            if (inicio == fin) {
                return listaClientes[inicio];  // Caso base: un solo cliente
            }

            int mitad = (inicio + fin) / 2;

            // Divide
            Cliente maxIzquierda = encontrarMaximoScoring(listaClientes, inicio, mitad);
            Cliente maxDerecha = encontrarMaximoScoring(listaClientes, mitad + 1, fin);

            // Conquista
            if (maxIzquierda.scoring >= maxDerecha.scoring) {
                return maxIzquierda;
            } else {
                return maxDerecha;
            }
        }

        public static void main(String[] args) {
            Cliente[] clientes = {
                new Cliente(1, "Juan", 75),
                new Cliente(2, "Ana", 92),
                new Cliente(3, "Luis", 83),
                new Cliente(4, "Marta", 95)
            };

            MaxScoringCliente maxScoringCliente = new MaxScoringCliente();
            Cliente maxCliente = maxScoringCliente.encontrarMaximoScoring(clientes);
            System.out.println("Cliente con máximo scoring: " + maxCliente.nombre + " con scoring de " + maxCliente.scoring);
        }
    }


}
