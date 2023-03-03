package ex4;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("Cate persoane doriti sa introduceti: ");
        n = scan.nextInt();
        scan.nextLine();
        Persoane[] p = new Persoane[n];
        String nume = null, cnp = null;
        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti numele persoanei: ");
            nume = scan.nextLine();
            do {
                System.out.println("Introduceti cnp-ul persoanei: ");
                cnp = scan.nextLine();
            } while (verificare(cnp));
            p[i] = new Persoane(nume,cnp);
        }
        afisare(p);
    }

    public static void afisare(Persoane []p){
        for(int i = 0;i< p.length;i++){
            System.out.println(p[i].getNume() + " " +  p[i].getCnp() + " " + p[i].getVarsta());
        }

    }

    public static boolean verificare(String s){
        boolean ok = true;
        if(lungime(s))
            ok = false;
        if(!ok) {
            ok = true;
            if (cifra_control(s) && !cifre(s))
                ok = false;
        }
        return ok;
    }
    public static boolean lungime(String s) {
        if (s.length() == 13) {
            if (s.charAt(0) == '1' || s.charAt(0) == '2' || s.charAt(0) == '5' || s.charAt(0) == '6')
                return true;
        }
        return false;
    }

    public static boolean cifre(String s) {
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                return true;
        return false;
    }

    public static boolean cifra_control(String s) {
        int[] array = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int control, j = 0, aux, sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            aux = Character.getNumericValue(s.charAt(i));
            aux *= array[j];
            sum += aux;
            j++;
        }
        if (sum % 11 == 10)
            control = 1;
        else
            control = sum % 11;
        if (control != Character.getNumericValue(s.charAt(s.length() - 1)))
            return false;
        return true;
    }


}
