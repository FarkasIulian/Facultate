package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Scanner fisier = new Scanner(new File("produse.csv"));
        String linie;
        List<Produs> Produse = new ArrayList<>();
        int opt;
        while (fisier.hasNextLine()) {
            linie = fisier.nextLine();
            String[] aux = linie.split(",");
            Produse.add(new Produs(aux[0], Double.parseDouble(aux[1].trim()), Integer.parseInt(aux[2].trim()), LocalDate.parse(aux[3].trim())));
        }
        while (true) {
            System.out.println("1.Afisarea tuturor produselor.");
            System.out.println("2.Afisarea produselor expirate.");
            System.out.println("3.Vanzarea unui produs.");
            System.out.println("4.Afisarea produselor cu pretul minim.");
            System.out.println("5.Salvarea produselor in fisier.");
            System.out.println("6.Iesire.");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    Produs.afisare(Produse);
                    break;
                case 2:
                     Produs.expirate(Produse);
                    break;
                case 3:
                    String denumire = scan.next();
                    int cantitate = scan.nextInt();
                    Produse = Produs.vanzari(Produse, denumire, cantitate);
                    break;
                case 4:
                    Produs.pretMinim(Produse);
                    break;
                case 5:
                    int c;
                    c = scan.nextInt();
                    Produs.scriereFis(Produse,c);
                    break;
                case 6:
                    exit(0);
                default:
                    System.out.println("Optiune incorecta!");
                    break;
            }
        }

    }
}
