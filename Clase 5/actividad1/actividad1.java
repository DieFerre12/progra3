package progra3.clase5.actividad1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class actividad1 {
    
    // Representación de la red social como un grafo dirigido (lista de adyacencia)
    private List<List<Integer>> followersGraph;
    
    // Constructor que inicializa la lista de adyacencia
    public actividad1(int numUsuarios) {
        followersGraph = new ArrayList<>(); // Inicializamos la lista
        for (int i = 0; i < numUsuarios; i++) {
            followersGraph.add(new ArrayList<>()); // Añadimos una lista vacía para cada usuario
        }
    }
    
    // Método para seguir a un usuario
    public void follow(int follower, int followed) {
        if (follower >= 0 && follower < followersGraph.size() && followed >= 0 && followed < followersGraph.size()) {
            followersGraph.get(follower).add(followed);
        }
    }
    
    // Método para mostrar a quién sigue un usuario
    public void showFollowing(int user) {
        if (user >= 0 && user < followersGraph.size()) {
            List<Integer> following = followersGraph.get(user);
            System.out.println("Usuario " + user + " sigue a: " + following);
        }
    }

    // Método para mostrar quién sigue a un usuario
    public void showFollowers(int user) {
        if (user >= 0 && user < followersGraph.size()) {
            List<Integer> followers = new ArrayList<>();
            for (int i = 0; i < followersGraph.size(); i++) {
                if (followersGraph.get(i).contains(user)) {
                    followers.add(i);
                }
            }
            System.out.println("Usuario " + user + " es seguido por: " + followers);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de usuarios: ");
        int numUsuarios = scanner.nextInt();

        // Crear la red social con el número de usuarios especificado
        actividad1 redSocial = new actividad1(numUsuarios);
        
        // Ejemplo de seguir usuarios
        redSocial.follow(0, 1); // Usuario 0 sigue a Usuario 1
        redSocial.follow(0, 2); // Usuario 0 sigue a Usuario 2
        redSocial.follow(1, 2); // Usuario 1 sigue a Usuario 2
        redSocial.follow(3, 0); // Usuario 3 sigue a Usuario 0

        // Mostrar quién sigue a quién
        for (int i = 0; i < numUsuarios; i++) {
            redSocial.showFollowing(i);
            redSocial.showFollowers(i);
        }

        scanner.close();
    }
}
