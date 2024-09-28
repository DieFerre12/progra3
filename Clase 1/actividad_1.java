public class actividad_1 {
    public static void main(String[] args) {
        int[] numeros = {3, 5, 7, 2, 8, 6}; 

        int maximo = numeros[0]; 

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i]; 
            }
        }

        System.out.println("El valor máximo es: " + maximo);
    }
}
