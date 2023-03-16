enum Format {
    A3,
    A4
}

public class Copiator extends Echipament {
    private int p_ton;
    private Format format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, String stare, int p_ton, String format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = Format.valueOf(format.toUpperCase());
    }

    @Override
    public String toString() {
        return super.toString() + " " + p_ton + " " + format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}