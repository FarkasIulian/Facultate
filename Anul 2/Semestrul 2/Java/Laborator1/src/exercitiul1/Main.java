package exercitiul1;

import java.util.Scanner;
import java.util.SortedMap;

// Dreptunghi cu latime si lungime citite de la tastatura
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double latime, lungime;
        System.out.println("Introduceti lungimea = ");
        lungime = scan.nextDouble();
        System.out.println("Introduceti latimea = ");
        latime = scan.nextDouble();
        double perimetru = (double) 2 * (latime + lungime);
        double arie = lungime * latime;
        System.out.println("Perimetrul dreptunghiului : " + perimetru +
                "\nAria dreptunghiului: " + arie);
    }
}