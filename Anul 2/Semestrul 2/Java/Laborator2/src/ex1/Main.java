package ex1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "judete_in.txt";
        Scanner scan = new Scanner(new File(fileName));
        Scanner aux = new Scanner(System.in);
        String[] linie = new String[20];
        String cautat;
        int i = 0;
        while (scan.hasNextLine()) {
            linie[i] = scan.nextLine();
            i++;
        }
        String[] judete;
        judete = Arrays.copyOf(linie, i);
        System.out.println("Judete inainte de sortare: ");
        for (i = 0; i < judete.length; i++)
            System.out.println(judete[i]);
        Arrays.sort(judete);
        System.out.println("Judete dupa sortare: ");
        for (i = 0; i < judete.length; i++)
            System.out.println(judete[i]);
        System.out.println("Ce judet cautati? ");
        cautat = aux.nextLine();
        int pos = Arrays.binarySearch(judete, cautat);
        if (pos > 0)
            System.out.println("Judetul " + cautat + " se afla pe pozitia " + pos);
        else System.out.println("Judetul nu exista!");


    }
}