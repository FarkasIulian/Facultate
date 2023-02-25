package exercitiul3;

import java.util.Scanner;

//toti divizorii + prim
public class Main {

    public static void divizori(int n) {
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                System.out.print(i + " ");
        System.out.print("\n");
    }

    public static boolean prim(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduceti un numar = ");
        int n = scan.nextInt();
        System.out.println("Divizorii numarului " + n + " sunt: ");
        divizori(n);
        System.out.print(prim(n) ? "Numarul " + n + " este prim." : "Numarul " + n + " nu este prim.");

    }
}
