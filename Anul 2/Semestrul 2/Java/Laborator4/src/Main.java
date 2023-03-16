import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

enum Tip {
    IMPRIMANTA,
    COPIATOR,
    SISTEMDECALCUL
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner f = new Scanner(new File("inventar.txt"));
        List<Echipament> echipamentList = new ArrayList<>();
        int nr_imprimante = 0, nr_copiatoare = 0, nr_sisteme = 0;
        while (f.hasNextLine()) {
            String line = f.nextLine();
            String[] info = line.split(";");
            String denumire = info[0];
            int nr_inv = Integer.parseInt(info[1]);
            double pret = Double.parseDouble(info[2]);
            String zona_mag = info[3];
            String stare = info[4].toUpperCase();
            Tip t = Tip.valueOf(info[5].toUpperCase());
            switch (t) {
                case IMPRIMANTA -> {
                    int ppm = Integer.parseInt(info[6]);
                    String rezolutie = info[7];
                    int p_car = Integer.parseInt(info[8]);
                    String mod = info[9];
                    Echipament e1 = new Imprimanta(denumire, nr_inv, pret, zona_mag, stare, ppm, rezolutie, p_car, mod);
                    echipamentList.add(e1);
                    nr_imprimante++;
                }
                case COPIATOR -> {
                    int p_ton = Integer.parseInt(info[6]);
                    String format = info[7].toUpperCase();
                    Echipament e2 = new Copiator(denumire, nr_inv, pret, zona_mag, stare, p_ton, format);
                    echipamentList.add(e2);
                    nr_copiatoare++;
                }
                case SISTEMDECALCUL -> {
                    String tip_mon = info[6];
                    double vit_proc = Double.parseDouble(info[7]);
                    int c_hdd = Integer.parseInt(info[8]);
                    String s_op = info[9].toUpperCase();
                    Echipament e3 = new Sistem(denumire, nr_inv, pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, s_op);
                    echipamentList.add(e3);
                    nr_sisteme++;
                }
                default -> System.out.println("Tipul cautat nu exista!");
            }
        }
        Scanner scan = new Scanner(System.in);
        int opt, index, contor = 0;
        while (true) {
            System.out.println("1.Afisarea tuturor echipamentelor.");
            System.out.println("2.Afisare imprimante.");
            System.out.println("3.Afisare copiatoare.");
            System.out.println("4.Afisare sisteme de calcul.");
            System.out.println("5.Modificare stare echipament.");
            System.out.println("6.Modificare mod scriere imprimanta.");
            System.out.println("7.Modificare formatul copiator.");
            System.out.println("8.Modificare sistem operare.");
            System.out.println("9.Afisare echipamente vandute.");
            System.out.println("10.Serializare / deserializare.");
            System.out.println("11.Iesire.");
            opt = scan.nextInt();
            switch (opt) {
                case 1, 2, 3, 4 -> Echipament.afisare(echipamentList, opt);
                case 5 -> {
                    System.out.println("Sunt " + echipamentList.size() + " echipamente.");
                    System.out.println("Starea carui echipament doriti sa o modificati?");
                    index = scan.nextInt() - 1;
                    Echipament.modificare(echipamentList, opt, index);
                }
                case 6 -> {
                    System.out.println("Sunt " + nr_imprimante + " imprimante.");
                    System.out.println("A cata imprimanta doriti sa o modificati? ");
                    index = scan.nextInt();
                    for (Echipament e : echipamentList) {
                        if (e instanceof Imprimanta)
                            contor++;
                        if (contor == index) {
                            index = echipamentList.indexOf(e);
                            contor = 0;
                            break;
                        }
                    }
                    Echipament.modificare(echipamentList, opt, index);
                }
                case 7 -> {
                    System.out.println("Sunt " + nr_copiatoare + " copiatoare.");
                    System.out.println("Al catelea copiator doriti sa-l modificati? ");
                    index = scan.nextInt();
                    for (Echipament e : echipamentList) {
                        if (e instanceof Copiator)
                            contor++;
                        if (contor == index) {
                            index = echipamentList.indexOf(e);
                            contor = 0;
                            break;
                        }
                    }
                    Echipament.modificare(echipamentList, opt, index);
                }
                case 8 -> {
                    System.out.println("Sunt " + nr_sisteme + " sisteme de calcul.");
                    System.out.println("Al catelea sistem de calcul doriti sa-l modificati? ");
                    index = scan.nextInt();
                    for (Echipament e : echipamentList) {
                        if (e instanceof Sistem)
                            contor++;
                        if (contor == index) {
                            index = echipamentList.indexOf(e);
                            contor = 0;
                            break;
                        }
                    }
                    Echipament.modificare(echipamentList, opt, index);
                }
                case 9 -> {
                    for (Echipament e : echipamentList) {
                        if (e.getStare().equals(Stare.VANDUT))
                            System.out.println(e);
                    }
                }
                case 10 -> {
                    Echipament.scrie(echipamentList, "echip.bin");
                    List<Echipament> serializedList;
                    serializedList = (List<Echipament>) Echipament.citeste("echip.bin");
                    assert serializedList != null;
                    for (Echipament e : serializedList)
                        System.out.println(e);
                }
                case 11 -> exit(0);
                default -> System.out.println("Optiune incorecta!");
            }
        }
    }
}