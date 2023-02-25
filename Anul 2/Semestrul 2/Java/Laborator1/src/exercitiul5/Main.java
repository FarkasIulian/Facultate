package exercitiul5;

import java.util.Random;

//fibonacci
public class Main {

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(20);
        int aux;
        boolean ok = false;
        System.out.print("Secventa fibonacci pana la 21:\n");
        for (int i = 0; i <= 8; i++) {
            aux = fibonacci(i);
            System.out.print(aux + " ");
            if (n == aux)
                ok = true;
        }
        System.out.println(ok ? "\nNumarul " + n + " apartine secventei fibonacci."
                : "\nNumarul " + n + " nu apartine secventei fibonacci.");
        }
    }
