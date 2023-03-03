package ex2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("cantece_in.txt"));
        PrintStream write = new PrintStream("cantece_out.txt");
        String vers;
        Path path = Paths.get("cantece_in.txt");
        int lines = (int) Files.lines(path).count();
        Vers[] versuri = new Vers[lines];
        int i = 0;
        do {
            vers = scan.nextLine();
            versuri[i] = new Vers(vers);
            i++;
        } while (scan.hasNextLine());
        Scanner grup = new Scanner(System.in);
        String selectie;
        System.out.println("Introduceti gruparea cu care sa se termine versul: ");
        selectie = grup.nextLine();
        for (int j = 0; j < i; j++) {
            vers = versuri[j].getV();
            if (versuri[j].majuscule())
                write.println((vers + " " + versuri[j].cuvinte() + " " + versuri[j].vocale() + versuri[j].cuvFinal(selectie)).toUpperCase());
            else
                write.println(vers + " " + versuri[j].cuvinte() + " " + versuri[j].vocale() + versuri[j].cuvFinal(selectie));
        }
    }
}
