public class actividad_1_3 {
    public static void main(String[] args) {

        int n = 100; 

        int suma = sumarNumeros(n);

        System.out.println("La suma de los primeros " + n + " números es: " + suma);
    }

    private static int sumarNumeros(int n) {
        if (n == 1) {
            return 1;
        } else { 
            return n + sumarNumeros(n - 1);
        }
    }
}
