package ex1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("parabole.txt"));
        List <Parabola> lista = new ArrayList<>();
        int a,b,c;
        while(scan.hasNextLine()){
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            lista.add(new Parabola(a,b,c));
        }
        for(Parabola p : lista) {
            System.out.print(p);
            System.out.println("\tVarf: (" + p.varf()[0] + ", " + p.varf()[1] + ")" );
        }
        double[] coordonate;
        coordonate = Parabola.mijlocS(lista.get(0),lista.get(lista.size()-1));
        System.out.println("Coordonatele segmentului de mijloc dintre prima si ultima parabola: (" + coordonate[0] + ", " + coordonate[1] + ")");
        System.out.println("Lungimea dintre prima si ultima parabola: " + Parabola.lungimeS(lista.get(0),lista.get(lista.size()-1)));
    }
}