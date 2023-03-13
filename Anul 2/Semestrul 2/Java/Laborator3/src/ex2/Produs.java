package ex2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data_exp;
    private static double incasari;

    public Produs(String denumire, double pret, int cantitate, LocalDate data_exp) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_exp = data_exp;
        this.incasari = 0;
    }

    @Override
    public String toString() {
        return denumire + ": \npret: " + pret + ", \ncantitate: " + cantitate + ", \ndata expirarii: " + data_exp;
    }

    public static void afisare(List<Produs> prod) {
        for (Produs p : prod)
            System.out.println(p);
    }

    public static void expirate(List<Produs> prod) {
        long nr_zile;
        LocalDate d = LocalDate.now();
        for (Produs p : prod) {
            nr_zile = ChronoUnit.DAYS.between(d, p.data_exp);
            if (nr_zile < 0)
                System.out.println(p);
        }
    }

    public static List<Produs> vanzari(List<Produs> prod,String denumire,int cantitate) {
        for (Produs p : prod){

            if(p.denumire.toLowerCase().equals(denumire.toLowerCase()) && p.cantitate - cantitate >=0){
                incasari += p.pret*cantitate;
                p.cantitate-= cantitate;
                System.out.println("Noua cantitate de " + p.denumire + " este: " + p.cantitate);
                System.out.println("Incasari din vanzari: " + incasari);
            }
        }
        for(int i=0;i<prod.size();i++)
           if(prod.get(i).cantitate == 0)
               prod.remove(i);


        return prod;
    }

    public static void pretMinim(List<Produs> prod){
        double minim = 99999;
        for(Produs p: prod){
            if(p.pret<minim)
                minim = p.pret;
        }
        for(Produs p: prod){
            if(p.pret == minim)
                System.out.println(p);
        }
    }

    public static void scriereFis(List<Produs> prod,int cantitate) throws FileNotFoundException {
        PrintStream write = new PrintStream("out.txt");
        for(Produs p: prod){
            if(p.cantitate < cantitate){
                write.println(p);
            }
        }


    }

}
