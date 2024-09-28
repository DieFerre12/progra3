import java.math.BigInteger;

public class actividad_1_2 {
    public static void main(String[] args) {

        long a = 1000000000L; 
        long b = 2000000000L; 

        long suma = a + b;
        long multiplicacion = a * b;

        System.out.println("Suma (long): " + suma);
        System.out.println("Multiplicación (long): " + multiplicacion);



        BigInteger c = new BigInteger("1000000000000000000"); 
        BigInteger d = new BigInteger("2000000000000000000"); 

        BigInteger sumaint = c.add(d);
        BigInteger multiplicacionint = c.multiply(d);

        System.out.println("Suma (BigInteger): " + sumaint);
        System.out.println("Multiplicación (BigInteger): " + multiplicacionint);
    }

    }

