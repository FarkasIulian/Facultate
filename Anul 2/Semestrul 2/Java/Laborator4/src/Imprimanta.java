import java.util.Scanner;

enum Tiparire {
    COLOR,
    ALB_NEGRU
}

public class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private Tiparire mod_tiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, String stare, int ppm, String rezolutie, int p_car, String mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_tiparire = Tiparire.valueOf(mod_tiparire.toUpperCase());
    }

    @Override
    public String toString() {
        return super.toString() + " " + ppm + " " + rezolutie + " " + p_car + " " + mod_tiparire;
    }
    public void setMod_tiparire(Tiparire mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }
}