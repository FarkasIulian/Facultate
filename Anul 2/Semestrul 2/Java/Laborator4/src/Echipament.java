import java.io.*;
import java.util.List;
import java.util.Scanner;

enum Stare {
    ACHIZITIONAT,
    EXPUS,
    VANDUT
}


public class Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private Stare stare;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, String stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = Stare.valueOf(stare.toUpperCase());
    }

    @Override
    public String toString() {
        return denumire + " " + nr_inv + " " + pret + " " + zona_mag + " " + stare;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }


    public static void afisare(List<Echipament> echipamentList, int opt) {
        for (Echipament e : echipamentList) {
            if (opt == 1) {
                System.out.println(e.toString());
            } else if (opt == 2) {
                if (e instanceof Imprimanta i) {
                    System.out.println(i);
                } else if (opt == 3) {
                    if (e instanceof Copiator c)
                        System.out.println(c);
                } else if (opt == 4) {
                    if (e instanceof Sistem s)
                        System.out.println(s);
                }
            }
        }
    }

    public static void modificare(List<Echipament> echipamentList, int opt, int index) {
        Scanner scan = new Scanner(System.in);
        boolean ok = false;
        Echipament e = echipamentList.get(index);
        if (opt == 5) {
            do {
                try {
                    System.out.println("Introduceti starea: ");
                    String s = scan.next();
                    System.out.println(s);
                    Stare stare1 = Stare.valueOf(s.toUpperCase());
                    ok = true;
                    e.setStare(stare1);
                } catch (IllegalArgumentException error) {
                    System.out.println(error);
                }
            } while (!ok);
        } else if (opt == 6) {
            do {
                try {
                    System.out.println("Introduceti modul de tiparire: ");
                    String s = scan.next();
                    Tiparire tiparire = Tiparire.valueOf(s.toUpperCase());
                    ((Imprimanta) e).setMod_tiparire(tiparire);
                    ok = true;
                } catch (IllegalArgumentException error) {
                    System.out.println(error);
                }
            } while (!ok);
        } else if (opt == 7) {
            do {
                try {
                    System.out.println("Introduceti formatul: ");
                    String s = scan.next();
                    Format format = Format.valueOf(s.toUpperCase());
                    ((Copiator) e).setFormat(format);
                    ok = true;
                } catch (IllegalArgumentException error) {
                    System.out.println(error);
                }
            } while (!ok);
        } else if (opt == 8) {
            do {
                try {
                    System.out.println("Introduceti sistemul de operare: ");
                    String sir = scan.next();
                    Operare operare = Operare.valueOf(sir.toUpperCase());
                    ((Sistem) e).setS_op(operare);
                    ok = true;
                } catch (IllegalArgumentException error) {
                    System.out.println(error);
                }
            } while (!ok);
        }
    }

    public static void scrie(Object o, String fis) throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object citeste(String fis) throws IOException, ClassNotFoundException {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o = ois.readObject();
            ois.close();
            f.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}