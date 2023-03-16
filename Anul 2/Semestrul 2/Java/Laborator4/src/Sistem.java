
enum Operare {
    WINDOWS,
    LINUX
}

public class Sistem extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private Operare s_op;

    public Sistem(String denumire, int nr_inv, double pret, String zona_mag, String stare, String tip_mon, double vit_proc, int c_hdd, String s_op) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.s_op = Operare.valueOf(s_op.toUpperCase());
    }

    @Override
    public String toString() {
        return super.toString() + " " + tip_mon + " " + vit_proc + " " + c_hdd + " " + s_op;
    }

    public void setS_op(Operare s_op) {
        this.s_op = s_op;
    }
}