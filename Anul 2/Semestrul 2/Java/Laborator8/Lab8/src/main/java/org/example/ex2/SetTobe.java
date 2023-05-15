package org.example.ex2;

enum TipTobe{
    ELECTRICE,
    ACUSTICE
}
public class SetTobe extends InstrumentMuzical{
    private TipTobe tip_tobe;
    private Integer nr_tobe,nr_cinele;

    public SetTobe() {}

    public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public TipTobe getTip_tobe() {
        return tip_tobe;
    }

    public Integer getNr_tobe() {
        return nr_tobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tip_tobe.toString() + ", " + nr_tobe + ", " + nr_cinele;
    }
}
