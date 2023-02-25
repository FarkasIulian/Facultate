package exercitiul2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;

//citire numere din fisier
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*BufferedReader flux_in;
        try {
            flux_in = new BufferedReader(new FileReader("in.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        */
        Scanner scan = new Scanner(new File("in.txt"));
        PrintStream flux_out = new PrintStream("out.txt");
        double x, medie, suma = 0, maxim = -1, minim = 99999, n = 0;

        String linie;
        while (scan.hasNext()) {
            linie = scan.next();
            x = Double.parseDouble(linie);
            suma += x;
            if (x > maxim)
                maxim = x;
            if (x < minim)
                minim = x;
            n++;
        }
        medie = suma / n;
        linie = "Minimul este : " + minim +
                "\nMaximul este : " + maxim + "\nSuma este : " + (float) suma +
                "\nMedia este : " + (float) medie;
        System.out.println(linie);
        flux_out.print(linie);
    }
}
