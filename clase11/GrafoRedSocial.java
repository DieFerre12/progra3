package clase11;

import java.util.*;

public class GrafoRedSocial {
    private Map<Integer, Usuario> usuarios; // Mapa de ID a Usuario
    private Map<Integer, List<Integer>> amistades; // Lista de adyacencia para amistades

    public GrafoRedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }

    // Agregar un usuario a la red
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        amistades.put(usuario.getId(), new ArrayList<>());
    }

    // Conectar dos usuarios como amigos (relación bidireccional)
    public void conectarAmistad(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Recorrido BFS desde un usuario dado
    public void BFS(int inicio) {
        if (!usuarios.containsKey(inicio)) {
            System.out.println("Usuario de inicio no encontrado.");
            return;
        }

        boolean[] visitado = new boolean[usuarios.size()];
        Queue<Integer> cola = new LinkedList<>();
        
        visitado[inicio] = true;
        cola.add(inicio);

        System.out.println("Recorrido BFS desde " + usuarios.get(inicio).getNombre() + ":");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(usuarios.get(actual) + " -> ");

            for (int amigo : amistades.get(actual)) {
                if (!visitado[amigo]) {
                    visitado[amigo] = true;
                    cola.add(amigo);
                }
            }
        }
        System.out.println("Fin");
    }

    // Recorrido DFS desde un usuario dado
    public void DFS(int inicio) {
        if (!usuarios.containsKey(inicio)) {
            System.out.println("Usuario de inicio no encontrado.");
            return;
        }

        boolean[] visitado = new boolean[usuarios.size()];
        System.out.println("Recorrido DFS desde " + usuarios.get(inicio).getNombre() + ":");
        DFSUtil(inicio, visitado);
        System.out.println("Fin");
    }

    // Método auxiliar para DFS (recursivo)
    private void DFSUtil(int actual, boolean[] visitado) {
        visitado[actual] = true;
        System.out.print(usuarios.get(actual) + " -> ");

        for (int amigo : amistades.get(actual)) {
            if (!visitado[amigo]) {
                DFSUtil(amigo, visitado);
            }
        }
    }

    // Método main para probar el sistema
    public static void main(String[] args) {
        GrafoRedSocial red = new GrafoRedSocial();

        // Crear usuarios
        Usuario u1 = new Usuario(0, "Alice");
        Usuario u2 = new Usuario(1, "Bob");
        Usuario u3 = new Usuario(2, "Charlie");
        Usuario u4 = new Usuario(3, "David");
        Usuario u5 = new Usuario(4, "Eve");

        // Agregar usuarios a la red
        red.agregarUsuario(u1);
        red.agregarUsuario(u2);
        red.agregarUsuario(u3);
        red.agregarUsuario(u4);
        red.agregarUsuario(u5);

        // Conectar amistades
        red.conectarAmistad(0, 1); // Alice <-> Bob
        red.conectarAmistad(1, 2); // Bob <-> Charlie
        red.conectarAmistad(1, 3); // Bob <-> David
        red.conectarAmistad(3, 4); // David <-> Eve

        // Realizar recorridos
        System.out.println();
        red.BFS(0); // Recorrido BFS desde Alice

        System.out.println();
        red.DFS(0); // Recorrido DFS desde Alice
    }
}
